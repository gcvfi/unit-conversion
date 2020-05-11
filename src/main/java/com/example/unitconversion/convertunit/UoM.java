package com.example.unitconversion.convertunit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;

import systems.uom.ucum.UCUM;

//import si.uom.NonSI;
//import si.uom.SI;

public class UoM{
	public static final Unit<Temperature> KELVIN = UCUM.KELVIN;
	public static final Unit<Temperature> FAHRENHEIT = UCUM.FAHRENHEIT;
	public static final Unit<Temperature> CELSIUS = UCUM.CELSIUS;
	public static final Unit<Temperature> RANKINE = UCUM.RANKINE;

	public static final Unit<Volume> LITER = UCUM.LITER;
	public static final Unit<Volume> TABLESPOON = UCUM.TABLESPOON_US;
	public static final Unit<Volume> CUP = UCUM.CUP_US;
	public static final Unit<Volume> CUBIC_INCH = UCUM.CUBIC_INCH_INTERNATIONAL;
	public static final Unit<Volume> CUBIC_FOOT = UCUM.CUBIC_FOOT_INTERNATIONAL;
	public static final Unit<Volume> GALLON = UCUM.GALLON_US;
	
	
}
