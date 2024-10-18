/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballpractice;

import java.util.Random;

/**
 *
 * @author Steven Turner
 */
public class Batter {
    //fields
    Random generator;
    //constructor
    public Batter(){
        generator = new Random();
    }
    //methods
    public Ball bat(Ball baseball){
        if((generator.nextInt(20)+40) > baseball.getSpeed()){
            baseball.setPosition(Position.HIT);
        } else {
            baseball.setPosition(Position.STRIKE);
        }
        return baseball;
    }
}
