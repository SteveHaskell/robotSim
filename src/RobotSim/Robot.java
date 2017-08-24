package RobotSim;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
/**
 *
 * Robot Objects know their size, color, speed and position
 */

public class Robot {
    public int xLoc;
    public int yLoc;
    public int xDir;
    public int yDir;
    public int speed;
    public int width;	//of the box representing the robot
    public int height;	//of the box representing the robot
    public Color color;
    public  double	heading;
    //just adding alittle comment to delete later
    public Robot(int x, int y, int startingSpeed, Color newColor){
        xLoc    = x;
        yLoc    = y;
        xDir    = 1;
        yDir    = 1;
        speed   = startingSpeed;
        width   = 30;
        height  = 30;
        color	= newColor;
        heading = 0;
        
    }
    public void setXDir(int newXDir){
        if(newXDir<=0) xDir = -1;
        else xDir = 1;
    }
    public void setYDir(int newYDir){
        if(newYDir<=0) yDir = -1;
        else yDir = 1;
    }
    public void moveShape(){
        for (int i = 0; i < speed/10; i++) {   
            xLoc = xLoc + 1*xDir;
            yLoc = yLoc + 1*yDir;
        }
    }
    
    
}
