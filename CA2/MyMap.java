import lejos.nxt.*;
import Movement;

public class MyMap extends Thread {

    private int myX;
    private int myY;
    private int END_MAP=4;
    int[] matrice;

    public static int sonar=0;

    public void MyMap() {

    }

    public interSonar(){
        sonar += 1;
    }

    public void getOutline() {
        Movement m = new Movement();
        while(1){
            if(check < sonar){
                matrice[check] = m.getDistanceTraveled();

                check = sonar;
            }
            else if(sonar>=END_MAP) {
                m.forward(1000);
            }
        }
    }

    public void fillIn() {

    }
}
