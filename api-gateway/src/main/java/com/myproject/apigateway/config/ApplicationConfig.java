package com.myproject.apigateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nguyenle
 */
@Configuration
public class ApplicationConfig {

	@Value("${api.prefix}")
	private String apiPrefix;

	public String getApiPrefix() {
		return apiPrefix;
	}

	@Bean
	public ObjectMapper initObjectMapper() {
		return new ObjectMapper();
	}

}
