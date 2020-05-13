package szot.pl.simplejobboard.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOTest {

    @Test
    void userDTOShouldContainsTheIdProperty() {
        final Long id = 2L;
        var userDTO = new UserDTO();
        userDTO.setId(id);
        assertEquals(id, userDTO.getId());
    }

    @Test
    void userDTOShouldContainsTheEmailProperty() {
        final String email = "test@test.test";
        var userDTO = new UserDTO();
        userDTO.setEmail(email);
        assertEquals(email, userDTO.getEmail());
    }

    @Test
    void userDTOShouldContainsTheUsernameProperty() {
        final String username = "test";
        var userDTO = new UserDTO();
        userDTO.setUsername(username);
        assertEquals(username, userDTO.getUsername());
    }

    @Test
    void userDTOBuilderShouldContainsTheIdProperty() {
        final Long id = 2L;
        var userDTO = new UserDTO.Builder().id(id).build();
        assertEquals(id, userDTO.getId());
    }

    @Test
    void userDTOBuilderShouldContainsTheEmailProperty() {
        final String email = "test@test.test";
        var userDTO = new UserDTO.Builder().email(email).build();
        assertEquals(email, userDTO.getEmail());
    }

    @Test
    void userDTOBuilderShouldContainsTheUsernameProperty() {
        final String username = "test";
        var userDTO = new UserDTO.Builder().username(username).build();
        assertEquals(username, userDTO.getUsername());
    }

}