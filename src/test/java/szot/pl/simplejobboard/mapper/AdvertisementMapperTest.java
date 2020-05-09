package szot.pl.simplejobboard.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import szot.pl.simplejobboard.dto.AdvertisementDTO;
import szot.pl.simplejobboard.model.Advertisement;

class AdvertisementMapperTest {
    @Test
    void advertisementMapperShouldMapEntityToDTOAndDTOToEntity() {
        Advertisement advertisement = new Advertisement.Builder()
                .id(2L)
                .title("test")
                .build();
        AdvertisementMapper mapper = new AdvertisementMapper();
        AdvertisementDTO advertisementDTO = mapper.mapToDto(advertisement);
        Assertions.assertEquals(advertisement,mapper.mapToEntity(advertisementDTO));
    }
}