package szot.pl.simplejobboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import szot.pl.simplejobboard.model.Advertisement;
import szot.pl.simplejobboard.repository.AdvertisementRepository;

import java.util.Optional;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.saveAndFlush(advertisement);
    }

    @Override
    public Page<Advertisement> findAll(int pageNumber, int pageSize) {
        return advertisementRepository.findAll(PageRequest.of(pageNumber,pageSize));
    }

    @Override
    public Page<Advertisement> search(int pageNumber, int pageSize, String query) {
        return null;
    }

    @Override
    public Optional<Advertisement> getAdvertisementById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Advertisement advertisement) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
