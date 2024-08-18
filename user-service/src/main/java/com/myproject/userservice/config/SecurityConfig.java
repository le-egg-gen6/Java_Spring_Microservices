package com.myproject.userservice.config;

import com.myproject.userservice.constant.SecurityConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author nguyenle
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final SecurityConstant securityConstant;

	private final CustomJwtDecoder customJwtDecoder;

	private final JwtAuthenticationConverter jwtAuthenticationConverter;

	private final AuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
				request -> request
					.requestMatchers(HttpMethod.POST, securityConstant.getPublicEndpoints()).permitAll()
					.anyRequest().authenticated()
			);

		httpSecurity
			.oauth2ResourceServer(oauth2 -> oauth2
				.jwt(jwtConfigurer -> jwtConfigurer
					.decoder(customJwtDecoder)
					.jwtAuthenticationConverter(jwtAuthenticationConverter)
				).authenticationEntryPoint(authenticationEntryPoint)
			);

		return httpSecurity.build();
	}

}
