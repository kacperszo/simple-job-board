package pl.szot.simplejobboard.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void userShouldContainsTheIdProperty() {
        final Long id = 2L;
        var user = new User();
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void userShouldContainsTheUsernameProperty() {
        final String username = "test";
        var user = new User();
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    void userShouldContainsThePasswordProperty() {
        final String password = "test";
        var user = new User();
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    void userShouldContainsTheEmailProperty() {
        final String email = "test@test.test";
        var user = new User();
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    void userShouldContainsTheEnabledProperty() {
        final boolean enabled = false;
        var user = new User();
        user.setEnabled(enabled);
        assertEquals(enabled, user.isEnabled());
    }

    @Test
    void userShouldContainsTheExpiredProperty() {
        final boolean expired = false;
        var user = new User();
        user.setExpired(expired);
        assertEquals(expired, !user.isAccountNonExpired());
    }

    @Test
    void userShouldContainsTheLockedProperty() {
        final boolean locked = false;
        var user = new User();
        user.setLocked(locked);
        assertEquals(locked, !user.isAccountNonLocked());
    }

    @Test
    void userShouldContainsTheAuthoritiesProperty() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role.Builder().id(2L).authority("test").build());
        User user = new User();
        user.setAuthorities(roles);
        assertEquals(roles, user.getAuthorities());
    }

    @Test
    void userBuilderShouldContainsTheIdProperty() {
        final Long id = 2L;
        User user = new User.Builder().id(id).build();
        assertEquals(id, user.getId());
    }

    @Test
    void userBuilderShouldContainsTheUsernameProperty() {
        final String username = "test";
        User user = new User.Builder().username(username).build();
        assertEquals(username, user.getUsername());
    }

    @Test
    void userBuilderShouldContainsThePasswordProperty() {
        final String password = "test";
        User user = new User.Builder().password(password).build();
        assertEquals(password, user.getPassword());
    }

    @Test
    void userBuilderShouldContainsTheEmailProperty() {
        final String email = "test@test.test";
        User user = new User.Builder().email(email).build();
        assertEquals(email, user.getEmail());
    }

    @Test
    void userBuilderShouldContainsTheEnabledProperty() {
        final boolean enabled = false;
        User user = new User.Builder().enabled(enabled).build();
        assertEquals(enabled, user.isEnabled());
    }

    @Test
    void userBuilderShouldContainsTheExpiredProperty() {
        final boolean expired = false;
        User user = new User.Builder().expired(expired).build();
        assertEquals(expired, !user.isAccountNonExpired());
    }

    @Test
    void userBuilderShouldContainsTheLockedProperty() {
        final boolean locked = false;
        User user = new User.Builder().locked(locked).build();
        assertEquals(locked, !user.isAccountNonLocked());
    }

    @Test
    void userBuilderShouldContainsTheAuthoritiesProperty() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role.Builder().id(2L).authority("test").build());
        User user = new User.Builder().authorities(roles).build();
        assertEquals(roles, user.getAuthorities());
    }

}