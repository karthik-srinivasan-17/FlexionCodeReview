package com.flexion.coding.challenge.unitconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author kshpo
 *
 */
@SpringBootApplication
public class UnitConversionApplication extends SpringBootServletInitializer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UnitConversionApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Unit Conversion Application Started");
		SpringApplication.run(UnitConversionApplication.class, args);
	}


    /* (non-Javadoc)
     * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UnitConversionApplication.class);
    }
}
