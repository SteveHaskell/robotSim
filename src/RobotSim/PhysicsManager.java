package RobotSim;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author steve_000
 */
public class PhysicsManager {

    private int upperYBoundary;
    private int lowerYBoundary;
    private int leftXBoundary;
    private int rightXBoundary;
    public PhysicsManager(EnviornmentManager env){
        upperYBoundary = 0+env.lineWidth;
        lowerYBoundary = env.boxHeight-env.lineWidth;
        leftXBoundary  = 0+env.lineWidth;
        rightXBoundary = env.boxWidth-env.lineWidth;
    }
    public void resolveWallCollision(RobotSim shape){
        boolean changeYDir = (shape.yLoc>=lowerYBoundary-shape.height)||(shape.yLoc<=upperYBoundary);
        boolean changeXDir = (shape.xLoc>=rightXBoundary-shape.width) ||(shape.xLoc<=leftXBoundary);
        if(changeXDir) shape.xDir = -1*shape.xDir;
        if(changeYDir) shape.yDir = -1*shape.yDir;
    }
    public void resolveShapeCollision(RobotSim[] s){
        boolean changeXDir = false;
        boolean changeYDir = false;
        for (int i = 0; i < s.length; i++) {
            int left1   = s[i].xLoc;
            int right1  = s[i].xLoc+s[i].width;
            int upper1  = s[i].yLoc;
            int lower1  = s[i].yLoc+s[i].height;
            for (int j = 0; j < s.length; j++) {
                if(j!=i){
                    int left2   = s[j].xLoc;
                    int right2  = s[j].xLoc+s[i].width;
                    int upper2  = s[j].yLoc;
                    int lower2  = s[j].yLoc+s[i].height;
                    boolean xCollision1 = ((left2<=right1)&&(left2>=left1));//second box hitting first box from the right
                    boolean xCollision2 = ((right2<=right1)&&(right2>=left1));//second box hitting first box from the left
                    boolean xCollision = xCollision1 || xCollision2;
                    if(xCollision){
                        boolean yCollision1 = (upper2>=upper1)&&(upper2<=lower1);//second box hitting first from bottom
                        boolean yCOllision2 = (lower2>=upper1)&&(lower2<=lower1); // second box hitting first from top
                        boolean yCollision = yCollision1||yCOllision2;
                        if(yCollision){
                            int avgSpeed = (s[i].speed+s[j].speed)/2;
                            s[i].speed = avgSpeed-1;
                            s[j].speed = avgSpeed-1;
                            if(xCollision1){//second box hitting first box from the right
                                s[i].setXDir(-1);
                                s[j].setXDir(1);
                            }
                            else if(xCollision2){//second box hitting first box from the left
                                s[i].setXDir(1);
                                s[j].setXDir(-1);
                            }
                            if(yCollision1){//second box hitting first from bottom
                                s[i].setYDir(-1);
                                s[j].setYDir(1);
                            }
                            else if(yCOllision2){//second box hitting first from top
                                s[i].setYDir(1);
                                s[j].setYDir(-1);
                            }
                        }
                    }
                }
            }
        }
        
        
    }
}
