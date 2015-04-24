/*
Team 1
Name      Student Number
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

import lejos.nxt.*;
import Movement;

public class MyMap extends Thread {

    private int myX;
    private int myY;
    private int END_MAP=4;
    static int[] matrice;
    public static Movement m;

    public static int sonar=0;

    // Moving within the  map
    public void MyMap() {

    }

    // Called when the sonar interrupts the class
    public void interSonar(){
        sonar += 1;
    }

    // Gets the initial outline of the map
    public void getOutline() {
        // While 4 turns have not been made
        while(sonar!=END_MAP){
            // Check if behavious was interuptted
            if(check < sonar){
                // if yes then add the distance traveled to
                // determine the size of the square
                matrice[check] = m.getDistanceTraveled();
                m.turnRight(90);
            }
            // Until 4 90 deg turns have been made keep going forward
            else if(sonar<=END_MAP) {
                m.forward(1000);
            }
        }
    }

    // Moves around the inside of the map 'Filling it in'
    public void fillIn() {
        // Get the width and lenght of the area to be filled in
        float X_LIMIT = matrice[0];
        float Y_LIMIT = matrice[1];
        float curr_Y = 0;

        while(curr_Y < Y_LIMIT){
            m.forward(X_LIMIT-7);
            m.arcRight(3.5, 180)
            curr_Y += 3.5;
        }
    }


}
