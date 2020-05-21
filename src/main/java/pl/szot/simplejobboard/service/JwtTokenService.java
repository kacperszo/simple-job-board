package pl.szot.simplejobboard.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import pl.szot.simplejobboard.model.User;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 * Service offers an interface for creating and manipulating jwt tokens
 *
 * @author Kacper Szot
 */
public interface JwtTokenService {
    /**
     * generate jwt token for given user
     *
     * @param user user to generate token for
     * @return Strong containing JWT token
     */
    String generateTokenForUser(User user);

    /**
     * Get all claims from token
     *
     * @param token token to get claims from
     * @return claims
     */
    Claims getAllClaimsFromToken(String token);

    /**
     * Get Claim from token
     *
     * @param token          jwt token
     * @param claimsResolver function to resolve claim
     * @param <T>            typo of claim
     * @return claim of type <T>
     */
    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    /**
     * get username form token
     *
     * @param token jwt token
     * @return username
     */
    String getUsernameFromToken(String token);

    /**
     * get expiration date from token
     *
     * @param token jwt token
     * @return expiration date
     */
    Date getExpirationDateFromToken(String token);

    /**
     * check if token is expired
     *
     * @param token jwt token
     * @return true if token is expired otherwise false
     */
    Boolean isTokenExpired(String token);

    /**
     * check if token is valid
     *
     * @param token       jwt token
     * @param userDetails user details
     * @return true if token is valid otherwise false
     */
    Boolean validateToken(String token, UserDetails userDetails);

    /**
     * Get key
     *
     * @return key
     */
    Key getKey();
}
