package pl.szot.simplejobboard.security;

import org.springframework.stereotype.Component;
import pl.szot.simplejobboard.service.JwtTokenService;
import pl.szot.simplejobboard.service.UserService;

import javax.servlet.*;
import java.io.IOException;

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

    }
}
