package com.example.unitconversion.convertunit;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Unit;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;

public class UoMUtil {

	public static int id = 1;

	public static final Map<String, UVolume> volume = makeVolumeList();
	public static final Map<String, UTemperature> temperature = makeTemperatureList();
	

	private static Map<String, UVolume> makeVolumeList(){
		
		UVolume a = new UVolume();
		
		
		Map<String, UVolume> ret = new HashMap<String, UVolume>();

		addToVolume(ret, UoM.LITER, "Liters");
		addToVolume(ret, UoM.TABLESPOON, "Table Spoons");
		addToVolume(ret, UoM.CUP, "Cups");
		addToVolume(ret, UoM.CUBIC_INCH, "Cubic Inches");
		addToVolume(ret, UoM.CUBIC_FOOT, "Cubic Feet");
		addToVolume(ret, UoM.GALLON, "Gallons");

		return ret;
	}


	
	private static Map<String, UTemperature> makeTemperatureList(){
		Map<String, UTemperature> ret = new HashMap<String, UTemperature>();

		addToTemperature(ret, UoM.KELVIN, "Kelvin");
		addToTemperature(ret, UoM.FAHRENHEIT, "Fahrenheit");
		addToTemperature(ret, UoM.CELSIUS, "Celsius");
		addToTemperature(ret, UoM.RANKINE, "Rankine");

		return ret;
	}

	private static void addToVolume(
			Map<String, UVolume> ret, 
			Unit<Volume> unit, 
			String name
			) {
		UVolume item = new UVolume( unit, name);
		ret.put(item.getKey(), item);
	}

	
	private static void addToTemperature(
			Map<String, UTemperature> ret, 
			Unit<Temperature> unit, String name
			) {
		UTemperature item = new UTemperature( unit, name);
		ret.put(item.getKey(), item);
	}
	
}
