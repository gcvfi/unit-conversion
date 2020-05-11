package com.example.unitconversion.convertunit;


public class UItem {

	private String fromKey = "";
	private Double fromValue = 0.0;
	private String toKey = "";
	private Double toValue = 0.0;
	private Double calcValue = 0.0;
	private Boolean resultAvailable = false;

	public String getFromKey() {
		return fromKey;
	}

	public void setFromKey(String fromKey) {
		this.fromKey = fromKey.toLowerCase();
	}

	public Double getFromValue() {
		return fromValue;
	}

	public void setFromValue(Double fromValue) {
		this.fromValue = fromValue;
	}

	public String getToKey() {
		return toKey;
	}

	public void setToKey(String toKey) {
		this.toKey = toKey.toLowerCase();
	}

	public Double getToValue() {
		return toValue;
	}

	public void setToValue(Double toValue) {
		this.toValue = toValue;
	}

	public Double getCalcValue() {
		return calcValue;
	}

	public void setCalcValue(Double calcValue) {
		this.calcValue = calcValue;
	}

	public Boolean getResultAvailable() {
		return resultAvailable;
	}

	public void setResultAvailable(Boolean resultAvailable) {
		this.resultAvailable = resultAvailable;
	}

}
