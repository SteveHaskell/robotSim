package RobotSim;
/**
 * main script for simulating the tank drive of the robot
 */
import javax.swing.JFrame;
import java.awt.Color;
public class SimulateRobot {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
       JFrame f = new JFrame("Collision Game");
       int windowWidth  = 1000;
       int windowHeight = 1000;
       int tickDur      = 20;
  
       f.setSize(windowWidth,windowHeight);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
       EnviornmentManager env 	= new EnviornmentManager(windowWidth-40);
       Robot robot 				= new Robot();
       env.addRobot(robot);

       f.add(env);
       
       
       int stateChangeLimit = 100; //number of ticks before switching
       double lWheelVectors[] = {1.0,-1.0,2.0,-2.0,10.0,-10.0};
       int vecIndex   = 0;
       
       while(true){
 
    	   robot.setLVelocity(lWheelVectors[vecIndex]);
    	   for(int i=0;i<stateChangeLimit;i++){
    		   robot.moveRobot(1.0);
    		   env.repaint();
    		   Thread.sleep(tickDur);
    	   }
    	   vecIndex++;
    	   if(vecIndex>=lWheelVectors.length) vecIndex = 0;
    		   
    }
    	   
    	   
    	   
           
           
 
    }
   
    
}
