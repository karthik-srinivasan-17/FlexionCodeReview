package com.flexion.coding.challenge.utilities;

import java.lang.reflect.Field;

public final  class Constants {


	/// Temperature  Constants
	public static final Double KELVIN_to_CELSIUS = -272.1500;
	public static final Double KELVIN_to_FAHRENHEIT = -457.8700;
	public static final Double KELVIN_to_RANKINE = 1.800;
	public static final Double CELSIUS_to_KELVIN= 274.1500;
	public static final Double CELSIUS_to_FAHRENHEIT = 33.8000;
	public static final Double CELSIUS_to_RANKINE = 493.4700;
	public static final Double FAHRENHEIT_to_KELVIN = 255.9200;
	public static final Double FAHRENHEIT_to_CELSIUS = -17.2200;
	public static final Double FAHRENHEIT_to_RANKINE = 460.6700;
	public static final Double RANKINE_to_CELSIUS = -272.5900;
	public static final Double RANKINE_to_FAHRENHEIT = -458.6700;
	public static final Double RANKINE_to_KELVIN = 0.5500;

	/// Volume Constants
	public static final Double LITER_to_TABLESPOON = 67.6280;
	public static final Double LITER_to_CUBICINCH = 61.0237;
	public static final Double LITER_to_CUP = 4.2267;
	public static final Double LITER_to_CUBICFEET= 0.03531;
	public static final Double LITER_to_GALLON = 0.2641;
	public static final Double TABLESPOON_to_LITER = 0.014786;
	public static final Double TABLESPOON_to_CUBICINCH = 0.902343;
	public static final Double TABLESPOON_to_CUP = 0.0625;
	public static final Double TABLESPOON_to_CUBICFEET = 0.00052219;
	public static final Double TABLESPOON_to_GALLON = 0.00390625;
	public static final Double CUBICINCH_to_LITER = 0.01638706;
	public static final Double CUBICINCH_to_TABLESPOON = 1.10822511;
	public static final Double CUBICINCH_to_CUP= 0.06926;
	public static final Double CUBICINCH_to_CUBICFEET= 0.0005787;
	public static final Double CUBICINCH_to_GALLON= 0.004329;
	public static final Double GALLON_to_LITER = 3.7854;
	public static final Double GALLON_to_TABLESPOON = 256.0;
	public static final Double GALLON_to_CUP= 16.0;
	public static final Double GALLON_to_CUBICFEET= 0.1336;
	public static final Double GALLON_to_CUBICINCH= 231.0;
	public static final Double CUP_to_LITER = 0.236588125;
	public static final Double CUP_to_TABLESPOON = 16.0;
	public static final Double CUP_to_GALLON= 0.0625;
	public static final Double CUP_to_CUBICFEET= 0.0083550308;
	public static final Double CUP_to_CUBICINCH= 14.437493196;
	public static final Double CUBICFEET_to_LITER = 28.316846592;
	public static final Double CUBICFEET_to_TABLESPOON = 1915.0138895;
	public static final Double CUBICFEET_to_CUP= 119.6883681;
	public static final Double CUBICFEET_to_CUBICINCH= 1728.0;
	public static final Double CUBICFEET_to_GALLON= 7.480523006;



public static Double getValue(String str) throws ReflectiveOperationException {
	Constants field = new Constants(); 
	 Field fieldsOfConstantsClass = Constants.class.getField(str); 
	 Object value=fieldsOfConstantsClass.get(field);
	return (Double) value;
}
}
