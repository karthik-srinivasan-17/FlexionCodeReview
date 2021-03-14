package com.flexion.coding.challenge.unitconversion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.service.UnitConversionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UnitConversionController {
	
	@Autowired
	UnitConversionService ucService;
	
	@PostMapping(path = "entry")
	public ResponseEntity<?> checkConversion(@RequestBody Entries entries){
		Entries resource = new Entries();
		resource = ucService.checkConversion(entries);
		return ResponseEntity.ok(resource);

	}
	
	
	@GetMapping(path = "listEntries")
    public ResponseEntity<?> listUsers() {
        List<Entries> resource = ucService.getAllEntries();
        return ResponseEntity.ok(resource);
    }

}
