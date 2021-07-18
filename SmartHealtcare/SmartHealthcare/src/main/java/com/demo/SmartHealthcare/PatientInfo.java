/*package com.demo.SmartHealthcare;
import com.google.gson.Gson;

public class PatientInfo {
	
	
	private String patientId;
	private double body_temperature;
	private double heart_rate;
	private double blood_pressure;
	private double glucose;
	private double oxygen_level;
	private boolean critical_condition;

	public PatientInfo(String patientId, double body_temperature, double heart_rate, double blood_pressure,
			double glucose, double oxygen_level, boolean critical_condition) {
		super();
		this.patientId = patientId;
		this.body_temperature = body_temperature;
		this.heart_rate = heart_rate;
		this.blood_pressure = blood_pressure;
		this.glucose = glucose;
		this.oxygen_level = oxygen_level;
		this.critical_condition = critical_condition;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public double getBody_temperature() {
		return body_temperature;
	}

	public void setBody_temperature(double body_temperature) {
		this.body_temperature = body_temperature;
	}

	public double getHeart_rate() {
		return heart_rate;
	}

	public void setHeart_rate(double heart_rate) {
		this.heart_rate = heart_rate;
	}

	public double getBlood_pressure() {
		return blood_pressure;
	}

	public void setBlood_pressure(double blood_pressure) {
		this.blood_pressure = blood_pressure;
	}

	public double getGlucose() {
		return glucose;
	}

	public void setGlucose(double glucose) {
		this.glucose = glucose;
	}

	public double getOxygen_level() {
		return oxygen_level;
	}

	public void setOxygen_level(double oxygen_level) {
		this.oxygen_level = oxygen_level;
	}

	public boolean isCritical_condition() {
		return critical_condition;
	}

	public void setCritical_condition(boolean critical_condition) {
		this.critical_condition = critical_condition;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}*/





package com.demo.SmartHealthcare;
import java.util.Random;
import com.google.gson.Gson;

public class PatientInfo {

	
	private String patientId;
	private double body_temperature;
	private int heart_rate;
	private int blood_pressure;
	private int glucose;
	private int oxygen_level;
	private boolean requires_medical_attention;
	
	public String generatePatientId() {
	
		Random ran = new Random();
		int x = ran.nextInt(20) + 1020;
		this.patientId = String.valueOf(x);
		return this.patientId;
	}
	
	public double Thermometer() {
		
		Random ran = new Random();
		this.body_temperature = 96 + (110 - 96) * ran.nextDouble();
		return this.body_temperature;
		 
		
	}
	
	public int BPsensor() {
		
		Random ran = new Random();
		this.blood_pressure =  ran.nextInt(15) + 70;
		return this.blood_pressure;
	}
	
	public int Glucometer() {
		
		Random ran = new Random();
		this.glucose = ran.nextInt(15) + 100;
		return this.glucose;
		
	}
	
	public int Oximeter() {
		
		Random ran = new Random();
		this.oxygen_level = ran.nextInt(10) + 87;
		return this.oxygen_level;
	}
	
	public int HeartPulse() {
		
		Random ran = new Random();
		this.heart_rate = ran.nextInt(20) + 70;
		return this.heart_rate;
		
	}
	
	public boolean needsMedicalAttention() {
		
		if(this.oxygen_level<90 ||this.body_temperature > 108 )
			this.requires_medical_attention=  true;
		else
			this.requires_medical_attention = false;
		
		return requires_medical_attention;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}


}


