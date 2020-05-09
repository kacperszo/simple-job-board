package szot.pl.simplejobboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import szot.pl.simplejobboard.model.Advertisement;
import szot.pl.simplejobboard.repository.AdvertisementRepository;

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
    void advertisementServiceImplShouldFindAllAdvertisement() {
    }

    @Test
    void advertisementServiceImplShouldSearchAdvertisement() {
    }

    @Test
    void advertisementServiceImplShouldgetAdvertisementByIdAdvertisement() {
    }

    @Test
    void advertisementServiceImplShouldDeleteAdvertisement() {
    }

    @Test
    void advertisementServiceImplShouldDeleteByIdAdvertisement() {
    }
}