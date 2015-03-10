import lejos.nxt.*;
import java.io.*;
import javax.microedition.lcdui.Graphics;

public class lab2 {
public static void main(String[] args) throws Exception {
	LCD.drawString("Free RAM:", 0, 0);
	LCD.drawInt((int) System.getRuntime().freeMemory(), 6,8,9);
	Thread.sleep(2000);

	//part 2
	LCD.clear();
	//part 3
	draw();
		Thread.sleep(2000);
	//part 4
	LCD.clear();
	//part 5
	buttons();
	//part 6
	Button.ENTER.waitForPressAndRelease();
	LCD.drawString("Finished", 3, 4);
	Thread.sleep(2000);
}


public static void draw(){
	Graphics g = new Graphics();
	g.drawLine(5,5,60,60);
	g.drawRect(62, 10, 25, 35);

}

public static void press() throws Exception {

}


	public static void buttons() throws Exception{
		while (true) {

			LCD.clear();

			if(Button.ENTER.isPressed()) {
			LCD.drawString("ENTER", 0, 0);
			press();
			}

			if(Button.ESCAPE.isPressed()) {
			LCD.drawString("ESCAPE", 0, 0);
			LCD.drawString("Escaping", 0, 0);
			break;
			}

			if(Button.LEFT.isPressed()) {
			LCD.drawString("LEFT", 0, 0);
			}

			if(Button.RIGHT.isPressed()) {
			LCD.drawString("RIGHT", 0, 0);
			}

		}
	}
}//end of class