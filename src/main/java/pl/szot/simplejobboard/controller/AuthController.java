package pl.szot.simplejobboard.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.szot.simplejobboard.mapper.UserMapper;
import pl.szot.simplejobboard.requests.LoginRequest;
import pl.szot.simplejobboard.service.JwtTokenService;
import pl.szot.simplejobboard.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Authentication controller
 * Rest controller responsible for user's authentication
 *
 * @author Kacper Szot
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtTokenService jwtTokenService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtTokenService jwtTokenService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping
    public Map<String, String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Map<String, String> response = new HashMap<>();
        var user = userService.findUserByUsername(request.getUsername());
        response.put("token", jwtTokenService.generateTokenForUser(user.orElseThrow(() -> new RuntimeException("authentication error"))));
        return response;
    }
}
