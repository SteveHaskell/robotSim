package bouncyShapes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
/**
 *
 * @author steve_000
 */
public class EnviornmentManager extends JPanel{
    
    
    
    public BouncyShape[] shape;
    private int curShape;
    public int boxWidth;
    public int boxHeight;
    public int lineWidth;
    public EnviornmentManager(int numShapes,int width,int height){
   
        shape       = new BouncyShape[numShapes];
        curShape    = 0;
        boxWidth    = width;
        boxHeight   = height;
        lineWidth   = 10;
    }
    public void addShape(BouncyShape newShape){
        if(curShape< shape.length){
            shape[curShape] = newShape;
            curShape++;
        }
    }
    private void drawBall(Graphics2D g2d){
        for (int i = 0; i < shape.length; i++) {
          g2d.setColor(shape[i].color);
          g2d.fillOval(shape[i].xLoc,shape[i].yLoc,shape[i].width,shape[i].height);  
        }
        
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
       
        drawBall(g2d);
        makeBox(g2d);
    }
}
    

