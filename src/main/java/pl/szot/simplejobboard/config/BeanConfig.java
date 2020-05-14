package pl.szot.simplejobboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Bean configuration class
 *
 * @author Kacper Szot
 */
@Configuration
public class BeanConfig {
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
