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

		sonar.run();// runs till it a hard surface is detected under 25 cm

		movement.turn180();
		movement.forward(20);
		movement.turnLeft90();

		light.run();

	   while(touch.isPressed() == false){
	      movement.backward(2);
	   }

	   sound.run();
	   








   
   
   
	}
}