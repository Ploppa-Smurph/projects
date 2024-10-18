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
public class Pitcher {
    //fields
    Random generator;
    //constructor
    public Pitcher(){
        generator = new Random();
    }
    //methods
    public Ball pitch(){
        Ball baseball = new Ball();
        baseball.setSpeed(generator.nextInt(20) + 40);
        baseball.setPosition(Position.THROWN);
        return baseball;
    }
}
