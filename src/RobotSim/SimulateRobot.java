package RobotSim;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import java.awt.Color;
public class SimulateRobot {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
       JFrame f = new JFrame("Collision Game");
       int windowWidth  = 800;
       int windowHeight = 500;
       int tickDur      = 20;
       f.setSize(windowWidth,windowHeight);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
       EnviornmentManager env 	= new EnviornmentManager(windowWidth-40,windowHeight-80);
       Robot robot 				= new Robot(100,100,5,Color.red);
       env.addRobot(robot);

       f.add(env);
       
       
       //PhysicsManager phy = new PhysicsManager(env);
       while(true){
         //  phy.resolveShapeCollision(ball);
           
           env.repaint();
           //bot.repaint();
           Thread.sleep(tickDur);
       }
    }
   
    
}
