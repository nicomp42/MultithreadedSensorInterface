/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import sensor.SensorInterface;

public class SensorReader implements SensorInterface {
	private float value;
	@Override
	public synchronized void update(float value) {
		this.value = value;
	}
	public synchronized float getValue() {return value;}
}
