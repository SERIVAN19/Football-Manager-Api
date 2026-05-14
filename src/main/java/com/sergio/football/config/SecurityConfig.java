package com.sergio.football.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                //Deshabilitar CSRF (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // Swagger
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Auth
                        .requestMatchers("/api/auth/**")
                        .permitAll()

                        // Todo lo demás requiere autenticación
                        .anyRequest()
                        .authenticated()
                );

        return http.build();// Construye y devuelve la cadena
    }
    //Usa BCrypt para encriptar y validar todas las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}