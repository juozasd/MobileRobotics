<<<<<<< HEAD
=======
/*
Team 1 
Name      Student Number 
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

>>>>>>> 9b68aab309902266115f4b331c64acc85c4d0de1
import lejos.nxt.*;
import lejos.robotics.subsumption.*;


public class Touch extends Thread implements Behavior {

        private TouchSensor touch;
        private boolean suppreseed = false;

<<<<<<< HEAD
        public touch(SensorPort port){
            sonar = new UltrasonicSensor(port);
=======
        public Touch(){
                touch = new TouchSensor(SensorPort.S4);
>>>>>>> 9b68aab309902266115f4b331c64acc85c4d0de1
        }

        public boolean takeControl() {
            return touch.isPressed();
        }

        public void suppress()
        {
            Motor.A.stop();
            Motor.C.stop();
        }

        public void action()
        {
<<<<<<< HEAD
            Movement movement = new Movement();
	    // make room to arc
            movement.backward(10);
		    float arc = (3.14 * 10);
	    // do an arc around the object
            movement.arRight(arc, 180);
        }
=======
                Movement movement = new Movement();
                
		// make room to arc
                movement.backward(10);
		float arc = (3.14f * 10f);
		// do an arc around the object
		movement.arcRight(arc, 45);
        }                                            
}
>>>>>>> 9b68aab309902266115f4b331c64acc85c4d0de1
