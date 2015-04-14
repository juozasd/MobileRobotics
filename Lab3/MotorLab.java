import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorLab{
	
	public static void main(String[] args)
	{	
		int motA, motB;
	
		LCD.drawString("Motor Test",0,0); //1 
			Button.waitForAnyPress(); //2
			LCD.clear();
			Motor.A.setSpeed(720);//3
			Motor.B.setSpeed(720);

			
		do{
			LCD.clear();
			Motor.A.rotate(720,true);
			Motor.B.rotate(720,true);
			Delay.msDelay(1000);
			LCD.drawInt(Motor.A.getTachoCount(),0,0);
			LCD.drawInt(Motor.B.getTachoCount(),0,1);
			motA = Motor.A.getTachoCount();
			motB = Motor.B.getTachoCount();
			LCD.drawInt((motA - motB),0,2);
			//Motor.B.stop();
			//Motor.A.stop();
			Delay.msDelay(500);
		}while(Button.ESCAPE.isPressed() == false);
		
	
	}
	
}