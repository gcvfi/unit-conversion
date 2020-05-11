package com.example.unitconversion.convertunit;

import javax.measure.Unit;
import javax.measure.quantity.Temperature;

import java.util.Map;

public class UTemperature {
	
	private String key;
	private String name;
	private Unit<Temperature>  unit;
	
	public UTemperature() {
		int i = 1;
		i++;
	}
	
	public UTemperature(Unit<Temperature>  unit, String name) {
		super();
		this.key = name.toLowerCase();
		this.name = name;
		this.unit = unit;
	}
	public String getKey() {
		return key;
	}
	public String getName() {
		return name;
	}
	public Unit<Temperature>  getUnit() {
		return unit;
	}
	

	public static Boolean convertTemperature(UItem item){
		Boolean ret = false;
		String fromKey = item.getFromKey();
		String toKey = item.getToKey();
		Map<String, UTemperature>  list = UoMUtil.temperature;
		
		if(! list.containsKey(fromKey)) {
			return ret;
		}
		if(! list.containsKey(toKey)) {
			return ret;			
		}
		
		
		Unit<Temperature> fromUoM = list.get(fromKey).getUnit();
		Unit<Temperature> toUoM = list.get(toKey).getUnit();
		
		Double fromValue = item.getFromValue();
		Double calcValue = (Double) fromUoM.getConverterTo(toUoM).convert(fromValue);
		
		item.setCalcValue(calcValue); 
		ret = true;
		item.setResultAvailable(ret);
		return ret;
		
	}
	
	
}
