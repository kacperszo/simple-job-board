package pl.szot.simplejobboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class invoked when provided token is incorrect
 *
 * @author Kacper Szot
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidTokenException extends Exception {
    public InvalidTokenException(String msg) {
        super(msg);
    }
}
