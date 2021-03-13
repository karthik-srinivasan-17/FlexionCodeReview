package com.flexion.coding.challenge.unitconversion.factory;

import com.flexion.coding.challenge.unitconversion.utilities.ConversionType;


public class UnitFactory {

	public Unit getUnitConvertorObject(String conversionType){
		if(conversionType == null){
	         return null;
	      }		
	      if(conversionType.equalsIgnoreCase(ConversionType.VOLUME.toString())){
	         return new VolumeImpl();
	         
	      } else if(conversionType.equalsIgnoreCase(ConversionType.TEMPERATURE.toString())){
	         return new TemperatureImpl();
	         
	      } 

	      return null;
	}
}
