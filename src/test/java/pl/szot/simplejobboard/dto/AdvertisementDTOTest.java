package pl.szot.simplejobboard.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AdvertisementDTOTest {
    @Test
    public void advertisementDTOShouldContainIdField() {
        final Long ID = 0L;
        AdvertisementDTO advertisement = new AdvertisementDTO();
        advertisement.setId(ID);
        assertEquals(advertisement.getId(), ID, "advertisement should contain id field");
    }

    @Test
    public void advertisementDTOShouldContainTitleField() {
        final String TITLE = "test title";
        AdvertisementDTO advertisement = new AdvertisementDTO();
        advertisement.setTitle(TITLE);
        assertEquals(advertisement.getTitle(), TITLE, "advertisement should contain title field");
    }

    @Test
    public void advertisementDTOShouldContainContentField() {
        final String CONTENT = "test content";
        AdvertisementDTO advertisement = new AdvertisementDTO();
        advertisement.setContent(CONTENT);
        assertEquals(advertisement.getContent(), CONTENT, "advertisement should contain content field");
    }

    @Test
    public void advertisementDTOShouldContainCreationTimeField() {
        final LocalDateTime CREATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        AdvertisementDTO advertisement = new AdvertisementDTO();
        advertisement.setCreationDate(CREATION_DATE);
        assertEquals(advertisement.getCreationDate(), CREATION_DATE, "advertisement should contain creation date field");
    }

    @Test
    public void advertisementDTOShouldContainExpirationTimeField() {
        final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        AdvertisementDTO advertisement = new AdvertisementDTO();
        advertisement.setExpirationDate(EXPIRATION_DATE);
        assertEquals(advertisement.getExpirationDate(), EXPIRATION_DATE, "advertisement should contain expiration date field");
    }

    @Test
    public void advertisementDTOBuilderShouldCreateAnObjectWithTheValidTitleField() {
        final String TITLE = "test title";
        AdvertisementDTO advertisement = new AdvertisementDTO.Builder().title(TITLE).build();
        assertEquals(advertisement.getTitle(), TITLE, "advertisement builder should create an object with the valid title field");
    }

    @Test
    public void advertisementDTOBuilderShouldCreateAnObjectWithTheValidContentField() {
        final String CONTENT = "test content";
        AdvertisementDTO advertisement = new AdvertisementDTO.Builder().content(CONTENT).build();
        assertEquals(advertisement.getContent(), CONTENT, "advertisement builder should create an object with the valid content field");
    }

    @Test
    public void advertisementDTOBuilderShouldCreateAnObjectWithTheValidIdField() {
        final Long ID = 0L;
        AdvertisementDTO advertisement = new AdvertisementDTO.Builder().id(ID).build();
        assertEquals(advertisement.getId(), ID, "advertisement builder should create an object with the valid id field");
    }

    @Test
    public void advertisementDTOBuilderShouldCreateAnObjectWithTheValidCreationDateField() {
        final LocalDateTime CREATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        AdvertisementDTO advertisement = new AdvertisementDTO.Builder().creationDate(CREATION_DATE).build();
        assertEquals(advertisement.getCreationDate(), CREATION_DATE, "advertisement builder should create a object with valid creation date field");
    }

    @Test
    public void advertisementDTOBuilderShouldCreateAnObjectWithTheValidExpirationDateField() {
        final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        AdvertisementDTO advertisement = new AdvertisementDTO.Builder().expirationDate(EXPIRATION_DATE).build();
        assertEquals(advertisement.getExpirationDate(), EXPIRATION_DATE, "advertisement builder should create a object with valid expiration date field");
    }

}