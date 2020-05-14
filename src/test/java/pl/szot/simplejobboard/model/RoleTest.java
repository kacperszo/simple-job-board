package pl.szot.simplejobboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void roleShouldShouldContainIdField() {
        final Long id = 2L;
        Role role = new Role.Builder().id(id).build();
        assertEquals(id, role.getId());
    }

    @Test
    void roleShouldShouldContainAuthorityField() {
        final String authority = "test authority";
        Role role = new Role.Builder().authority(authority).build();
        assertEquals(authority, role.getAuthority());
    }

}