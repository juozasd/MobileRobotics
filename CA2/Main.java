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
    
    public static void main(String [] args) {
      
      Button.ESCAPE.addButtonListener(new ButtonListener() {
      public void buttonPressed(Button b) {
         System.exit(0);
       }

      public void buttonReleased(Button b) {
         LCD.clear();
      }
    });


    Behavior carpet = new CarpetSensor();
    Behavior collision = new Touch();
    Behavior vacuum = new Sonar();
    Behavior [] bArray = {collision, carpet, vacuum};
    Arbitrator arby = new Arbitrator(bArray);
    arby.start();

    }

}

