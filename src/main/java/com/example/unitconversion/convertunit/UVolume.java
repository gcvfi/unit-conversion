package com.example.unitconversion.convertunit;

import java.util.Map;

import javax.measure.Unit;
import javax.measure.quantity.Volume;

public class UVolume extends UoM{

	private String key;
	private String name;
	private Unit<Volume>  unit;

	public UVolume() {	
		int i = 1;
		i++;
	}

	public UVolume(Unit<Volume>  unit, String name) {
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
	public Unit<Volume>  getUnit() {
		return unit;
	}
	
	public static Boolean convertVolume(UItem item){
		Boolean ret = false;
		String fromKey = item.getFromKey();
		String toKey = item.getToKey();
		Map<String, UVolume> list = UoMUtil.volume;
		
		if(! list.containsKey(fromKey)) {
			return ret;
		}
		if(! list.containsKey(toKey)) {
			return ret;			
		}
		
		
		Unit<Volume> fromUoM = list.get(fromKey).getUnit();
		Unit<Volume> toUoM = list.get(toKey).getUnit();
		
		Double fromValue = item.getFromValue();
		Double calcValue = (Double) fromUoM.getConverterTo(toUoM).convert(fromValue);
		
		item.setCalcValue(calcValue); 
		ret = true;
		item.setResultAvailable(ret);
		return ret;
		
	}
	
	
}
