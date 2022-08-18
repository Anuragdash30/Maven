package com.barclays.customerbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class customerbankingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(customerbankingApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(customerbankingApplication.class);
	}

}
