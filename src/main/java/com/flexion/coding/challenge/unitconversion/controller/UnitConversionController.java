package com.flexion.coding.challenge.unitconversion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexion.coding.challenge.unitconversion.entity.Entries;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UnitConversionController {
	
	@PostMapping(path = "entry")
	public ResponseEntity<?> checkConversion(@RequestBody Entries entries){
		Entries resource = new Entries();
		resource.setAskedValue(84.5);
		resource.setFromMeasurement("Fahrenhiet");
		resource.setToMeasurement("Rankine");
		resource.setWrittenValue(1234.25);
		resource.setResult("INCORRECT");
		return ResponseEntity.ok(resource);
	}

}
