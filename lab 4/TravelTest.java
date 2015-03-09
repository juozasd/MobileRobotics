import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import java.io.*;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class TravelTest {

  public static DifferentialPilot pilot;
  public static TouchSensor bump = new TouchSensor(SensorPort.S1);

  public static void main(String[] args) throws InterruptedException {
       TravelTest traveler = new TravelTest();

	   Button.ESCAPE.addButtonListener(new ButtonListener() {
		public void buttonPressed(Button b) {
		pilot.stop();
		}

		public void buttonReleased(Button b) {
		LCD.clear();
		pilot.stop();
		}
		});	   
	   
		//Draw Travel Tests
		LCD.drawString("Travel Tests",0,0); //1
		//Wait for a button to be pressed and then clear it
		Button.waitForAnyPress();//2
		LCD.clear();//3

        //Create new pilot and set it going
		traveler.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);//4
		pilot.setTravelSpeed(4);//5
		pilot.setRotateSpeed(30);

		LCD.drawString("Moving",0,0);
		pilot.travel(20, true);//6
		while(pilot.isMoving()){}
		pilot.travel(-10, true);//7
		while(pilot.isMoving()){}
		Button.waitForAnyPress();
		LCD.clear();

		//travelling in a rectangle //8
		LCD.drawString("Rectangle",0,0);
		pilot.travel(10, true);
		while(pilot.isMoving()){}
		pilot.rotate(90);
		pilot.travel(5, true);
		while(pilot.isMoving()){}
		pilot.rotate(90);
		pilot.travel(10, true);
		while(pilot.isMoving()){}
		pilot.rotate(90);
		pilot.travel(5, true);
		while(pilot.isMoving()){}
		Button.waitForAnyPress();
		LCD.clear();

		//travelling in a circle
		//clockwise
		LCD.drawString("Circle",0,0);
		pilot.arc(5,360 );//9
		while(pilot.isMoving()){}
		//counter clockwise
		pilot.arc(5, -360);//10
		while(pilot.isMoving()){}
		Button.waitForAnyPress();
		LCD.clear(); 
       
   }
}
