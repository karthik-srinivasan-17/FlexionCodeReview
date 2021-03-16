package com.flexion.coding.challenge.unitconversion.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flexion.coding.challenge.unitconversion.utilities.Constants;

public class TemperatureImpl implements Unit {

	private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureImpl.class);

	@Override
	public boolean checkConversion(String fromUnit, String toUnit, double askedValue, double studentResponse) {
		LOGGER.info("in TemperatureImpl checkConversion method ");
		// TODO Auto-generated method stub
		String constString = fromUnit + "_to_" + toUnit;
		LOGGER.debug("fromUnit to ToUnit is  - " + constString);
		double additional = 0.0;
		additional = Constants.getValue(constString) - 1.0;
		LOGGER.debug("additional factor obtained from constants  - " + additional);
		double result = askedValue + additional;
		return Math.round(result * 10) == Math.round(studentResponse * 10);
	}

}
