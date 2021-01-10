package com.online.store.demo.springgatewaydemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callme")
public class DemoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@PreAuthorize("hasAuthority('SCOPE_TEST')")
	@GetMapping("/ping")
	public String ping() {
		LOGGER.info("/ping called");
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "Scopes: " + authentication.getAuthorities();
	}
}