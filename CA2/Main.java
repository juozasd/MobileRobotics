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
    m.forward(1);
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

    while(sonic.getDistance() > 25){
      sonic.ping();
      m.forward(10);
      distX += 6;
    }
    m.turnLeft(90);

    while(sonic.getDistance() > 25){
      sonic.ping();
      m.forward(10);
      distY += 6;
    }
    m.turnLeft(90);

    ////Return To start
    m.forward(distX);
    m.turnLeft(90);
    m.forward(distY);
    m.turnLeft(90);
    ////




    Behavior b1 = new CarpetSensor();
    Behavior b2 = new Touch();
    Behavior wallDetection = new Sonar();
    Behavior [] bArray = {b1, b2};
    Arbitrator arby = new Arbitrator(bArray);
    arby.start();

    }

}

