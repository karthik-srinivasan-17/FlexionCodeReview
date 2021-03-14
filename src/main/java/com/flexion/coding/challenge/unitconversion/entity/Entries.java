package com.flexion.coding.challenge.unitconversion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Entries {

	@Id
	@Column
	@GeneratedValue
	public long id;
	@Column
	@NotNull
	public String conversionType;

	@Column
	@NotNull
	public String fromMeasurement;
	@Column
	@NotNull
	public String toMeasurement;
	@Column
	@NotNull
	public String askedValue;
	@Column
	@NotNull
	public String writtenValue;
	@Column
	@NotNull
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConversionType() {
		return conversionType;
	}

	public void setConversionType(String conversionType) {
		this.conversionType = conversionType;
	}

}
