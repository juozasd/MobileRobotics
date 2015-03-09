import lejos.nxt.*;
import java.io.*;
import Movement.java;
import lejos.robotics.subsumption.*;
 // clap is about 45 - 50 range

public class Sound{
  public static void main(String[] args) throws Exception {
    SoundSensor sound = new SoundSensor(SensorPort.S4);
	int loudest = 0;
	int test = 0;
    while (!Button.ESCAPE.isDown()) {
		LCD.clear();
		test = sound.readValue();
		LCD.drawInt(sound.readValue(),0,0);
		if(test > loudest){
			loudest = test;
		}
		LCD.drawInt(loudest,2,2);
		Thread.sleep(200);
    }
  }
}