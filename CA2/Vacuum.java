/*
Team 1 
Name      Student Number 
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

import lejos.nxt.*;
import java.io.*;
import lejos.robotics.subsumption.*;


public class Vacuum extends Thread implements Behavior{

	LightSensor light;
	boolean state = true;
	UltrasonicSensor sonic;
	TouchSensor touch;

	public CarpetSensor(){
		light = new LightSensor(SensorPort.S3);
		sonic = new UltrasonicSensor(SensorPort.S1);
		touch = new TouchSensor(SensorPort.S2);	
	}


	public void run() {
		while (state) {
			state = takeControl();
		}
	}

	public void action() {
		
	}

	public void suppress(){
		LCD.drawString("Vacuming", 0, 0);
	}

	public boolean takeControl(){
		sonic.ping();
		while(sonic.getDistance() > 20 && touch.isPressed()!= true){
			action();
		}
		return false;
	}
}
