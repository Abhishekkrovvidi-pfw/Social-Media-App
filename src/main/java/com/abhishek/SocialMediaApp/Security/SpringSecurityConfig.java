package com.abhishek.SocialMediaApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //All requests are authenticated
        http.authorizeHttpRequests(
                auth->auth.anyRequest().authenticated()
        );
        http.httpBasic(withDefaults());
        //disable csrf
        http.csrf().disable();
        return http.build();
    }
}
