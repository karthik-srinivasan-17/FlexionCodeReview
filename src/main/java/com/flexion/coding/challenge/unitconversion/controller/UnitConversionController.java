package com.flexion.coding.challenge.unitconversion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.service.UnitConversionService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class UnitConversionController {
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UnitConversionController.class);

	
	@Autowired
	UnitConversionService ucService;
	
	/**
	 * @param entries
	 * @return saved Entries with valid results. 
	 */
	@PostMapping(path = "entry")
	public ResponseEntity<?> checkConversion(@RequestBody Entries entries){
		LOGGER.info("in UnitConversionController checkConversion method - Type :  " + entries.getConversionType());
		Entries resource = new Entries();
		resource = ucService.checkConversion(entries);
		LOGGER.debug("in UnitConversionController checkConversion method - Entry has been saved to Database");
		LOGGER.debug("in UnitConversionController checkConversion method - Result :  " + resource.getResult());
		return ResponseEntity.ok(resource);

	}
	
	
	/**
	 * @return all the  Entries in the database.
	 */
	@GetMapping(path = "listEntries")
    public ResponseEntity<?> listEntries() {
		LOGGER.info("in UnitConversionController listEntries method - Getting All entries ");
        List<Entries> resource = ucService.getAllEntries();
        LOGGER.debug("in UnitConversionController listEntries method - All entries size is : " + resource.size());
        return ResponseEntity.ok(resource);
    }

}
