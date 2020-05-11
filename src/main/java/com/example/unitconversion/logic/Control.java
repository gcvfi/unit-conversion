package com.example.unitconversion.logic;

import com.example.unitconversion.convertunit.UC;
import com.example.unitconversion.convertunit.UItem;
import com.example.unitconversion.entity.Answer;
import com.example.unitconversion.repository.AnswerRepository;

public class Control {

	public static Boolean updateDB(AnswerRepository answerRepo, Answer answer) {
		Boolean ret = false;

		UItem item = new UItem();
		item.setFromKey(answer.getFromUnit());
		item.setFromValue(answer.getFromValue());
		item.setToKey(answer.getToUnit());
		item.setToValue(answer.getToValue());

		answer.setCalcValue(1234.0); // just a default value for debugging

		//
		// Use following commented code with a good javax.measure.
		// implementation systems.uom.ucum.UCUM had many units 
		// but is failing to load class
		//
		// if (UTemperature.convertTemperature(item)) {
		//    answer.setCalcValue(item.getCalcValue());
		// } else if (UVolume.convertVolume(item)) {
		//    answer.setCalcValue(item.getCalcValue());
		// }
		//

		if (UC.convertVolume(item)) {
			answer.setCalcValue(item.getCalcValue());
		} else if (UC.convertTempa(item)) {
			answer.setCalcValue(item.getCalcValue());
		}

		Double roundCalcValue = round10th(item.getCalcValue());
		answer.setRoundValue(roundCalcValue);

		Double roundToValue = round10th(item.getToValue());

		if (roundToValue.equals(roundCalcValue)) {
			answer.setResultStatus("correct");
		} else {
			answer.setResultStatus("incorrect");
		}

		answerRepo.save(answer);

		return ret;
	}

	private static Double round10th(Double input) {
		return Math.round(input * 10.0) / 10.0;
	}

}