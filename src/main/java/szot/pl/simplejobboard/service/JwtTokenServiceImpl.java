package szot.pl.simplejobboard.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import szot.pl.simplejobboard.model.User;

import java.security.Key;
import java.time.Clock;
import java.util.Date;
import java.util.function.Function;

/**
 * Implementation of the JwtTokenService
 *
 * @author Kacper Szot
 * @see szot.pl.simplejobboard.service.JwtTokenService
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private long expirationTime;
    private Key key;
    private Clock clock;

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    public JwtTokenServiceImpl(@Value("${jwt.secret}") String jwtSecret, Clock clock) {
        key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        this.expirationTime = 60L * 60L * 5L * 1000L;// <- 5 hours
        this.clock = clock;
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
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
     * @see szot.pl.simplejobboard.service.JwtTokenService
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
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(getAllClaimsFromToken(token));
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public Date getExpirationDateFromToken(String token) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public Boolean isTokenExpired(String token) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see szot.pl.simplejobboard.service.JwtTokenService
     */
    @Override
    public Key getKey() {
        return null;
    }
}
