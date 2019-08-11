/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package sensor;

/**
 * Read from the sensor. 
 * The Sensor object knows about the SensorInterface. The callback method that the Sensor object uses is in here.
 * @author nicomp
 *
 */
public class SensorReader implements SensorInterface {
	private float value;	// In your app you will read this to get the most recent value from the sensor.
	@Override
	public synchronized void update(float value) {
		this.value = value;
	}
	public synchronized float getValue() {return value;}
}
