package com.myproject.userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.userservice.repository.RoleRepository;
import com.myproject.userservice.repository.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
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

	private SecurityConstant securityConstant;

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

	@Bean
	public MACSigner initMACSigner() throws KeyLengthException {
		return new MACSigner(securityConstant.getSecretKey().getBytes());
	}

	@Bean
	public MACVerifier initMACVerifier() throws JOSEException {
		return new MACVerifier(securityConstant.getSecretKey().getBytes());
	}

//	@Bean
//	public ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
//
//	}

}
