import lejos.nxt.*;
import java.io.*;
import lejos.robotics.subsumption.*;

//Sensor 1 -- Sonar

// Sonar detects if an object has come within 25cm of the robot
// If it detects an pbject at that range it will take over
// It will then issue commands to make the robot avoid the object
// It is running as a seperate thread to allow for multiple checks
// in quick succession

public class Sonar extends Thread implements Behavior{

	private UltrasonicSensor sonic;

	public Sonar(){
		sonic = new UltrasonicSensor(SensorPort.S1);
	}	
	
	public void run() {
		while (true) {
			takeControl();
		}
	}

	public void action() {
		try{
		Movement m = new Movement();
		m.turnLeft(180);
		Thread.sleep(100);
		}
		catch (InterruptedException e){
			
		}
	}

	public void suppress(){
		try{
		Thread.sleep(2000);
		}
		catch( InterruptedException e){
			
		}
	}

	public boolean takeControl(){
		sonic.ping();
		
		if (sonic.getDistance() > 25){
			action();
		} else {
			suppress();
		}
		return true;
	}
}
