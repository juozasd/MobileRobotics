/*
Team 1
Name      Student Number
- James Byrne   C11393906
- Juozas Dapkunas   C12432832
*/

import lejos.nxt.*;

public class MyMap extends Thread {


    private int END_MAP=4;
    static int[] matrice;
    public static Movement m;
    // Used to count the number of times sonar interrupts
    public static int sonar=0;

    // Default Constructor
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
        //Measure the current Y value and create a switch for the
        // robots turn logic
        float curr_Y = 0;
        int i = 0;
        // While the robot has not traveled n units in the Y plane
        // continue to move in the X plane until a limit is reached
        // then arc to move in the direction of positive y
        while(curr_Y < Y_LIMIT){
            // Move to near the edge
            m.forward(X_LIMIT-7);
            // If the last turn was a left turn then turn right
            if (i == 0){
                m.arcRight(3.5f, 180);
            }
            // If the last turn was a right turn then turn left
            else {
                i = 0;
                m.arcLeft(3.5f, 180);
            }
            // Update the Y value 
            curr_Y += 3.5;
        }
    }


}
