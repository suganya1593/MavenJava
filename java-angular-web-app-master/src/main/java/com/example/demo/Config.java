package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;

@Configuration
public class Config {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	// value inserted in your application.properties server.port
	@Value("${server.port}")
	private String port;

	@EventListener(ApplicationReadyEvent.class)
	public void postConstruct() {
		LOGGER.info("-----OPEN BROWSER IN localhost:" + port);
	}

	@Bean
	public EmbeddedServletContainerCustomizer singlePageAppRouting() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
			}
		};
	}
}
