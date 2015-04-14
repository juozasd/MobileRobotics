mport lejos.nxt.*;
import lejos.robotics.subsumption.*;
import Movement;

public class Touch implements Behaviour {

        private TouchSensor touch;
        private boolean suppreseed = false;

        public touch(SensorPort port){
                sonar = new UltrasonicSensor(port);
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
		float arc = (2 * 3.14 * 10);
		// do an arc around the object
		movement.arRight(arc, 180);
        }
~                                                   
