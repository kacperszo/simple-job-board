package pl.szot.simplejobboard.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.szot.simplejobboard.model.User;

import java.security.Key;
import java.time.Clock;
import java.util.Date;
import java.util.function.Function;

/**
 * Implementation of the JwtTokenService
 *
 * @author Kacper Szot
 * @see JwtTokenService
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private long expirationTime;
    private Key key;
    private Clock clock;

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    public JwtTokenServiceImpl(@Value("${jwt.secret}") String jwtSecret, Clock clock) {
        key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        this.expirationTime = 60L * 60L * 5L * 1000L;// <- 5 hours
        this.clock = clock;
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public String generateTokenForUser(User user) {
        return Jwts.builder().
                signWith(key, SignatureAlgorithm.HS512)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(clock.millis()))
                .setExpiration(new Date(clock.millis() + expirationTime))
                .claim("authorities", user.getAuthorities())
                .compact();
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(getAllClaimsFromToken(token));
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public Boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date(clock.millis()));
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return (userDetails.getUsername().equals(getUsernameFromToken(token))) && !isTokenExpired(token);
    }

    /**
     * {@inheritDoc}
     *
     * @see JwtTokenService
     */
    @Override
    public Key getKey() {
        return key;
    }
}
