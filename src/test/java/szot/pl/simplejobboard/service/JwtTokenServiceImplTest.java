package szot.pl.simplejobboard.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import szot.pl.simplejobboard.model.Role;
import szot.pl.simplejobboard.model.User;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Date;

class JwtTokenServiceImplTest {
    @Test
    void jwtTokenServiceShouldGenerateTokenForUser() {
        Clock clock = Clock.fixed(Instant.ofEpochSecond(0), ZoneOffset.UTC);
        JwtTokenService jwtTokenService = new JwtTokenServiceImpl("dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdA", clock);
        User user = new User.Builder().username("test").build();
        user.setAuthorities(Collections.singletonList(new Role(1L, "test")));
        Assertions.assertEquals("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjowLCJleHAiOjE4MDAwLCJhdXRob3JpdGllcyI6W3siaWQiOjEsImF1dGhvcml0eSI6InRlc3QifV19.u8DvziDdma6AZnnleDG382NeigI6VVopZKY90LldG3VYa1JCrU9hgUdwj5foUZ6HTPXuYvhtjVP2N_fHF7R96g",
                jwtTokenService.generateTokenForUser(user), "jwt token service should generate correct jwt token for user");
    }

    @Test
    void jwtTokenServiceShouldGetAllClaimsFromToken() {
        Clock clock = Clock.systemUTC();
        JwtTokenService jwtTokenService = new JwtTokenServiceImpl("dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdA", clock);
        User user = new User.Builder().username("test").build();
        String token = jwtTokenService.generateTokenForUser(user);
        Claims claims = new DefaultClaims();
        claims.setSubject(user.getUsername());
        claims.setIssuedAt(new Date(clock.millis()));
        claims.setExpiration(new Date(clock.millis() + 60L * 60L * 5L * 1000L));
        Assertions.assertEquals(claims.getSubject(), jwtTokenService.getAllClaimsFromToken(token).getSubject());
        Assertions.assertEquals(claims.getIssuedAt(), jwtTokenService.getAllClaimsFromToken(token).getIssuedAt());
        Assertions.assertEquals(claims.getExpiration(), jwtTokenService.getAllClaimsFromToken(token).getExpiration());
    }

    @Test
    void jwtTokenServiceShouldGetClaimFromToken() {
        Clock clock = Clock.systemUTC();
        var user = new User.Builder().username("test").build();
        JwtTokenService jwtTokenService = new JwtTokenServiceImpl("dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdA", clock);
        final String token = jwtTokenService.generateTokenForUser(user);
        Assertions.assertEquals(jwtTokenService.getAllClaimsFromToken(token).getSubject(), jwtTokenService.getClaimFromToken(token, Claims::getSubject));
    }

    @Test
    void jwtTokenServiceShouldGetUsernameFromToken() {
        Clock clock = Clock.systemUTC();
        var user = new User.Builder().username("test").build();
        JwtTokenService jwtTokenService = new JwtTokenServiceImpl("dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdHRlc3R0ZXN0dGVzdA", clock);
        final String token = jwtTokenService.generateTokenForUser(user);
        Assertions.assertEquals(user.getUsername(), jwtTokenService.getUsernameFromToken(token));
    }
}