package bouncyShapes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
/**
 *
 * @author steve_000
 */

public class BouncyShape {
    public int xLoc;
    public int yLoc;
    public int xDir;
    public int yDir;
    public int speed;
    public int width;
    public int height;
    public Color color;
    
    public BouncyShape(int x, int y, int startingSpeed, Color newColor){
        xLoc    = x;
        yLoc    = y;
        xDir    = 1;
        yDir    = 1;
        speed   = startingSpeed;
        width   = 30;
        height  = 30;
        color   = newColor;
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
