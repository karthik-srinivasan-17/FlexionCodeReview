package com.flexion.coding.challenge.unitconversion.entity;

public class Entries {

	public int id;
	public String ConversionType;
	public String fromMeasurement;
	public String toMeasurement;
	public String askedValue;
	public String writtenValue;
	public String result;

	public String getFromMeasurement() {
		return fromMeasurement;
	}

	public void setFromMeasurement(String fromMeasurement) {
		this.fromMeasurement = fromMeasurement;
	}

	public String getToMeasurement() {
		return toMeasurement;
	}

	public void setToMeasurement(String toMeasurement) {
		this.toMeasurement = toMeasurement;
	}

	public String getAskedValue() {
		return askedValue;
	}

	public void setAskedValue(String askedValue) {
		this.askedValue = askedValue;
	}

	public String getWrittenValue() {
		return writtenValue;
	}

	public void setWrittenValue(String writtenValue) {
		this.writtenValue = writtenValue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConversionType() {
		return ConversionType;
	}

	public void setConversionType(String conversionType) {
		ConversionType = conversionType;
	}
}
