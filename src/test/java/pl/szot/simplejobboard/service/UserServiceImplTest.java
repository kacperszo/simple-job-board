package pl.szot.simplejobboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.szot.simplejobboard.model.User;
import pl.szot.simplejobboard.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void userServiceShouldFindUserById() {
        final Long id = 2L;
        UserService userService = new UserServiceImpl(userRepository);
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(new User.Builder().id(id).build()));
        Assertions.assertEquals(id, userService.findUserById(id).get().getId());
    }

    @Test
    void userServiceShouldSaveUser() {
        UserService userService = new UserServiceImpl(userRepository);
        var user = new User();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(user, userService.save(user));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void userServiceShouldFindAllUsers() {
        UserService userService = new UserServiceImpl(userRepository);
        var user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assertions.assertEquals(users, userService.findAll());
    }

    @Test
    void userServiceShouldDeleteUser() {
        UserService userService = new UserServiceImpl(userRepository);
        var user = new User();
        userService.delete(user);
        Mockito.verify(userRepository, Mockito.times(1)).delete(user);
    }

    @Test
    void userServiceShouldDeleteUserById() {
        UserService userService = new UserServiceImpl(userRepository);
        Long id = 2L;
        userService.deleteById(id);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    void userServiceShouldLoadUserByUsernameIfUserExist() {
        UserService userService = new UserServiceImpl(userRepository);
        String username = "test";
        var user = new User.Builder().username(username).build();
        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.ofNullable(user));
        Assertions.assertEquals(user, userService.loadUserByUsername(username));
    }

    @Test
    void userServiceLoadUserByUsernameShouldThrowExceptionWhenUsernameDontExist() {
        UserService userService = new UserServiceImpl(userRepository);
        String username = "test";
        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
    }
}