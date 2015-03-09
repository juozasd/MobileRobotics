import lejos.nxt.*;
import java.io.*;


public class Light{
  public static void main(String[] args) throws Exception {
    LightSensor light = new LightSensor(SensorPort.S3);

    while (!Button.ESCAPE.isDown()) {
      LCD.drawInt(light.getLightValue(), 4, 0, 0);
      LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
      LCD.drawInt(SensorPort.S3.readRawValue(), 4, 0, 2);
      LCD.drawInt(SensorPort.S3.readValue(), 4, 0, 3);
    }
  }
}