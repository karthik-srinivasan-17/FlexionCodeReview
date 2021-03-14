package com.flexion.coding.challenge.unitconversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.factory.Unit;
import com.flexion.coding.challenge.unitconversion.factory.UnitFactory;
import com.flexion.coding.challenge.unitconversion.repository.UnitConversionRepository;

@Component
public class UnitConversionService {

	@Autowired
	private UnitConversionRepository unitConversionRepository;

	public UnitConversionService(UnitConversionRepository unitConversionRepository) {
		this.unitConversionRepository = unitConversionRepository;
	}

	public Entries checkConversion(Entries entries) {
		boolean validate = false;
		UnitFactory unitFactory = new UnitFactory();
		Unit unit = unitFactory.getUnitConvertorObject(entries.getConversionType());
		try {
			validate = unit.checkConversion(entries.getFromMeasurement(), entries.getToMeasurement(),
					Double.parseDouble(entries.getAskedValue()), Double.parseDouble(entries.getWrittenValue()));
		} catch (NullPointerException | NumberFormatException e) {
			entries.setResult("INVALID");
			return unitConversionRepository.save(entries);
		}

		if (validate) {
			entries.setResult("CORRECT");
		} else {
			entries.setResult("INCORRECT");
		}

		return unitConversionRepository.save(entries);
	}
	
	
	  public List<Entries> getAllEntries() {
	        return unitConversionRepository.findAll();
	    }
	    
}
