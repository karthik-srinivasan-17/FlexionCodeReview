package com.flexion.coding.challenge.unitconversion.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flexion.coding.challenge.unitconversion.utilities.Constants;

public class VolumeImpl implements Unit {

	private static final Logger LOGGER = LoggerFactory.getLogger(VolumeImpl.class);

	@Override
	public boolean checkConversion(String fromUnit, String toUnit, double askedValue, double studentResponse) {
		// TODO Auto-generated method stub
		LOGGER.info("in VolumeImpl checkConversion method ");
		String constString = fromUnit + "_to_" + toUnit;
		LOGGER.debug("fromUnit to ToUnit is  - " + constString);
		double multiplier = 1;
		multiplier = Constants.getValue(constString);
		LOGGER.debug("multiplier factor obtained from constants  - " + multiplier);
		double result = askedValue * multiplier;
		return Math.round(result * 10) == Math.round(studentResponse * 10);

	}

}
