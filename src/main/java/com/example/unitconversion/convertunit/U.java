package com.example.unitconversion.convertunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class U {
	public static final String KELVIN = "Kelvin";
	public static final String FAHRENHEIT = "Fahrenheit";
	public static final String CELSIUS = "Celsius";
	public static final String RANKINE = "Rankine";

	public static final String LITER = "Liters";
	public static final String TABLESPOON = "Table Spoons";
	public static final String CUP = "Cups";
	public static final String CUBIC_INCH = "Cubic Inches";
	public static final String CUBIC_FOOT = "Cubic Feet";
	public static final String GALLON = "Gallons";

	private static final List<String> tempa = Arrays.asList(//
			KELVIN, FAHRENHEIT, CELSIUS, RANKINE);
	private static final List<String> volume = Arrays.asList(//
			LITER, TABLESPOON, CUP, //
			CUBIC_INCH, CUBIC_FOOT, GALLON);
	private static final List<String> units = makeUnits();

	private static final List<String> sTempa = convertToLower(tempa);

	private static final List<String> sVolume = convertToLower(volume);

	private static final List<String> sUnits = convertToLower(units);

	private static <T> Stream<T> convertListToStream(List<T> list) {
		return list.stream();
	}

	private static final List<String> convertToLower(List<String> upper) {
		return convertListToStream(upper) //
				.map(v -> v.toLowerCase()) //
				.collect(Collectors.toList());
	}

	private static final List<String> makeUnits() {

		List<String> merged = new ArrayList(tempa);
		merged.addAll(volume);
		return merged;
	}

	public static final List<String> getTempa() {
		return tempa;
	}

	public static final List<String> getVolume() {
		return volume;
	}

	public static final List<String> getUnits() {
		return units;
	}

	public static final Boolean isVolume(String unit) {
		return sVolume.contains(unit);
	}

	public static final Boolean isTempa(String unit) {
		return sTempa.contains(unit);
	}

}
