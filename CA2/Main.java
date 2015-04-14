//////main Arbritrator
import CarpetSensor.java;
import Vacuum.java;
import Sonar.java;
import Movement.java;

import lejos.*;



public class Main{

   public static void main(String [] args) {
      (new CarpetSensor()).start();
      Movement a = new Movement();
      a.arcRight(40,45);
      a.forward(20);
      a.turnLeft(90);
      
   }

	Button.ESCAPE.addButtonListener(new ButtonListener() {
	   public void buttonPressed(Button b) {
	    	System.exit(0);
	    }});


	public Main(){	}
}

