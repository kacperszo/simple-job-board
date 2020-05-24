package pl.szot.simplejobboard.controller;

import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.szot.simplejobboard.dto.AdvertisementDTO;
import pl.szot.simplejobboard.exceptions.BadRequestException;
import pl.szot.simplejobboard.exceptions.NotFoundException;
import pl.szot.simplejobboard.mapper.AdvertisementMapper;
import pl.szot.simplejobboard.model.Advertisement;
import pl.szot.simplejobboard.requests.CreateAdvertisementRequest;
import pl.szot.simplejobboard.requests.UpdateAdvertisementRequest;
import pl.szot.simplejobboard.service.AdvertisementService;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("api/v1/advertisements")
public class AdvertisementController {
    private AdvertisementService advertisementService;
    private AdvertisementMapper advertisementMapper;

    public AdvertisementController(AdvertisementService advertisementService, AdvertisementMapper advertisementMapper) {
        this.advertisementService = advertisementService;
        this.advertisementMapper = advertisementMapper;
    }

    @GetMapping("/{id}")
    public AdvertisementDTO getAdvertisement(@PathVariable Long id, Authentication authentication) {
        if (isAdminLoggedIn(authentication)) {
            return advertisementMapper.mapToDto(advertisementService.findById(id).orElseThrow(() -> new NotFoundException("advertisement do not exist")));
        }

        Optional<Advertisement> advertisement = advertisementService.findById(id);

        if (advertisement.isEmpty() || advertisement.get().isHidden()) {
            throw new NotFoundException("advertisement do not exist");
        }

        return advertisementMapper.mapToDto(advertisement.get());

    }

    @GetMapping
    public Page<AdvertisementDTO> getAdvertisements(
            Authentication authentication,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize
    ) {
        if (isAdminLoggedIn(authentication)) {
            return advertisementService.findAll(pageNo, pageSize).map(s -> advertisementMapper.mapToDto(s));
        }
        return advertisementService.findAllNotExpiredAndNotHidden(pageNo, pageSize).map(s -> advertisementMapper.mapToDto(s));
    }

    @PostMapping("/{id}")
    public AdvertisementDTO update(@PathVariable Long id, @Valid @RequestBody UpdateAdvertisementRequest request, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        Optional<Advertisement> advertisementOptional = advertisementService.findById(id);
        if (advertisementOptional.isEmpty()) {
            throw new NotFoundException("advertisement do not exist");
        }

        advertisementOptional.get().setTitle(request.getTitle());
        advertisementOptional.get().setContent(request.getContent());
        advertisementOptional.get().setHidden(request.getHidden());
        advertisementOptional.get().setExpirationDate(request.getExpirationDate());

        return advertisementMapper.mapToDto(advertisementService.save(advertisementOptional.get()));
    }

    @PostMapping()
    public AdvertisementDTO create(@Valid @RequestBody CreateAdvertisementRequest request, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        Advertisement advertisement = new Advertisement.Builder()
                .title(request.getTitle())
                .content(request.getContent())
                .expirationDate(request.getExpirationDate())
                .hidden(request.getHidden())
                .build();
        return advertisementMapper.mapToDto(advertisementService.save(advertisement));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        advertisementService.deleteById(id);
    }


    private boolean isAdminLoggedIn(Authentication authentication) {
        return authentication != null;
    }
}
