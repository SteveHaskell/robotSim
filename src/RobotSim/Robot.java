package RobotSim;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.lang.Math;


/**
 *
 * Robot Objects know their size, color, speed and position, heading, everything basically
 */

public class Robot {
	
	public double lWheelX;
	public double lWheelY;
    public double rWheelX;
    public double rWheelY;
    public double xLoc;
    public double yLoc;
    public double angle; 	//relative to x axis, radians
    public double heading;  // angle + 90, radians
    public double length;	//of the box representing the robot, pixels
    public Color color;
    
    
    private double lVelocity; //pixels per tick
    private double rVelocity; //pixels per tick
    public Robot(){
     
    	/**
    	 *  positions are calculated at the center of each wheel
    	 * 
   		 *   ICC
   		 *      \
   		 *       \
   		 *      LWheel
   		 *         \     
   		 *          \
   		 *           \
   		 *         RWheel
   		 *      
   		 *      
   		 *   
    	 */
    	 
        lVelocity   = 0.0;
        rVelocity   = 0.0;
        length   	= 50.0;
        color		= Color.blue;
        angle 		= 0.0;
        lWheelX 	= 0.0;
        lWheelY 	= 0.0;
        rWheelX 	= lWheelX+length*Math.cos(angle);
        rWheelY 	= lWheelY+length*Math.sin(angle);
        heading 	= 0.0; //relative to x axis in radians;

        
    }
    public void updateLoc(){
    	
    	if(angle>2*Math.PI){
    		angle = angle-(2*Math.PI);
    	}
    	heading 	= angle + Math.PI/2;
    	//rWheelX 	= lWheelX + length*Math.cos(angle);
        //rWheelY 	= lWheelX + length*Math.sin(angle);
    }
    public void setLVelocity(double newV){
    	lVelocity = newV;
    }
    public void setRVelocity(double newV){
    	rVelocity = newV;
    }
    //One tick worth of wheel movement
    public void moveRobot(double t){
        // R = l/2 * (Vl+Vr)/(Vr-Vl) 
    	// angluarVelocity = (Vr-Vl)/l
    	// 
        double changeInAngle = t*(rVelocity-lVelocity)/length;
        angle 	= angle + changeInAngle;
        double R = (length/2)*(lVelocity+rVelocity)/(rVelocity-lVelocity);
        
        
        double ICCx = (R+length/2)*Math.cos(angle);
    	rWheelX = lWheelX+length*Math.cos(angle);
    	rWheelY = lWheelY+length*Math.sin(angle);
    	updateLoc();
    }
   
    
    
}
