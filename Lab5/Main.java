import lejos.nxt.*;
import java.io.*;
//import Sound.java;
//import Sonar.java;
//import Light.java;

 // clap is about 45 - 50 range

public class Main{


	public static void main(String[] args) throws Exception {
		TouchSensor touch = new TouchSensor(SensorPort.S2);
		Sonar sonar = new Sonar();
		Sound sound = new Sound();
		Light light = new Light();
		Movement movement = new Movement();
		boolean controlled;

		LCD.drawString("Assigment1", 0,0);
		Button.waitForAnyPress();
		LCD.clear();

		LCD.drawString("Sonar Running", 0,0);
		sonar.run();// runs till it a hard surface is detected under 25 cm

		LCD.clear();
		LCD.drawString("Movement Running", 0,0);
		movement.turn180();
		movement.forward(20);
		movement.turnLeft90();

		LCD.clear();
		LCD.drawString("Light is Running", 0,0);
		light.run();

		// Robot waits for two seconds 
		Thread.sleep(2000);

		LCD.clear();
		LCD.drawString("Touch is Running", 0,0);
	   while(touch.isPressed() == false){
	      movement.backward(2);
	   }

		LCD.clear();
		LCD.drawString("Sound is Running", 0,0);
	   sound.run();

		LCD.drawString("Finished", 0,0);
		Button.waitForAnyPress();
		LCD.clear();











	}
}
