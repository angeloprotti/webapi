package com.protti.webapi;

import com.protti.webapi.ws.controller.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebapiApplication {

	@Bean
	public FilterRegistrationBean filterJwt(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/auth/*");

		return frb;
	}


	public static void main(String[] args) {
		SpringApplication.run(WebapiApplication.class, args);
	}
}
