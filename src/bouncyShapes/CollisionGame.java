package bouncyShapes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import java.awt.Color;
public class CollisionGame {

    /**
     * @param args the command line arguments
	 * This displays a window with a bunch of bouncing balls
     */
    
    public static void main(String[] args) throws InterruptedException {
       JFrame f = new JFrame("Collision Game");
	   int windowWidth  = 700;
	   int windowHeight = 500;
	   int numBalls     = 10;
	   int tickDur      = 20;
       
       
       f.setSize(windowWidth,windowHeight);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
       EnviornmentManager env = new EnviornmentManager(numBalls,windowWidth-40,windowHeight-80);
       f.add(env);
       BouncyShape[] ball = new BouncyShape[numBalls];
        Color[] colorArry = {   Color.red,Color.orange,Color.yellow,
                                Color.green,Color.blue,Color.black};
        for (int i = 0; i < numBalls/2; i++) {
            int newSpeed = i+100;
            ball[i] = new BouncyShape(30+i*30,40,newSpeed,Color.blue);
            env.addShape(ball[i]);
        }
        for (int i = numBalls/2; i < numBalls; i++) {
            int newSpeed = i+200;
            ball[i] = new BouncyShape(30+i*30,150,newSpeed,Color.red);
            env.addShape(ball[i]);
        }
       
       PhysicsManager phy = new PhysicsManager(env);
       while(true){
           phy.resolveShapeCollision(ball);
           for (int i = 0; i < ball.length; i++) {
               phy.resolveWallCollision(ball[i]);
               ball[i].moveShape();
               
           }
           
           env.repaint();
           Thread.sleep(tickDur);
       }
    }
   
    
}
