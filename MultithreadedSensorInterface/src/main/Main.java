/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import sensor.Sensor;

public class Main {

	public static void main(String[] args) {
		SensorReader sensorReader = new SensorReader();
		Sensor temperatureSensor = new Sensor(sensorReader);
		temperatureSensor.start();	// Start the sensor thread
		
		while (true) {
			try { Thread.sleep(1000);} catch(Exception ex) {}
			System.out.println("Sensor value = " + sensorReader.getValue());
		}
	}
}
