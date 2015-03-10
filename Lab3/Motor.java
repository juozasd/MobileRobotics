import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorLab{
	
	public static void main(String[] args)
	{	
		LCD.drawString("Motor Test",0,0); //1 
			Button.waitForAnyPress(); //2
			LCD.clear();
			Motor.A.setSpeed(720);//3
			Motor.B.setSpeed(720);
			
		do{
			LCD.clear();
			Motor.A.forward();
			Motor.B.forward();
			Delay.msDelay(1000);
			LCD.drawInt(Motor.A.getTachoCount(),0,0);
			LCD.drawInt(Motor.B.getTachoCount(),1,0);
			Motor.A.stop();
			Motor.B.stop();
			Delay.msDelay(500);
		}while(Button.ESCAPE.isPressed == false);
		
	
	}
	
}