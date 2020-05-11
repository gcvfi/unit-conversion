package com.example.unitconversion.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "student_id")
    private long studentId;
    
    @NotBlank(message = "From Unit is mandatory")
    @Column(name = "from_unit")
    private String fromUnit;
    
    @NotBlank(message = "To Unit is mandatory")
    @Column(name = "to_unit")
    private String toUnit;

    @Column(name = "from_value")
    private Double fromValue;

    @Column(name = "to_value")
    private Double toValue;

    @Column(name = "calc_value")
    private Double calcValue;

    @Column(name = "round_value")
    private Double roundValue;

    
    @Column(name = "result_status")
    private String resultStatus;
    
    public Answer() {}

    public Answer(String fromUnit, String toUnit) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFromUnit() {
		return fromUnit;
	}

	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}

	public String getToUnit() {
		return toUnit;
	}

	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}

	public Double getFromValue() {
		return fromValue;
	}

	public void setFromValue(Double fromValue) {
		this.fromValue = fromValue;
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

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Double getRoundValue() {
		return roundValue;
	}

	public void setRoundValue(Double roundValue) {
		this.roundValue = roundValue;
	}



}