/*
Team 1 
Name      Student Number 
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

import lejos.nxt.*;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main{
    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
    Movement m = new Movement();
    
    float distX = 0f, distY = 0f;

    public static void main(String [] args) {
      

      Button.ESCAPE.addButtonListener(new ButtonListener() {
      public void buttonPressed(Button b) {
         System.exit(0);
       }

      public void buttonReleased(Button b) {
         LCD.clear();
      }
    });

    Movement a = new Movement();
    float startDist = m.getDistanceTraveled();
    while(sonic.getDistance() > 25){
      sonic.ping();
      m.forward(10);
    }
    distX = m.getDistanceTraveled() - startDist;
    m.turnLeft(90);

    startDist = m.getDistanceTraveled();
    while(sonic.getDistance() > 25){
      sonic.ping();
      m.forward(10);
    }
    distY = m.getDistanceTraveled() - startDist;
    m.turnLeft(90);

    ////Return To start
    m.forward(distX);
    m.turnLeft(90);
    m.forward(distY);
    m.turnLeft(90);
    ////


    Behavior carpet = new CarpetSensor();
    Behavior b2 = new Touch();

    Behavior [] bArray = {carpet, b2};
    Arbitrator arby = new Arbitrator(bArray);
    arby.start();

    }

}

