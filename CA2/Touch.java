/*
Team 1 
Name      Student Number 
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/
import lejos.nxt.*;
import lejos.robotics.subsumption.*;


public class Touch extends Thread implements Behavior {

        private TouchSensor touch;
        private boolean suppreseed = false;

        public Touch(){
                touch = new TouchSensor(SensorPort.S4);
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
            Movement movement = new Movement();        
		// make room to arc
            movement.backward(10);
		    float arc = (3.14f * 10f);
		// do an arc around the object
		    movement.arcRight(arc, 45);
        }                                            
}