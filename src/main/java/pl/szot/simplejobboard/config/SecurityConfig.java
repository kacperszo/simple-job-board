package pl.szot.simplejobboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.szot.simplejobboard.security.ApiAuthenticationEntryPoint;
import pl.szot.simplejobboard.security.ApiRequestFilter;
import pl.szot.simplejobboard.service.UserService;

/**
 * Security configuration class
 *
 * @author Kacper Szot
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;
    private ApiRequestFilter apiRequestFilter;
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;

    public SecurityConfig(UserService userService, ApiRequestFilter apiRequestFilter, ApiAuthenticationEntryPoint apiAuthenticationEntryPoint) {
        this.userService = userService;
        this.apiRequestFilter = apiRequestFilter;
        this.apiAuthenticationEntryPoint = apiAuthenticationEntryPoint;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/v1/auth").permitAll()
                .and().addFilterBefore(apiRequestFilter, UsernamePasswordAuthenticationFilter.class).userDetailsService(userService);
        http.exceptionHandling().authenticationEntryPoint(apiAuthenticationEntryPoint);
    }
}