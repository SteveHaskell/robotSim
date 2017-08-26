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
    private void drawRobot(Graphics2D g2d){
  	  g2d.translate(boxWidth/2, boxWidth/2);
  	  //draw the wheel axel
  	  g2d.setColor(Color.black);
  	  g2d.drawLine(	(int)robot.lWheelX, 
	  		(int)-robot.lWheelY,
	  		(int)robot.rWheelX, 
	  		(int)-robot.rWheelY);
      AffineTransform old = g2d.getTransform();
      //rotate left wheel around the left wheel center point
      g2d.setColor(robot.color);
      //draw the rectangle for the left wheel
      g2d.rotate(	angleTransform(robot.angle),
		  			(int)robot.lWheelX,
		  			(int)-robot.lWheelY); 
      g2d.fillRect(	(int)robot.lWheelX-wheelFootprintWidth/2,
    		  		(int)-robot.lWheelY-wheelFootprintLength/2,
    		  		wheelFootprintWidth, 
    		  		wheelFootprintLength);
      g2d.setTransform(old);

      //rotate right wheel around right wheel center point
      old = g2d.getTransform();
      g2d.rotate(	angleTransform(robot.angle),
    		  		(int)robot.rWheelX,
    		  		(int)-robot.rWheelY); 
      g2d.setColor(robot.color);
      //draw the rectangle for the left wheel
      g2d.fillRect(	(int)robot.rWheelX-wheelFootprintWidth/2,
    		  		(int)-robot.rWheelY-wheelFootprintLength/2,
    		  		wheelFootprintWidth, 
    		  		wheelFootprintLength);
      g2d.setTransform(old);
      
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
    

