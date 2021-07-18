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


