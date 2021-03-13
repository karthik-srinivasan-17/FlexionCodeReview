package com.flexion.coding.challenge.unitconversion.service;

import org.springframework.stereotype.Component;

import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.factory.Unit;
import com.flexion.coding.challenge.unitconversion.factory.UnitFactory;

@Component
public class UnitConversionService {

	
    public Entries 	checkConversion(Entries entries) {
    	boolean validate = false;
    	UnitFactory unitFactory = new UnitFactory();
    	Unit unit = unitFactory.getUnitConvertorObject(entries.getConversionType());
    	validate = unit.checkConversion(entries.getFromMeasurement(),
    				entries.getToMeasurement(), entries.getAskedValue(), entries.getWrittenValue());

    	if (validate) {
    		entries.setResult("CORRECT");
    	}else {
    		entries.setResult("INCORRECT");
    	}
    
    	return entries;
    }
}
