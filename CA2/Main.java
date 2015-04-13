//////main Arbritrator
import CarpetSensor.java;
import Vacuum.java;
import Sonar.java;


import lejos.*;



public class Main{

   public static void main(String [] args) {
      (new CarpetSensor()).start();
      Behavior b1 = new DriveForward();
      Behavior b2 = new HitWall();
      Behavior [] bArray = {b1, b2};
      Arbitrator arby = new Arbitrator(bArray);
      arby.start();
   }

	Button.ESCAPE.addButtonListener(new ButtonListener() {
	   public void buttonPressed(Button b) {
	    	System.exit(0);
	    }});


	public Main(){	}
}

