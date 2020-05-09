package szot.pl.simplejobboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import szot.pl.simplejobboard.model.Advertisement;
import szot.pl.simplejobboard.repository.AdvertisementRepository;

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
        Assertions.assertEquals(optionalAdvertisement,advertisementService.findById(2L));
    }

    @Test
    void advertisementServiceImplShouldDeleteAdvertisement() {
    }

    @Test
    void advertisementServiceImplShouldDeleteByIdAdvertisement() {
    }
}