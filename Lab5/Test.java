import lejos.nxt.*;
import java.io.*;
import lejos.robotics.navigation.DifferentialPilot;

public class Test{
	

public static void main(String[] args) throws Exception {

   SoundSensor sound = new SoundSensor(SensorPort.S4);
   TouchSensor touch = new TouchSensor(SensorPort.S2);
   UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
   DifferentialPilot pilot = new DifferentialPilot(2.25f,5.5f, Motor.A, Motor.C);
   int x=90;
   pilot.setTravelSpeed(4);
   pilot.setRotateSpeed(30);

   LCD.drawString("Travel Tests",0,0); //1
   //Wait for a button to be pressed and then clear it
   Button.waitForAnyPress();//2
   LCD.clear();

   do{
      x = sonic.ping();
	  pilot.travel(4, true);//6
	  LCD.drawString("Sonar Bit thing",0,0);
	  LCD.drawInt(sonic.ping(), 2,2 );
	  Thread.sleep(20);
   }while(x > 25);

   pilot.rotate(180);

   pilot.travel(20, true);

   pilot.rotate(-90);

   LCD.drawString("Touch Bit thing",0,0);
   while(touch.isPressed() == false){
      pilot.travel(-2,true);
   }
   
   LCD.drawString("Claps Bit thing",0,0);
   int y=0;
   while(y==0){
      if(sound.readValue() > 70){
         LCD.drawString("Claps",0,0);
		 y=1;
		 Thread.sleep(500);
      }
   }

}
}