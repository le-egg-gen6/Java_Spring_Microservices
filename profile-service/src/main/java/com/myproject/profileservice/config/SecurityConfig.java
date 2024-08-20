package com.myproject.profileservice.config;

import com.myproject.profileservice.constant.SecurityConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author nguyenle
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final InternalApiKeyFilter internalApiKeyFilter;

    private final SecurityConstant securityConstant;

    private final CustomJwtDecoder customJwtDecoder;

    private final JwtAuthenticationConverter jwtAuthenticationConverter;

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers(securityConstant.getPublicEndpoints()).permitAll()
                                .requestMatchers(securityConstant.getInternalEndpoints()).permitAll()
                                .anyRequest().authenticated()
                );

        httpSecurity.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwtConfigurer -> jwtConfigurer
                        .decoder(customJwtDecoder)
                        .jwtAuthenticationConverter(jwtAuthenticationConverter)
                ).authenticationEntryPoint(jwtAuthenticationEntryPoint)
        );

        httpSecurity.addFilterBefore(internalApiKeyFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
