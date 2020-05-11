package com.example.unitconversion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.unitconversion.convertunit.U;
import com.example.unitconversion.convertunit.UC;
import com.example.unitconversion.convertunit.UItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	private static Double round10th(Double input) {
		return Math.round(input * 10.0) / 10.0;
	}

	@Test
	public void testToKelvin() {
		Double result = 0.0;
		Double expected = 0.0;

		result = UC.toKelvin(U.KELVIN, 100.0);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toKelvin(U.CELSIUS, 0.0);
		expected = round10th(273.15);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toKelvin(U.FAHRENHEIT, 0.0);
		expected = round10th(255.372);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toKelvin(U.RANKINE, 100.0);
		expected = round10th(55.5556);
		assertThat(round10th(result)).isEqualTo(expected);

	}

	@Test
	public void testFromKelvin() {
		Double result = 0.0;
		Double expected = 0.0;

		result = UC.fromKelvin(U.KELVIN, 100.0);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromKelvin(U.CELSIUS, 273.15);
		expected = round10th(0.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromKelvin(U.FAHRENHEIT, 255.372);
		expected = round10th(0.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromKelvin(U.RANKINE, 55.5556);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

	}

	@Test
	public void testToLiters() {
		Double result = 0.0;
		Double expected = 0.0;

		result = UC.toLiters(U.LITER, 100.0);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toLiters(U.GALLON, 100.0);
		expected = round10th(378.541);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toLiters(U.TABLESPOON, 1000.0);
		expected = round10th(14.7868);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toLiters(U.CUP, 1000.0);
		expected = round10th(236.588);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toLiters(U.CUBIC_FOOT, 10.0);
		expected = round10th(283.168);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.toLiters(U.CUBIC_INCH, 1000.0);
		expected = round10th(16.3871);
		assertThat(round10th(result)).isEqualTo(expected);

	}

	@Test
	public void testFromLiters() {
		Double result = 0.0;
		Double expected = 0.0;

		result = UC.fromLiters(U.LITER, 100.0);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromLiters(U.GALLON, 378.541);
		expected = round10th(100.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromLiters(U.TABLESPOON,14.7868 );
		expected = round10th(1000.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromLiters(U.CUP,236.588);
		expected = round10th( 1000.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromLiters(U.CUBIC_FOOT, 283.168);
		expected = round10th(10.0);
		assertThat(round10th(result)).isEqualTo(expected);

		result = UC.fromLiters(U.CUBIC_INCH,16.3871);
		expected = round10th( 1000.0);
		assertThat(round10th(result)).isEqualTo(expected);


	}

	
	@Test
	public void testConvertVolume() {
		Boolean result = false;
		
		result = checkSameVolume(U.LITER);
		assertThat(result).isEqualTo(true);

		result = checkSameVolume(U.GALLON);
		assertThat(result).isEqualTo(true);


		result = checkSameVolume(U.TABLESPOON);
		assertThat(result).isEqualTo(true);

		result = checkSameVolume(U.CUBIC_FOOT);
		assertThat(result).isEqualTo(true);

		result = checkSameVolume(U.CUBIC_INCH);
		assertThat(result).isEqualTo(true);

	}
	private Boolean checkSameVolume(String unit) {
		Boolean ret = false;
		Double val = 100.0;		
		ret = testConvertVolume(unit, unit, val, val);
		return ret;			

	}

	private Boolean testConvertVolume(String from, String to, 
			Double val, Double expected) {
		Boolean ret = false;
		UItem item = new UItem();
		item.setFromKey(from.toLowerCase());
		item.setToKey(to.toLowerCase());
		item.setFromValue(val);
		item.setToValue(val);
		
		if(! UC.convertVolume(item)) {
			return ret;			
		}
		
		if(! item.getResultAvailable() ) {
			return ret;			
		}
		
		Double expectedRound  = round10th(expected)				;
		Double actualRound  = round10th(item.getCalcValue());
				
		ret = actualRound.equals(expectedRound);
		return ret;
	}

	@Test
	public void testConvertTempa() {
		Boolean result = false;
		
		result = checkSameTempa(U.KELVIN);
		assertThat(result).isEqualTo(true);

		result = checkSameTempa(U.CELSIUS);
		assertThat(result).isEqualTo(true);

		result = checkSameTempa(U.FAHRENHEIT);
		assertThat(result).isEqualTo(true);

		result = checkSameTempa(U.RANKINE);
		assertThat(result).isEqualTo(true);

	}

	private Boolean checkSameTempa(String unit) {
		Boolean ret = false;
		Double val = 100.0;		
		ret = testConvertTempa(unit, unit, val, val);
		return ret;			
	}
	
	private Boolean testConvertTempa(String from, String to, 
			Double val, Double expected) {
		Boolean ret = false;
		UItem item = new UItem();
		item.setFromKey(from.toLowerCase());
		item.setToKey(to.toLowerCase());
		item.setFromValue(val);
		item.setToValue(val);
		
		if(! UC.convertTempa(item)) {
			return ret;			
		}
		
		if(! item.getResultAvailable() ) {
			return ret;			
		}
		
		Double expectedRound  = round10th(expected)				;
		Double actualRound  = round10th(item.getCalcValue());
				
		ret = actualRound.equals(expectedRound);
		return ret;
	}
	@Test
	public void testGenralConvert() {
		Boolean result = false;
		
		result = testConvertTempa(U.FAHRENHEIT, U.CELSIUS, 32.0, 0.0);
		assertThat(result).isEqualTo(true);
		result = testConvertTempa(U.CELSIUS, U.FAHRENHEIT, 0.0, 32.0);
		assertThat(result).isEqualTo(true);

		result = testConvertVolume(U.CUP, U.TABLESPOON, 1.0, 16.0);
		assertThat(result).isEqualTo(true);
		result = testConvertVolume(U.TABLESPOON, U.CUP, 16.0, 1.0);
		assertThat(result).isEqualTo(true);

		result = testConvertVolume(U.CUBIC_FOOT, U.CUBIC_INCH, 1.0, 1728.0);
		assertThat(result).isEqualTo(true);
		result = testConvertVolume(U.CUBIC_INCH, U.CUBIC_FOOT, 1728.0, 1.0);
		assertThat(result).isEqualTo(true);

	}

}
