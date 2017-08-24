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
/**
 *
 * @author steve_000
 */
public class EnviornmentManager extends JPanel{
    

	public 	int 	boxWidth;
    public 	int 	boxHeight;
    public 	int 	lineWidth;
    
    public Robot	robot;
  
    
    public EnviornmentManager(int width,int height){
   
     
        boxWidth    = width;
        boxHeight   = height;
        lineWidth   = 10;
    }
    public void addRobot(Robot newRobot){
    	robot = newRobot;
    }
    private void drawRobot(Graphics2D g2d){
  	  
      AffineTransform old = g2d.getTransform();
      g2d.rotate(Math.toRadians(robot.heading),robot.xLoc,robot.yLoc);
      robot.heading ++;
      g2d.setColor(robot.color);
      g2d.fillRect(robot.xLoc,robot.yLoc,robot.width,robot.height); 
      g2d.setTransform(old);
      //things you draw after here will not be rotated
          
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
        drawRobot(g2d);
    }
}
    

