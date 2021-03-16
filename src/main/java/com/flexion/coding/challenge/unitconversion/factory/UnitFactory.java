package com.flexion.coding.challenge.unitconversion.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flexion.coding.challenge.unitconversion.utilities.ConversionType;

public class UnitFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(UnitFactory.class);

	public Unit getUnitConvertorObject(String conversionType) {
		LOGGER.info("in UnitFactory getUnitConvertorObject method ");
		if (conversionType == null) {
			LOGGER.info("in UnitFactory getUnitConvertorObject method - conversionType is null ");
			return null;
		}
		if (conversionType.equalsIgnoreCase(ConversionType.VOLUME.toString())) {
			LOGGER.info("in UnitFactory getUnitConvertorObject method - VolumeImpl  Object created ");
			return new VolumeImpl();

		} else if (conversionType.equalsIgnoreCase(ConversionType.TEMPERATURE.toString())) {
			LOGGER.info("in UnitFactory getUnitConvertorObject method - TemperatureImpl  Object created  ");
			return new TemperatureImpl();

		}
		return null;
	}
}
