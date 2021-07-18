package com.demo.SmartHealthcare;
import java.util.Random;

public class GeneratePatientInfo {
	public static void main(String[] args) throws InterruptedException {
		
		while (true) {
			int records = new Random().nextInt(5)+1;
			for (int i = 1; i <= records; i++) {

				
				PatientInfo patientinfo = new PatientInfo();
				patientinfo.generatePatientId();
				patientinfo.Thermometer();
				patientinfo.HeartPulse();
				patientinfo.BPsensor();
				patientinfo.Glucometer();
				patientinfo.Oximeter();
				patientinfo.needsMedicalAttention();
				
				SimpleKafkaProducer.sendDataToKafkaSingleBroker(patientinfo.toString(), "patient-info");
				System.out.println(patientinfo.toString());
			}
			System.out.println("-------------------------------------------------");
			Thread.sleep(1000);
		}
		
	}
	


}

