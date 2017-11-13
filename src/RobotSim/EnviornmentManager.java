package RobotSim;
/**
 * This Class handles all the drawing for the robot simulator
 */

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.Color;
import java.lang.Math;
import java.awt.Font;
/**
 *
 * @author steve_000
 */
public class EnviornmentManager extends JPanel{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public 	int 	boxWidth;
    public 	int 	boxHeight;
    public 	int 	lineWidth;
    
    public Robot	robot;
    public int 		wheelFootprintWidth;
    public int 		wheelFootprintLength;
    public int 		axelThickness;
    public int		axelLength;
    
    public EnviornmentManager(int width){
   
     
        boxWidth    			= width;
        boxHeight   			= width;
        lineWidth  	 			= 10;
        wheelFootprintWidth 	= 20;
        wheelFootprintLength 	= 50;
        axelThickness			= 10;
        axelLength 				= 100;// shouldn't be needed
    }
    public void addRobot(Robot newRobot){
    	robot = newRobot;
    }
    
    private double angleTransform(double angle){
    	double newAngle = 2*Math.PI - angle;
    	return newAngle;
    }
    //based on robot x,y location dead center in the axle, each wheel
    // is found along angle theta
    private void drawRobot(Graphics2D g2d){
    	double xLoc 				= robot.xLoc;
    	double yLoc 				= robot.yLoc;
    	int wheelRadius 		= 10;
    	int wheelDiameter 		= wheelRadius*2;
    	int centerRadius		= 10;
    	int centerDiameter		= 2*centerRadius;
    	g2d.translate(boxWidth/2, boxWidth/2);
 
	  	//draw robot center
	  	double rWheelX 	= xLoc-robot.length/2*Math.cos(robot.heading);
	  	double rWheelY 	= yLoc-robot.length/2*Math.sin(robot.heading); 
	  	
	  	
	  	
	  	
	  	double lWheelX 	= xLoc+robot.length/2*Math.cos(robot.heading);
		double lWheelY 	= yLoc+robot.length/2*Math.sin(robot.heading);
		
		//draw the axle
		Color	lWheelColor = Color.red;
		Color   rWheelColor = Color.blue;
		g2d.setColor(Color.black);
		g2d.drawLine(	(int)lWheelX, 
		  				-(int)lWheelY,
		  				(int)rWheelX, 
		  				-(int)rWheelY);
		//draw robot left wheel
		g2d.setColor(lWheelColor);
	  	g2d.fillOval((int)lWheelX-wheelRadius,-(int)lWheelY-wheelRadius, wheelDiameter, wheelDiameter);
	  	
	  	g2d.setColor(rWheelColor);
		//draw robot right wheel
		g2d.fillOval((int)rWheelX-wheelRadius,-(int)rWheelY-wheelRadius, wheelDiameter, wheelDiameter);
		String lVelocity = String.valueOf(robot.getLVelocity());
		String rVelocity = String.valueOf(robot.getRVelocity());
		//display info	
		g2d.setColor(lWheelColor);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g2d.drawString("Vl=: "+lVelocity, -400, -400);
		g2d.setColor(rWheelColor);
		g2d.drawString("Vr=: "+rVelocity, -400, -350);
    }
    private void drawAxis(Graphics2D g2d){
    	g2d.setColor(Color.gray);
    	g2d.fillRect(boxWidth/2, 0, 2, boxHeight);//y axis
    	g2d.fillRect(0, boxHeight/2, boxWidth, 2);//x axis
    
    }
    private void makeBox(Graphics2D g2d){
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, lineWidth, boxHeight); // make left side
        g2d.fillRect(boxWidth,0,lineWidth,boxHeight); // make right side
        g2d.fillRect(0, 0, boxWidth, lineWidth); // make top
        g2d.fillRect(0, boxHeight, boxWidth+lineWidth, lineWidth); // make bottom
    
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        // include all the shapes you want drawn below
        makeBox(g2d);
        drawAxis(g2d);
        drawRobot(g2d);
    }
}
    

