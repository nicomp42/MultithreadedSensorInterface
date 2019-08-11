/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import sensor.Sensor;
import sensor.SensorReader;

public class Main {

	public static void main(String[] args) {
		demo();
	}
	/**
	 * This is our app. In the app we read from the sensor and do something, or a lot of somethings. 
	 */
	public static void demo() {
		SensorReader sensorReader = new SensorReader();
		Sensor temperatureSensor = new Sensor(sensorReader);
		temperatureSensor.start();	// Start the sensor thread
		
		float sum = 0, average;
		float count = 0;
		while (true) {
			try {Thread.sleep(1000);} catch(Exception ex) {}	// One second between sensor readings
			float value = sensorReader.getValue();
			sum += value;
			count++;
			average = sum / count;
			System.out.println("Sensor value = " + value + ", average value = " + average);
		}
		
	}
}
