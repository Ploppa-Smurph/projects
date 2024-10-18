/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballpractice;

/**
 *
 * @author Steven Turner
 */
public class Ball {
    //fields
    private Position ballPosition;
    private int speed;
    //constructor
    public Ball(){
        ballPosition = Position.HELD;
        speed = 0;
    }
    
    //methods
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public Position getPosition(){
        return ballPosition;
    }
    public void setPosition(Position newPosition){
        this.ballPosition = newPosition;
    }
}

