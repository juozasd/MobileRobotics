import lejos.nxt.LCD;
import java.io.*;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.*;


// Author James Byrne
// This class serves to create another layer of abstraction over the pilot class
// in order to simplify the code being written
// The idea is to save the user time setting up the movement of the pilot
public class Movement {

   // The pilot is initialised by the class
   double  speed = 4;
   double  turnSpeed = 30;
   private double wheelDiameter = 2.25f;
   private double trackWidth = 5.5f;
   public  DifferentialPilot pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);
   

   public Movement(){
	    pilot.setTravelSpeed(speed);
		pilot.setRotateSpeed(turnSpeed);
		
   }
   
   public void setWheelDiameter(double wd){
      wheelDiameter = wd;
	  pilot =
      new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);
   }
   public void setTrackWidth(double tw){
      trackWidth = tw;
      pilot =
      new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);
   }
   public void setTravelSpeed(float ts){
      pilot.setTravelSpeed(ts);
   }
   public void setRotateSpeed(float rs){
      pilot.setRotateSpeed(rs);
   }

   //Movement options
   public void forward(float dist) {
      pilot.travel(dist, true);
      while(pilot.isMoving()){}
   }
   public void backward(float dist) {
      dist = dist * -1;
      pilot.travel(dist, true);
      while(pilot.isMoving()){}
   }
   public void turnLeft(float dist){
      pilot.rotate(dist);
   }
   public void turnRight(float dist){
      dist = dist * -1;
      pilot.rotate(dist);
   }
   public void arcLeft(float size, float deg){
      pilot.arc(size,deg);
      while(pilot.isMoving()){}
   }
   public void arcRight(float size, float deg){
      deg = deg * -1;
      pilot.arc(size,deg);
      while(pilot.isMoving()){}
   }
   public void stop(){
      pilot.stop();
   }

}
