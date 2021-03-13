package com.flexion.coding.challenge.unitconversion.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.utilities.ConversionType;
import com.flexion.coding.challenge.unitconversion.utilities.Temperature;

@SpringBootTest
class UnitConversionControllerTests {
	
	@Autowired
	UnitConversionController ucController;

	 @Test
	  public void testCheckConversionCorrect() {
		 Entries sampleEntry = new Entries();
		 sampleEntry.setAskedValue("1.0");
		 sampleEntry.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry.setFromMeasurement(Temperature.CELSIUS.toString());
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue("33.8");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"CORRECT");
	  }
	 
	 @Test
	  public void testCheckConversionIncorrect() {
		 Entries sampleEntry = new Entries();
		 sampleEntry.setAskedValue("2.0");
		 sampleEntry.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry.setFromMeasurement(Temperature.CELSIUS.toString());
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue("33.8");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"INCORRECT");
	  }
}
