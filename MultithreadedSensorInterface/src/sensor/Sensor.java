/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package sensor;

import java.util.Random;
/**
 * Simulating an analog sensor that runs in its' own thread
 * @author nicomp
 *
 */
public class Sensor extends Thread {
	private SensorInterface sensorInterface;
	public Sensor(SensorInterface sensorInterface) {
		this.sensorInterface = sensorInterface;
	}
	public void run() {
		Random random;
		random = new Random();
		while (true) {
			try { Thread.sleep(500);} catch(Exception ex) {}	// Analog sensors are slow so this is just a real-world pause to wait for settling.
			// Here we would read the actual sensor but since we don't have one we will make up a random value
			sensorInterface.update(random.nextFloat() * 100);
		}
	}
}
