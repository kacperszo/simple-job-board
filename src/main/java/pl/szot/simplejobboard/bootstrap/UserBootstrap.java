package pl.szot.simplejobboard.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.szot.simplejobboard.model.User;
import pl.szot.simplejobboard.service.UserService;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private static final String ADMIN_USERNAME = "admin";
    private UserService userService;
    private String adminPassword;
    private PasswordEncoder passwordEncoder;

    public UserBootstrap(UserService userService, @Value("${admin.password}") String adminPassword, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.adminPassword = adminPassword;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userService.save(new User.Builder()
                .id(1L)
                .username(ADMIN_USERNAME)
                .password(passwordEncoder.encode(adminPassword))
                .enabled(true)
                .build());
    }
}
