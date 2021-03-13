package com.flexion.coding.challenge.unitconversion.factory;

import com.flexion.coding.challenge.unitconversion.utilities.Constants;

public class TemperatureImpl implements Unit {

	@Override
	public boolean checkConversion( String fromUnit, String toUnit, double askedValue,
			double studentResponse) {
		// TODO Auto-generated method stub
		 String constString = fromUnit+"_to_"+toUnit;
		 double additional = 0.0;
		 additional = Constants.getValue(constString) - 1.0;
		 double result = askedValue + additional;
		 return Math.round(result * 10) == Math.round(studentResponse * 10);
	}

}
