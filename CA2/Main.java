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

  UltrasonicSensor eyes = new UltrasonicSensor(SensorPort.S1);


 public static void main(String [] args) {
    //(new CarpetSensor()).start();
    Button.ESCAPE.addButtonListener(new ButtonListener() {
    public void buttonPressed(Button b) {
       System.exit(0);
     }

    public void buttonReleased(Button b) {
       LCD.clear();
    }
  });

    Movement a = new Movement();

    while()


    Behavior b1 = new CarpetSensor();
    Behavior b2 = new Touch();
    Behavior wallDetection = new Sonar();
    Behavior [] bArray = {wallDetection, b2,b1};
    Arbitrator arby = new Arbitrator(bArray);
    arby.start();

 }
 
}

