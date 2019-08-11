package sensor;

import java.util.Random;

public class Sensor extends Thread {
	private SensorInterface sensorInterface;
	Random random;
	public Sensor(SensorInterface sensorInterface) {
		this.sensorInterface = sensorInterface;
		random = new Random();
	}
	public void run() {
		while (true) {
			try { Thread.sleep(500);} catch(Exception ex) {}
			// Here we would read the actual sensor but since we don't have one we will make up a random value
			sensorInterface.update(random.nextFloat() * 100);
		}
	}
}
