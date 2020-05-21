package pl.szot.simplejobboard.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AdvertisementTest {

    @Test
    public void advertisementShouldContainIdField() {
        final Long ID = 0L;
        Advertisement advertisement = new Advertisement();
        advertisement.setId(ID);
        Assertions.assertEquals(advertisement.getId(), ID, "advertisement should contain id field");
    }

    @Test
    public void advertisementShouldContainTitleField() {
        final String TITLE = "test title";
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(TITLE);
        Assertions.assertEquals(advertisement.getTitle(), TITLE, "advertisement should contain title field");
    }

    @Test
    public void advertisementShouldContainContentField() {
        final String CONTENT = "test content";
        Advertisement advertisement = new Advertisement();
        advertisement.setContent(CONTENT);
        Assertions.assertEquals(advertisement.getContent(), CONTENT, "advertisement should contain content field");
    }

    @Test
    public void advertisementShouldContainCreationTimeField() {
        final LocalDateTime CREATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement();
        advertisement.setCreationDate(CREATION_DATE);
        Assertions.assertEquals(advertisement.getCreationDate(), CREATION_DATE, "advertisement should contain creation date field");
    }

    @Test
    public void advertisementShouldContainExpirationTimeField() {
        final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement();
        advertisement.setExpirationDate(EXPIRATION_DATE);
        Assertions.assertEquals(advertisement.getExpirationDate(), EXPIRATION_DATE, "advertisement should contain expiration date field");
    }

    @Test
    public void advertisementBuilderShouldCreateAnObjectWithTheValidTitleField() {
        final String TITLE = "test title";
        Advertisement advertisement = new Advertisement.Builder().title(TITLE).build();
        Assertions.assertEquals(advertisement.getTitle(), TITLE, "advertisement builder should create an object with the valid title field");
    }

    @Test
    public void advertisementBuilderShouldCreateAnObjectWithTheValidContentField() {
        final String CONTENT = "test content";
        Advertisement advertisement = new Advertisement.Builder().content(CONTENT).build();
        Assertions.assertEquals(advertisement.getContent(), CONTENT, "advertisement builder should create an object with the valid content field");
    }

    @Test
    public void advertisementBuilderShouldCreateAnObjectWithTheValidIdField() {
        final Long ID = 0L;
        Advertisement advertisement = new Advertisement.Builder().id(ID).build();
        Assertions.assertEquals(advertisement.getId(), ID, "advertisement builder should create an object with the valid id field");
    }

    @Test
    public void advertisementBuilderShouldCreateAnObjectWithTheValidCreationDateField() {
        final LocalDateTime CREATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement.Builder().creationDate(CREATION_DATE).build();
        Assertions.assertEquals(advertisement.getCreationDate(), CREATION_DATE, "advertisement builder should create a object with valid creation date field");
    }

    @Test
    public void advertisementBuilderShouldCreateAnObjectWithTheValidExpirationDateField() {
        final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement.Builder().expirationDate(EXPIRATION_DATE).build();
        Assertions.assertEquals(advertisement.getExpirationDate(), EXPIRATION_DATE, "advertisement builder should create a object with valid expiration date field");
    }

}

