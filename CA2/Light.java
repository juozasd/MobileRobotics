import lejos.nxt.*;
import java.io.*;
import lejos.robotics.subsumption.*;


public class CarpetSensor extends Thread implements Behavior{

	LightSensor light;
	boolean state = true;

	public CarpetSensor(){
		light = new LightSensor(SensorPort.S3);
	}


	public void run() {
		while (state) {
			state = takeControl();
		}
	}

	public void action() {
		LCD.drawString("Carpet", 0, 0);
	}

	public void suppress(){
		LCD.drawString("Vacuming", 0, 0);
	}

	public boolean takeControl(){
		while(light.readValue() > 35){
			action();
		}
		return false;
	}
}
