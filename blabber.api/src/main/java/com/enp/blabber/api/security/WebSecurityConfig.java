package com.enp.blabber.api.security;

/*
 * @(#)WebSecurityConfig.java 1.0 29/10/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.model.UserMyDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
    private UserMyDetails userDetailService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    //registry.requestMatchers("/swagger-ui/**").permitAll();
                    //registry.requestMatchers("/v3/api-docs/**").permitAll();
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/blabber/auth").permitAll();
                    //USER
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/blabber/users/**").hasRole("USER");
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/blabber/users/create").hasRole("USER");
                    registry.requestMatchers(HttpMethod.PUT,  "/api/v1/blabber/users/**").hasRole("USER");
                    //BLAB
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/blabber/blabs/create").hasRole("USER");
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/blabber/blabs/**").hasRole("USER");
                    //LIKE
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/blabber/blabs/like").hasRole("USER");
                    /*
                    //HOTEL
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/reservite/hotel").hasRole("USER");
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/reservite/hotel").hasRole("USER");
                    //ROOM
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/reservite/room").hasRole("USER");
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/reservite/room/by-number/**").hasRole("USER");
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/reservite/room/by-hotel/**").hasRole("USER");
                    //BOOKING
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/reservite/booking").hasRole("USER");
                    registry.requestMatchers(HttpMethod.GET , "/api/v1/reservite/booking").hasRole("USER");
                    //DASHBOARD
                    registry.requestMatchers(HttpMethod.GET , "/api/v1/reservite/dashboard").hasRole("USER");
                    //NOTIFICATIONS
                    registry.requestMatchers(HttpMethod.GET , "/api/v1/reservite/notification").hasRole("USER");
                    
                    
                    
                    registry.requestMatchers(HttpMethod.GET,  "/api/v1/taskflow/task/followup/**").hasRole("USER");
                    registry.requestMatchers(HttpMethod.POST, "/api/v1/taskflow/task/followup").hasRole("USER");
                    registry.requestMatchers(HttpMethod.PUT,  "/api/v1/taskflow/task/followup").hasRole("USER");
                    */
                    registry.anyRequest().authenticated();
                })
                .formLogin(login -> login
                        .successHandler((request, response, authentication) -> {
                            response.setContentType("application/json");
                            response.getWriter().write("{\"message\": \"Autenticación exitosa\"}");
                        }))
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setContentType("application/json");
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.getWriter().write(convertObjectToJson(new ErrorDetails(new Date(),HttpStatus.UNAUTHORIZED.toString(),"Credenciales no autorizadas")));
                        }))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (UserDetailsService) userDetailService;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService((UserDetailsService) userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    private String convertObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{\"error\": \"Error al convertir a JSON\"}";
        }
    }

}
