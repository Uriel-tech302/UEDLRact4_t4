package com.example.crudrapido.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Permitiremos acceso público SOLO a las futuras rutas de login y registro
                .requestMatchers("/api/auth/**").permitAll()
                
                // Exigimos que CUALQUIER OTRA RUTA (como tu CRUD en /api/v1/students) requiera autenticación
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}