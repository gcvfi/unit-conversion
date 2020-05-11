package com.example.unitconversion.convertunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.measure.Unit;
import javax.measure.quantity.Volume;

public class UC {
	private static final Double an_ounce_to_ml = 29.5735295625;
	private static final Double a_tablespoon_to_ml = an_ounce_to_ml / 2;
	private static final Double a_gallon_to_liter  = 3.785411784;
	private static final Double an_inch_to_meter = 1 / 39.37;
	private static final Double a_foot_to_meter = 12 * an_inch_to_meter;
	private static final Double an_inch3_to_meter3 = an_inch_to_meter * an_inch_to_meter * an_inch_to_meter;
	private static final Double a_foot3_to_meter3 = a_foot_to_meter * a_foot_to_meter * a_foot_to_meter;
	
	private static final Double a_meter3_to_liter = 1000.0;
	private static final Double a_liter_to_ml = 1000.0;
	private static final Double a_ml_to_liter = 1.0 / a_liter_to_ml;
	private static final Double a_cup_to_ml = 236.5882365;
	private static final Double a_cup_to_liter = a_cup_to_ml / a_liter_to_ml;

	private static final Double zero_celsius_to_kelvin = 273.15;
	private static final Double one_kelvin_to_rankine = 9.0 / 5.0;
	private static final Double one_rankine_to_kelvin = 1.0 / one_kelvin_to_rankine;
	private static final Double zero_fahrenheit_to_rankine = 459.67;

	public static final Double toLiters(String unit, Double from) {
		Double ret = 0.0;
		if (U.LITER.equalsIgnoreCase(unit)) {
			ret = from;
		} else if (U.CUP.equalsIgnoreCase(unit)) {
			ret = from * a_cup_to_liter;
		} else if (U.GALLON.equalsIgnoreCase(unit)) {
			ret = from * a_gallon_to_liter;
		} else if (U.CUBIC_INCH.equalsIgnoreCase(unit)) {
			ret = from * an_inch3_to_meter3 * a_meter3_to_liter;
		} else if (U.CUBIC_FOOT.equalsIgnoreCase(unit)) {
			ret = from * a_foot3_to_meter3 * a_meter3_to_liter;
		} else if (U.TABLESPOON.equalsIgnoreCase(unit)) {
			ret = from * a_tablespoon_to_ml * a_ml_to_liter;
		}
		return ret;
	}

	public static final Double fromLiters(String unit, Double from) {
		Double ret = 0.0;
		if (U.LITER.equalsIgnoreCase(unit)) {
			ret = from;
		} else if (U.CUP.equalsIgnoreCase(unit)) {
			ret = from / a_cup_to_liter;
		} else if (U.GALLON.equalsIgnoreCase(unit)) {
			ret = from / a_gallon_to_liter;
		} else if (U.CUBIC_INCH.equalsIgnoreCase(unit)) {
			ret = from / (an_inch3_to_meter3 * a_meter3_to_liter);
		} else if (U.CUBIC_FOOT.equalsIgnoreCase(unit)) {
			ret = from / (a_foot3_to_meter3 * a_meter3_to_liter);
		} else if (U.TABLESPOON.equalsIgnoreCase(unit)) {
			ret = from / (a_tablespoon_to_ml * a_ml_to_liter);
		}
		return ret;
	}

	public static Boolean convertVolume(UItem item) {
		Boolean ret = false;
		String fromKey = item.getFromKey();
		String toKey = item.getToKey();

		if (!U.isVolume(fromKey)) {
			return ret;
		}
		if (!U.isVolume(toKey)) {
			return ret;
		}

		Double fromValue = item.getFromValue();
		Double stdValue = toLiters(fromKey, fromValue);
		Double calcValue = fromLiters(toKey, stdValue);

		item.setCalcValue(calcValue);
		ret = true;
		item.setResultAvailable(ret);
		return ret;

	}

	public static Boolean convertTempa(UItem item) {
		Boolean ret = false;
		String fromKey = item.getFromKey();
		String toKey = item.getToKey();

		if (!U.isTempa(fromKey)) {
			return ret;
		}
		if (!U.isTempa(toKey)) {
			return ret;
		}

		Double fromValue = item.getFromValue();
		Double stdValue = toKelvin(fromKey, fromValue);
		Double calcValue = fromKelvin(toKey, stdValue);

		item.setCalcValue(calcValue);
		ret = true;
		item.setResultAvailable(ret);
		return ret;

	}
	
	// Formula https://en.wikipedia.org/wiki/Kelvin#Practical_uses
	public static final Double toKelvin(String unit, Double from) {
		Double ret = 0.0;
		if (U.KELVIN.equalsIgnoreCase(unit)) {
			ret = from;
		} else if (U.CELSIUS.equalsIgnoreCase(unit)) {
			ret = from + zero_celsius_to_kelvin;
		} else if (U.FAHRENHEIT.equalsIgnoreCase(unit)) {
			ret = (from + zero_fahrenheit_to_rankine) * one_rankine_to_kelvin;
		} else if (U.RANKINE.equalsIgnoreCase(unit)) {
			ret = from * one_rankine_to_kelvin;
		}
		return ret;
	}

	// Formula https://en.wikipedia.org/wiki/Kelvin#Practical_uses
	public static final Double fromKelvin(String unit, Double from) {
		Double ret = 0.0;
		if (U.KELVIN.equalsIgnoreCase(unit)) {
			ret = from;
		} else if (U.CELSIUS.equalsIgnoreCase(unit)) {
			ret = from - zero_celsius_to_kelvin;
		} else if (U.FAHRENHEIT.equalsIgnoreCase(unit)) {
			ret = from * one_kelvin_to_rankine - zero_fahrenheit_to_rankine;
		} else if (U.RANKINE.equalsIgnoreCase(unit)) {
			ret = from * one_kelvin_to_rankine;
		}
		return ret;
	}

}
