/*
Team 1
Name      Student Number
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

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
   private double wheelDiameter = 2.1f;
   private double trackWidth = 4.4f;
   public  DifferentialPilot pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);


   // Creates an instance of movement
   public Movement(){
	  pilot.setTravelSpeed(speed);
	  pilot.setRotateSpeed(turnSpeed)
   }

   public void setWheelDiameter(double wd){
      wheelDiameter = wd;
	  pilot =   new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);
   }
   public void setTrackWidth(double tw){
      trackWidth = tw;
      pilot =
      new DifferentialPilot(wheelDiameter, trackWidth, Motor.A, Motor.C);
   }

   // sets the speed of the Robot using
   // How many units the Robot moves
   // The rotation of the wheels per second
   public void setTravelSpeed(float ts){
      pilot.setTravelSpeed(ts);
   }
   public void setRotateSpeed(float rs){
      pilot.setRotateSpeed(rs);
   }

   public float getDistanceTraveled(){
       float i=0;
       i = pilot.getTravelDistance();
       resetTachoCount();
       return i;
   }

   //Movement options
   // - Forward
   // - Backward
   // - Left
   // - Right
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

   // Makes the Robot Arc in a direction
   public void arcLeft(float radius, float deg){
      pilot.arc(size,deg);
      while(pilot.isMoving()){}
   }
   public void arcRight(float radius, float deg){
      deg = deg * -1;
      pilot.arc(size,deg);
      while(pilot.isMoving()){}
   }

   //Stops the Robot
   public void stop(){
      pilot.stop();
   }

}
