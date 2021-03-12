package com.flexion.coding.challenge.unitconversion.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.service.UnitConversionService;
import com.flexion.coding.challenge.unitconversion.utilities.ConversionType;
import com.flexion.coding.challenge.unitconversion.utilities.Temperature;

@SpringBootTest
class UnitConversionControllerTests {
	
	@Autowired
	UnitConversionController ucController;

	 @Test
	  public void testCheckConversion() {
		 Entries sampleEntry = new Entries();
		 sampleEntry.setAskedValue(1.0);
		 sampleEntry.setConversionType(ConversionType.Temperature.toString());
		 sampleEntry.setFromMeasurement(Temperature.CELSIUS.toString());
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue(2.3);
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 Entries resultEntry= (Entries)responseEntry.getBody();
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		
	  }
}
