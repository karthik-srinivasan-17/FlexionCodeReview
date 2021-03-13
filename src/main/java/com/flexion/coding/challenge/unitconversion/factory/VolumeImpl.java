package com.flexion.coding.challenge.unitconversion.factory;

import com.flexion.coding.challenge.unitconversion.utilities.Constants;

public class VolumeImpl implements Unit {

	@Override
	public boolean checkConversion(String fromUnit, String toUnit, double askedValue,
			double studentResponse) {
		// TODO Auto-generated method stub
		
		 String constString = fromUnit+"_to_"+toUnit;
		 double multiplier = 1;
		 multiplier = Constants.getValue(constString);
		 double result = askedValue * multiplier;
		 return Math.round(result * 10) == Math.round(studentResponse * 10);
	
	}

}
