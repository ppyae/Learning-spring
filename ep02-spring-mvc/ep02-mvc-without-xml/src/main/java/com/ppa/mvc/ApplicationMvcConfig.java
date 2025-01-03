package com.ppa.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.ppa.mvc.controller.LegacyController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ppa.mvc.controller")
public class ApplicationMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/views/",".jsp");
	}
	
	@Bean
	SimpleUrlHandlerMapping legacyControllerMapping(LegacyController legacyController) {
		var mapping = new SimpleUrlHandlerMapping();
		mapping.setUrlMap(Map.of("/legacy",legacyController));
		return mapping;
	}
	
	@Bean
	RouterFunction<ServerResponse> router(){
		return RouterFunctions.route().GET("/function" , request -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(List.of("Hello form Router"))).build();
	}
}
