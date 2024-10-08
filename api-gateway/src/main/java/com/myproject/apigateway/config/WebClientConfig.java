package com.myproject.apigateway.config;

import java.util.List;

import com.myproject.apigateway.httpclient.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author nguyenle
 */
@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

	private final ApplicationConfig applicationConfig;

	@Bean
	WebClient webClient(){
		return WebClient.builder()
			.baseUrl(applicationConfig.getAppServiceUserUrl())
			.build();
	}

	@Bean
	CorsWebFilter corsWebFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(List.of("*"));
		corsConfiguration.setAllowedHeaders(List.of("*"));
		corsConfiguration.setAllowedMethods(List.of("*"));

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsWebFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	UserServiceClient identityClient(WebClient webClient){
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
			.builderFor(WebClientAdapter.create(webClient)).build();

		return httpServiceProxyFactory.createClient(UserServiceClient.class);
	}

}
