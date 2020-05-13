package szot.pl.simplejobboard.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import szot.pl.simplejobboard.dto.UserDTO;
import szot.pl.simplejobboard.model.User;
import szot.pl.simplejobboard.service.UserService;

class UserMapperTest {

    @Mock
    UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void UserMapperShouldMapToDto() {
        final Long id = 2L;
        final String username = "testUsername";
        final String email = "test@test.test";
        UserMapper userMapper = new UserMapper(userService);
        User user = new User.Builder().id(id).username(username).email(email).build();
        var userDTO = userMapper.mapToDto(user);
        Assertions.assertEquals(username, userDTO.getUsername());
        Assertions.assertEquals(email, userDTO.getEmail());
        Assertions.assertEquals(id, userDTO.getId());
    }

    @Test
    void UserMapperShouldMapToEntity() {
        final Long id = 2L;
        final String username = "testUsername";
        final String email = "test@test.test";
        UserMapper userMapper = new UserMapper(userService);
        Mockito.when(userService.findUserById(id)).thenReturn(java.util.Optional.ofNullable(new User.Builder().id(id).build()));
        var userDTO = new UserDTO.Builder().id(id).username(username).email(email).build();
        var user = userMapper.mapToEntity(userDTO);
        Assertions.assertEquals(username, user.getUsername());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(id, user.getId());
    }
}