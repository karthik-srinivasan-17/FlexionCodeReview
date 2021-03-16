package com.flexion.coding.challenge.unitconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class AppController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AppController.class);

	/**
	 * 
	 * @return
	 */
	@RequestMapping({"/"})
	public String loadUI() {
		LOGGER.debug("in loadUI() method - Preliminary test done after successful deployment" );
		return "forward:/index.html";
	}

}
