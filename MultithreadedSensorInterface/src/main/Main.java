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
		SensorReader temperatureSensorReader = new SensorReader();
		Sensor temperatureSensor = new Sensor("Temperature", temperatureSensorReader);
		temperatureSensor.start();	// Start the sensor thread

		SensorReader speedSensorReader = new SensorReader();
		Sensor speedSensor = new Sensor("Speed", speedSensorReader);
		speedSensor.start();	// Start the sensor thread

		float temperatureSum = 0, temperatureAverage, temperatureMax = Float.MIN_VALUE, temperatureMin = Float.MAX_VALUE;
		float speedSum = 0, speedAverage, speedMax = Float.MIN_VALUE, speedMin = Float.MAX_VALUE;
		float temperatureCount = 0, speedCount = 0;
		while (true) {
			float temperatureValue = temperatureSensorReader.getValue();
			temperatureSum += temperatureValue;
			temperatureCount++;
			temperatureAverage = temperatureSum / temperatureCount;
			if (temperatureMin > temperatureValue) {temperatureMin = temperatureValue;}
			if (temperatureMax < temperatureValue) {temperatureMax = temperatureValue;}
			System.out.println(temperatureSensor.getSensorName() + " sensor value = " + temperatureValue + ", average value = " + temperatureAverage + " min = " + temperatureMin + " max = " + temperatureMax);

			try {Thread.sleep(1000);} catch(Exception ex) {}	// One second between sensor readings

			float speedValue = speedSensorReader.getValue();
			speedSum += speedValue;
			speedCount++;
			speedAverage = speedSum / speedCount;
			if (speedMin > speedValue) {speedMin = speedValue;}
			if (speedMax < speedValue) {speedMax = speedValue;}
			System.out.println(speedSensor.getSensorName() + " sensor value = " + speedValue + ", average value = " + speedAverage + " min = " + speedMin + " max = " + speedMax);
		}
	}
}
