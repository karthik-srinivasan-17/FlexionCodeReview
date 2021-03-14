package com.flexion.coding.challenge.unitconversion.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flexion.coding.challenge.unitconversion.AppController;
import com.flexion.coding.challenge.unitconversion.UnitConversionApplication;
import com.flexion.coding.challenge.unitconversion.entity.Entries;
import com.flexion.coding.challenge.unitconversion.utilities.ConversionType;
import com.flexion.coding.challenge.unitconversion.utilities.Temperature;
import com.flexion.coding.challenge.unitconversion.utilities.Volumes;

@SpringBootTest
class UnitConversionControllerTests {
	
	@Autowired
	UnitConversionController ucController;
	@Autowired
	AppController appController;
	
	@Test
    public void testAppController()
    {
		String htmlPage = appController.loadUI();
		assertTrue(htmlPage.equals("forward:/index.html"));
    }
	
	
	@Test
    public void test()
    {
		UnitConversionApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
                // Override any other environment properties according to your needs
        });
    }
	
	 @Test
	  public void testGetAllEntries() {
		 Entries sampleEntry1 = new Entries();
		 sampleEntry1.setAskedValue("1.0");
		 sampleEntry1.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry1.setFromMeasurement(Temperature.CELSIUS.toString());
		 sampleEntry1.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry1.setWrittenValue("33.8");
		 ucController.checkConversion(sampleEntry1);
		 Entries sampleEntry2 = new Entries();
		 sampleEntry2.setAskedValue("2.0");
		 sampleEntry2.setConversionType(ConversionType.VOLUME.toString());
		 sampleEntry2.setFromMeasurement(Volumes.GALLON.toString());
		 sampleEntry2.setToMeasurement(Volumes.LITER.toString());
		 sampleEntry2.setWrittenValue("2.78");
		 ucController.checkConversion(sampleEntry2);
		 ResponseEntity<?> responseEntry =  ucController.listEntries();
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 List<Entries> resultEntry = (List<Entries>) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.size(),6);
	  }

	 @Test
	  public void testTemperatureCorrect() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(1L);
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
	  public void testTemparatureIncorrect() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(2L);
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
	 
	 
	 @Test
	  public void testVolumeCorrect() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(1L);
		 sampleEntry.setAskedValue("1.0");
		 sampleEntry.setConversionType(ConversionType.VOLUME.toString());
		 sampleEntry.setFromMeasurement(Volumes.GALLON.toString());
		 sampleEntry.setToMeasurement(Volumes.LITER.toString());
		 sampleEntry.setWrittenValue("3.78");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"CORRECT");
	  }
	 
	 @Test
	  public void testVolumeIncorrect() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(2L);
		 sampleEntry.setAskedValue("2.0");
		 sampleEntry.setConversionType(ConversionType.VOLUME.toString());
		 sampleEntry.setFromMeasurement(Volumes.GALLON.toString());
		 sampleEntry.setToMeasurement(Volumes.LITER.toString());
		 sampleEntry.setWrittenValue("2.78");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"INCORRECT");
	  }
	 
	 @Test
	  public void testTemperatureINVALID() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(1L);
		 sampleEntry.setAskedValue("1.0");
		 sampleEntry.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry.setFromMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue("33.8");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"INVALID");
	  }
	 
	 @Test
	  public void testInvalidTemperature() {
		 Entries sampleEntry = new Entries();
		 sampleEntry.setAskedValue("1.0");
		 sampleEntry.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry.setFromMeasurement("Garbage Value");
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue("33.8");
		 ResponseEntity<?> responseEntry =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry = (Entries) responseEntry.getBody();
		 System.out.println(responseEntry.getBody().toString());
		 assertEquals(resultEntry.getResult(),"INVALID");
		 Entries sampleEntry1 = new Entries();
		 sampleEntry1.setAskedValue("1.0");
		 sampleEntry1.setConversionType(ConversionType.TEMPERATURE.toString());
		 sampleEntry1.setFromMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry1.setToMeasurement("Garbage Value");
		 sampleEntry1.setWrittenValue("33.8");
		 ResponseEntity<?> responseEntry1 =  ucController.checkConversion(sampleEntry);
		 assertEquals(responseEntry1.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry1 = (Entries) responseEntry1.getBody();
		 System.out.println(responseEntry1.getBody().toString());
		 assertEquals(resultEntry1.getResult(),"INVALID");
	  }
	 
	 @Test
	  public void testInvalideType() {
		 Entries sampleEntry = new Entries();
		 //sampleEntry.setId(1L);
		 sampleEntry.setAskedValue("1.0");
		 sampleEntry.setConversionType(null);
		 sampleEntry.setFromMeasurement(Temperature.KELVIN.toString());
		 sampleEntry.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry.setWrittenValue("33.8");

		 Assertions.assertThrows(Exception.class, () ->  ucController.checkConversion(sampleEntry));
		 Entries sampleEntry1 = new Entries();
		 //sampleEntry.setId(1L);
		 sampleEntry1.setAskedValue("1.0");
		 sampleEntry1.setConversionType("Garbage Value");
		 sampleEntry1.setFromMeasurement(Temperature.KELVIN.toString());
		 sampleEntry1.setToMeasurement(Temperature.FAHRENHEIT.toString());
		 sampleEntry1.setWrittenValue("33.8");

		 ResponseEntity<?> responseEntry1 =  ucController.checkConversion(sampleEntry1);
		 assertEquals(responseEntry1.getStatusCodeValue(),HttpStatus.OK.value());
		 Entries resultEntry1 = (Entries) responseEntry1.getBody();
		 System.out.println(responseEntry1.getBody().toString());
		 assertEquals(resultEntry1.getResult(),"INVALID");
	  }
	 
	
}
