package com.myproject.userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.userservice.repository.RoleRepository;
import com.myproject.userservice.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

/**
 * @author nguyenle
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public PasswordEncoder initPasswordEncode() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	public JwtAuthenticationConverter initJwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

		return jwtAuthenticationConverter;
	}

	@Bean
	public ObjectMapper initObjectMapper() {
		return new ObjectMapper();
	}

//	@Bean
//	public ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
//
//	}

}
