package RobotSim;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.lang.Math;


/**
 *
 * Robot Objects know their size, color, speed and position, heading, everything basically
 */

public class Robot {
	

    public double xLoc;
    public double yLoc;
    public double theta;		//angle axle makes with x-axis
    public double heading;  	//angle perpendicular to axis, radians
    public double length;		//of the axle connecting the two wheels of the robot
    public Color  color;
    
    
    private double vl; //pixels per tick
    private double vr; //pixels per tick
    
    public Robot(){
    	
    	xLoc		= 0.0;
    	yLoc 		= -25.0;
        vl   		= 0.0;
        vr			= 0.0;
        length   	= 50.0;
        theta 		= 0.0;
        heading 	= theta+Math.PI/2;
        color		= Color.blue;
        
    }
    public double getLVelocity(){
    	return vl;
    }
    public double getRVelocity(){
    	return vr;
    }
    public void setLVelocity(double newV){
    	vl = newV;
    }
    public void setRVelocity(double newV){
    	vr = newV;
    }
    //robot movement based on vr and vl
    public void moveRobot(double t){
    	//based on physics described here:
    	//https://chess.eecs.berkeley.edu/eecs149/documentation/differentialDrive.pdf
    	double omega		= (vr-vl)/length;
    	double R			= length/2*(vl+vr)/(vr-vl);
    	double cosTheta 	= Math.cos(theta);
    	double sinTheta		= Math.sin(theta);
    	double cosDelta		= Math.cos(omega*t);
    	double sinDelta		= Math.sin(omega*t);
    	double ICCx       	= xLoc - R*sinTheta;
    	double ICCy 		= yLoc + R*cosTheta;
    	
    	
    	if(vr==vl){
    		double v = vr;
    		xLoc = xLoc + v*t*cosTheta;
    		yLoc = yLoc + v*t*sinTheta;
    	}
    	else{
    	xLoc = (xLoc-ICCx)*cosDelta-(yLoc-ICCy)*sinDelta+ICCx;
    	yLoc = (xLoc-ICCx)*sinDelta+(yLoc-ICCy)*cosDelta+ICCy;
    	}
    	//prevent heading overflow
    	theta 	= theta + omega*t;
    	
    	if(theta>2*Math.PI){
    		theta = theta-(2*Math.PI);
    	}
    	heading = theta + Math.PI/2;			
    	
    }
   
    
    
}
