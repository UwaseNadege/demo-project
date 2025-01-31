package com.example.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
@EnableReactiveMethodSecurity(useAuthorizationManager = true) // Enables @PreAuthorize and other method-level security annotations
public class SecurityConfig extends WebSecurityConfiguration {

    private final JwtTokenProvider jwtTokenProvider;

    // Constructor injection of your JWT token provider (if you're using JWT)
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .requestMatchers("/auth/**").permitAll()  // Allow login and register without authentication
            .requestMatchers("/tasks/**").authenticated()  // Protect tasks endpoints
            .anyRequest().authenticated();
    }

    @Bean
    public AuthenticatedAuthorizationManager authenticationManagerBean() throws Exception {
		return null;
       
    }

    // Password encoder for BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
 
   }
    protected void configure1(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless for JWT
            .maximumSessions(1) // Limit the number of sessions per user
            .and()
            .invalidSessionUrl("/auth/session-invalid"); // Redirect on session invalidation
    }

}
