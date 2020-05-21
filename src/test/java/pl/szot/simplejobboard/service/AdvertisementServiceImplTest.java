package pl.szot.simplejobboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.szot.simplejobboard.model.Advertisement;
import pl.szot.simplejobboard.repository.AdvertisementRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

class AdvertisementServiceImplTest {

    @Mock
    AdvertisementRepository advertisementRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void advertisementServiceImplShouldSaveAdvertisement() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        Mockito.when(advertisementRepository.saveAndFlush(Mockito.any())).thenReturn(new Advertisement());
        Assertions.assertNotNull(advertisementService.save(new Advertisement()));
    }

    @Test
    void advertisementServiceImplShouldFindAllAdvertisements() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        Mockito.when(advertisementRepository.findAll((Pageable) Mockito.any())).thenReturn(new PageImpl<>(advertisements));
        Assertions.assertEquals(advertisements, advertisementService.findAll(1, 2).toList());
    }

    @Test
    void advertisementServiceImplShouldFindAllNotExpiredAdvertisements() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        //add expired advertisement
        advertisements.add(new Advertisement.Builder().expirationDate(LocalDateTime.now().minusDays(2L)).build());
        //add not expired advertisement
        advertisements.add(new Advertisement.Builder().expirationDate(LocalDateTime.now().plusDays(2L)).build());
        Mockito.when(advertisementRepository.findAll((Pageable) Mockito.any())).thenReturn(new PageImpl<>(advertisements));
        Assertions.assertEquals(1, advertisementService.findAllNotExpired(1, 2).toList().size(), "advertisement service should find all not expired advertisements");
    }

    @Test
    void advertisementServiceImplShouldSearchAdvertisements() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        Mockito.when(advertisementRepository.findAllByTitleContaining((Pageable) Mockito.any(), Mockito.any())).thenReturn(new PageImpl<>(advertisements));
        Assertions.assertEquals(advertisements, advertisementService.search(1, 2, "test").toList());
    }

    @Test
    void advertisementServiceImplShouldFindById() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        Optional<Advertisement> optionalAdvertisement = Optional.of(new Advertisement());
        Mockito.when(advertisementRepository.findById(Mockito.anyLong())).thenReturn(optionalAdvertisement);
        Assertions.assertEquals(optionalAdvertisement, advertisementService.findById(2L));
    }

    @Test
    void advertisementServiceImplShouldDeleteAdvertisement() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        Advertisement advertisement = new Advertisement();
        advertisementService.delete(advertisement);
        Mockito.verify(advertisementRepository, Mockito.times(1)).delete(advertisement);
    }

    @Test
    void advertisementServiceImplShouldDeleteById() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        final Long ID = 2L;
        advertisementService.deleteById(ID);
        Mockito.verify(advertisementRepository, Mockito.times(1)).deleteById(ID);
    }

    @Test
    void advertisementServiceImplShouldFindAllNotExpiredAndNotHiddenAdvertisements() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        //add expired advertisement
        advertisements.add(new Advertisement.Builder().hidden(false).expirationDate(LocalDateTime.now().minusDays(2L)).build());
        //add not expired advertisement
        advertisements.add(new Advertisement.Builder().hidden(false).expirationDate(LocalDateTime.now().plusDays(2L)).build());
        //add hidden advertisement
        advertisements.add(new Advertisement.Builder().hidden(true).expirationDate(LocalDateTime.now().plusDays(2L)).build());
        //add not hidden advertisement
        advertisements.add(new Advertisement.Builder().hidden(false).expirationDate(LocalDateTime.now().minusDays(2L)).build());
        Mockito.when(advertisementRepository.findAll((Pageable) Mockito.any())).thenReturn(new PageImpl<>(advertisements));
        Assertions.assertEquals(1, advertisementService.findAllNotExpiredAndNotHidden(2, 4).toList().size(), "advertisement service should find all not expired and not hidden advertisements");
    }

    @Test
    void advertisementServiceImplShouldFindAllNotHiddenAdvertisements() {
        AdvertisementService advertisementService = new AdvertisementServiceImpl(advertisementRepository);
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        //add hidden advertisement
        advertisements.add(new Advertisement.Builder().hidden(true).build());
        //add not hidden advertisement
        advertisements.add(new Advertisement.Builder().hidden(false).build());
        Mockito.when(advertisementRepository.findAll((Pageable) Mockito.any())).thenReturn(new PageImpl<>(advertisements));
        Assertions.assertEquals(1, advertisementService.findAllNotHidden(1, 2).toList().size(), "advertisement service should find all not hidden advertisements");
    }

}