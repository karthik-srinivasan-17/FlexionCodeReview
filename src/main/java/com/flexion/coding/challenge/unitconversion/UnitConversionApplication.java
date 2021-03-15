package com.flexion.coding.challenge.unitconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UnitConversionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UnitConversionApplication.class, args);
	}


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UnitConversionApplication.class);
    }
}
