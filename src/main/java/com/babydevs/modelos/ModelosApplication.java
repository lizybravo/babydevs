package com.babydevs.modelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import com.babydevs.modelos.config.JwtFilter;

@SpringBootApplication
public class ModelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelosApplication.class, args);
	}//main
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
						new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/asesores/*");
		registrationBean.addUrlPatterns("/api/asesorados/*");
		registrationBean.addUrlPatterns("/api/asesorias/*");
		registrationBean.addUrlPatterns("/api/ventas/*");
		return registrationBean;
	}//jwtFilter
}//Class ModelosApplication

