import lejos.nxt.*;
import java.io.*;
import lejos.robotics.subsumption.*;


public class Light extends Thread implements Behavior{

	LightSensor light;

	public Light(){
		light = new LightSensor(SensorPort.S3);
	}


	public void run() {
		while (true) {
			takeControl();
		}
	}

	public void action() {
		
			Movement m = new Movement();
			m.forward(1);
	}

	public void suppress(){
		try{
			Thread.sleep(2000);
		}
		catch( InterruptedException e){
			
		}
	}

	public boolean takeControl(){
		
		if ( light.readValue() > 35){
			action();
		} else {
			suppress();
		}
		return true;
	}
}