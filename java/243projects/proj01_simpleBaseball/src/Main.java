/*
*     Jeff Walley / CTEC 243-901 wk01 proj01_simpleBaseball   *
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many pitches would you like to throw? Please enter a whole number. ");
        Scanner scanner01 = new Scanner(System.in);
        int pitchCount = scanner01.nextInt();

        int pitches = 0;
        for (int i = 0; i< pitchCount; i++) {
            pitches += i;

// create the pitcher object and make it throw 1 time each per pitch
            Pitcher pitcherObj = new Pitcher();
            int pitch = pitcherObj.thrown();

// create the batter object and have it swing at each pitch
            Batter batterObj = new Batter();
            int atBat = batterObj.atBat();

// create the ball object and describe location for each pitch
            Ball ballObj = new Ball();
            ballObj.position();

// create hit object to decide if the batter makes contact with the pitch, or not
            if(pitch == atBat) {
               System.out.println("The ball is Hit! We have a Hit!");
            }
            else {
                System.out.println("That is not hit.");
            }

        }
    }
}
