/*
Team 1 
Name      Student Number 
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

import lejos.nxt.*;
import java.io.*;
import lejos.nxt.Sound;
import lejos.robotics.subsumption.*;


public class CarpetSensor extends Thread implements Behavior{

	LightSensor light;
	boolean state = true;
	Movement m = new Movement();
	int ground = 45;
	public CarpetSensor(){
		LCD.clear();
		LCD.drawString("Vacuuming", 0, 0);
		light = new LightSensor(SensorPort.S3);
		ground = light.readValue();
	}

	public void setGround(int val){
		ground = val;
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
		m.forward(10);
	}

	public void suppress(){
		LCD.clear();
		LCD.drawString("Vacuming", 0, 0);
		m.stop();
	}

	public boolean takeControl(){
		while(light.readValue() > (ground + 3) || light.readValue() < (ground - 3) ){
			action();
		}
		return false;
	}
}
