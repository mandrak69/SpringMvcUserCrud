package rs.engineering.javacourse.springMvcUserCrud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//konfigurisanje binova u web kontekstu za konkretni dispatcher
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"rs.engineering.javacourse.springMvcUserCrud.controller"
		,"rs.engineering.javacourse.springMvcUserCrud.repository.impl",
		"rs.engineering.javacourse.springMvcUserCrud.serviceImpl"})
public class MyWebContextConfig {
	// configure handler mapping
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
