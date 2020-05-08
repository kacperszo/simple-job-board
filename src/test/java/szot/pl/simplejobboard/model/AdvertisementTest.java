package szot.pl.simplejobboard.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AdvertisementTest {

    @Test
    public void AdvertisementShouldContainIdField() {
        final Long ID = 0L;
        Advertisement advertisement = new Advertisement();
        advertisement.setId(ID);
        Assertions.assertEquals(advertisement.getId(), ID, "advertisement should contain id field");
    }

    @Test
    public void AdvertisementShouldContainTitleField() {
        final String TITLE = "test title";
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(TITLE);
        Assertions.assertEquals(advertisement.getTitle(), TITLE, "advertisement should contain title field");
    }

    @Test
    public void AdvertisementShouldContainContentField() {
        final String CONTENT = "test content";
        Advertisement advertisement = new Advertisement();
        advertisement.setContent(CONTENT);
        Assertions.assertEquals(advertisement.getContent(), CONTENT, "advertisement should contain content field");
    }

    @Test
    public void AdvertisementShouldContainCreationTimeField() {
        final LocalDateTime CREATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement();
        advertisement.setCreationDate(CREATION_DATE);
        Assertions.assertEquals(advertisement.getCreationDate(), CREATION_DATE, "advertisement should contain creation date field");
    }

    @Test
    public void AdvertisementShouldContainExpirationTimeField() {
        final LocalDateTime EXPIRATION_DATE = LocalDateTime.of(2020, 5, 8, 18, 0);
        Advertisement advertisement = new Advertisement();
        advertisement.setExpirationDate(EXPIRATION_DATE);
        Assertions.assertEquals(advertisement.getExpirationDate(), EXPIRATION_DATE, "advertisement should contain expiration date field");
    }

}

