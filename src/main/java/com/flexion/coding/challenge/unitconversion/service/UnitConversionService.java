package com.flexion.coding.challenge.unitconversion.service;

import org.springframework.stereotype.Component;

import com.flexion.coding.challenge.unitconversion.entity.Entries;

@Component
public class UnitConversionService {

	
    public Entries 	checkConversion(Entries entries) {
    	return new Entries();
    }
}
