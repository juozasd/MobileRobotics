import lejos.nxt.*;
import java.io.*;
import lejos.robotics.subsumption.*;
 // clap is about 45 - 50 range

public class Sound extends Thread implements Behavior{
	SoundSensor sound;
	int loudest = 0;
	int test = 0; 

  	public Sound(){
  		sound = new SoundSensor(SensorPort.S4);
  	}

	public void run(){
		while (true) {
			takeControl();
		}
	}

	public void action() {
		try{
			LCD.drawString("Clapping",0,0);
			Thread.sleep(2000);
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
		
		if (sound.readValue() > 65){
			action();
		} else {
			suppress();
		}
		return true;
	}


}
