/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package sensor;
/**
 * Implement this interface and you can read from the sensor!
 * @author nicomp
 *
 */
public interface SensorInterface {
	/**
	 * The Sensor object will call this method and provide its' current value. You decide what to do with the value
	 * @param value The current reading from the sensor.
	 */
	public void update(float value);
}
