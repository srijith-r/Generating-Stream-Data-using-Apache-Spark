package com.demo.SmartHealthcare;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;

import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;

public class PatientSparkStreaming {
	public static void main(String[] args) throws InterruptedException, StreamingQueryException, TimeoutException {
		SparkConf conf = new SparkConf().setAppName("Patient-Info-Stream").setMaster("local[*]");

		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

		Dataset<Row> truckinfoDf = spark.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers","localhost:9092,anotherhost:9092")
				.option("subscribe", "patient-info")
				.load()
				.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
				.select(get_json_object(col("value"), "$.patientId").alias("patientId"),
						get_json_object(col("value"), "$.heart_rate").alias("heart_rate"),
						get_json_object(col("value"), "$.blood_pressure").alias("blood_pressure"),
						get_json_object(col("value"), "$.glucose").alias("glucose"),
						get_json_object(col("value"), "$.oxygen_level").alias("oxygen_level"),
						get_json_object(col("value"), "$.speed").alias("speed"),
						get_json_object(col("value"), "$.requires_medical_attention").alias("requires_medical_attention"));


		Dataset<Row> busInfo = truckinfoDf.filter(col("requires_medical_attention").equalTo(true));
		busInfo.writeStream().format("json")
				.option("checkpointLocation",
						"/home/srijith/Desktop/PatientData/simulated-data/check-point")
				.option("path", "/home/srijith/Desktop/PatientData/simulated-data/out/bus").start()
				.awaitTermination();

	}

}


