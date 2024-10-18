/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballpractice;

import java.util.Scanner;

/**
 *
 * @author Steven Turner
 */
public class BaseballPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pitcher randy = new Pitcher();
        Batter billiam = new Batter();
        int attempts = -1;
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many throws would you like to simulate?");
        while(attempts < 0) {
            System.out.println("Please enter a positive integer");
            try{
                attempts = Integer.parseInt(input.nextLine());
            } catch(Exception e){
                System.out.println("There was something wrong with your input");
            }
        }
        
        for(int i = 0; i < attempts; i++){
            Ball ballThrow = billiam.bat(randy.pitch());
            if(ballThrow.getPosition() == Position.HIT){
                System.out.println("Billiam hit the ball at " + ballThrow.getSpeed() + " mph");
            } else {
                System.out.println("Strike, ball going " + ballThrow.getSpeed() + " mph");
            }
        }
    }
    
}
