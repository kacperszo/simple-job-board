package pl.szot.simplejobboard.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.szot.simplejobboard.exceptions.InvalidTokenException;
import pl.szot.simplejobboard.model.User;
import pl.szot.simplejobboard.service.JwtTokenService;
import pl.szot.simplejobboard.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Custom GenericFilterBean used to authenticate user by api to authenticate jwt token
 *
 * @author Kacper Szot
 */
@Component
public class ApiRequestFilter extends GenericFilter {
    private JwtTokenService jwtTokenService;
    private UserService userService;

    public ApiRequestFilter(JwtTokenService jwtTokenService, UserService userService) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper((HttpServletRequest) servletRequest);
        try {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(wrappedRequest);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        } catch (InvalidTokenException e) {
            Logger.getAnonymousLogger().finest(e.getMessage());
        }

        filterChain.doFilter(wrappedRequest, servletResponse);
        resetAuthenticationAfterRequest();

    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) throws InvalidTokenException {
        String requestAuthorizationToken = request.getHeader("Authorization");
        if (isCorrectToken(requestAuthorizationToken)) {
            requestAuthorizationToken = requestAuthorizationToken.replace("Bearer ", "");
            String username = jwtTokenService.getUsernameFromToken(requestAuthorizationToken);
            Optional<User> userOptional = userService.findUserByUsername(username);
            User user = userOptional.orElseThrow(() -> new InvalidTokenException("user do not exist"));
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        }
        throw new InvalidTokenException("invalid authorization header");
    }

    private void resetAuthenticationAfterRequest() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private boolean isCorrectToken(String token) {
        return StringUtils.isNotEmpty(token) && token.startsWith("Bearer ");
    }
}
