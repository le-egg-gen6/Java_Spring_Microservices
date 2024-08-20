package com.myproject.userservice.config;

import com.myproject.userservice.constant.SecurityConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author nguyenle
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationRequestInterceptor implements RequestInterceptor {

	private final SecurityConstant securityConstant;

	@Override
	public void apply(RequestTemplate template) {
		ServletRequestAttributes servletRequestAttributes =
			(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		var authHeader = servletRequestAttributes.getRequest().getHeader("Authorization");

		log.info("Header: {}", authHeader);
		if (StringUtils.hasText(authHeader)) {
			template.header("Authorization", authHeader);
		}

		template.header("Internal", securityConstant.getInternalApiKey());
	}

}
