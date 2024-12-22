package com.ppa.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ppa.mvc.controller.interceptor.HelloIncepetor;

@Configuration
@ComponentScan("com.ppa.mvc.controller")
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer{
	
	@Autowired
	private HelloIncepetor helloIncepetor;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/hello");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(helloIncepetor);
	}
	

//	@Bean
//	SpringResourceTemplateResolver templateResolver() {
//		var tr = new SpringResourceTemplateResolver();
//		tr.setSuffix(".html");
//		tr.setCacheable(false);
//		return tr;
//	}
//	
//	@Bean
//	SpringTemplateEngine templateEngine() {
//		var te = new SpringTemplateEngine();
//		te.setTemplateResolver(templateResolver());
//		return te;
//	}
//	
//	@Bean
//	ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//		var vr = new ThymeleafViewResolver();
//		vr.setTemplateEngine(templateEngine);
//		return vr;
//	}

}
