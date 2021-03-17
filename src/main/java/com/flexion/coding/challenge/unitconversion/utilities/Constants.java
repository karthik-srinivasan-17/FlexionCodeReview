package com.flexion.coding.challenge.unitconversion.utilities;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public final class Constants implements Serializable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);


	/**
	 * 
	 */
	private static final long serialVersionUID = -8067181914827459152L;
	/// Temperature Constants
	public final Double KELVIN_to_CELSIUS = -272.1500;
	public final Double KELVIN_to_FAHRENHEIT = -457.8700;
	public final Double KELVIN_to_RANKINE = 1.800;
	public final Double CELSIUS_to_KELVIN = 274.1500;
	public final Double CELSIUS_to_FAHRENHEIT = 33.8000;
	public final Double CELSIUS_to_RANKINE = 493.4700;
	public final Double FAHRENHEIT_to_KELVIN = 255.9200;
	public final Double FAHRENHEIT_to_CELSIUS = -17.2200;
	public final Double FAHRENHEIT_to_RANKINE = 460.6700;
	public final Double RANKINE_to_CELSIUS = -272.5900;
	public final Double RANKINE_to_FAHRENHEIT = -458.6700;
	public final Double RANKINE_to_KELVIN = 0.5500;

	/// Volume Constants
	public final Double LITER_to_TABLESPOON = 67.6280;
	public final Double LITER_to_CUBICINCH = 61.0237;
	public final Double LITER_to_CUP = 4.2267;
	public final Double LITER_to_CUBICFEET = 0.03531;
	public final Double LITER_to_GALLON = 0.2641;
	public final Double TABLESPOON_to_LITER = 0.014786;
	public final Double TABLESPOON_to_CUBICINCH = 0.902343;
	public final Double TABLESPOON_to_CUP = 0.0625;
	public final Double TABLESPOON_to_CUBICFEET = 0.00052219;
	public final Double TABLESPOON_to_GALLON = 0.00390625;
	public final Double CUBICINCH_to_LITER = 0.01638706;
	public final Double CUBICINCH_to_TABLESPOON = 1.10822511;
	public final Double CUBICINCH_to_CUP = 0.06926;
	public final Double CUBICINCH_to_CUBICFEET = 0.0005787;
	public final Double CUBICINCH_to_GALLON = 0.004329;
	public final Double GALLON_to_LITER = 3.7854;
	public final Double GALLON_to_TABLESPOON = 256.0;
	public final Double GALLON_to_CUP = 16.0;
	public final Double GALLON_to_CUBICFEET = 0.1336;
	public final Double GALLON_to_CUBICINCH = 231.0;
	public final Double CUP_to_LITER = 0.236588125;
	public final Double CUP_to_TABLESPOON = 16.0;
	public final Double CUP_to_GALLON = 0.0625;
	public final Double CUP_to_CUBICFEET = 0.0083550308;
	public final Double CUP_to_CUBICINCH = 14.437493196;
	public final Double CUBICFEET_to_LITER = 28.316846592;
	public final Double CUBICFEET_to_TABLESPOON = 1915.0138895;
	public final Double CUBICFEET_to_CUP = 119.6883681;
	public final Double CUBICFEET_to_CUBICINCH = 1728.0;
	public final Double CUBICFEET_to_GALLON = 7.480523006;

	public static Double getValue(String fieldName) {
		
		LOGGER.info("in Constants class getValue method - Field Name searching is " + fieldName);
		Constants constantObject = new Constants();

		Object value = null;
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		Map<String, Object> props = mapper.convertValue(constantObject, Map.class);

		for (Map.Entry<String, Object> entry : props.entrySet()) {
			if (entry.getKey().equals(fieldName)) {
				
				value = entry.getValue();
			}

		}
		
		LOGGER.debug("in Constants class getValue method - Field value found is " + value);

		/*
		 * Field fieldsOfConstantsClass; try { fieldsOfConstantsClass =
		 * Constants.class.getField(str); value =
		 * fieldsOfConstantsClass.get(constantObject); } catch (NoSuchFieldException |
		 * SecurityException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); return null; } catch (IllegalArgumentException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); return null; } catch
		 * (IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); return null; }
		 */
		return (Double) value;
	}
}
