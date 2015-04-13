import lejos.nxt.*;
import java.io.*;
import lejos.nxt.Sound;
import lejos.robotics.subsumption.*;


public class CarpetSensor extends Thread implements Behavior{

	LightSensor light;
	boolean state = true;

	public CarpetSensor(){
		LCD.drawString("Vacuming", 0, 0);
		light = new LightSensor(SensorPort.S3);
	}


	public void run() {
		while (state) {
			LCD.clear();
			state = takeControl();
		}
	}

	public void action() {
		LCD.clear();
		LCD.drawString("Carpet", 0, 0);
		Sound.twoBeeps();
	}

	public void suppress(){
		LCD.clear();
		LCD.drawString("Vacuming", 0, 0);
	}

	public boolean takeControl(){
		while(light.readValue() > 35){
			action();
		}
		return false;
	}
}
