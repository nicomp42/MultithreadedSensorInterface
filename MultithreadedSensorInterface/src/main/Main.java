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
		
		while (true) {
			try { Thread.sleep(1000);} catch(Exception ex) {}
			System.out.println("Sensor value = " + sensorReader.getValue());
		}
		
	}
}
