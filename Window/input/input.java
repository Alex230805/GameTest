package Window.input;

import java.awt.event.KeyEvent;
import java.util.*;



public class input implements inputBufferInterface {
    private int x;
    private int y;

    public input(){
        x = 0;
        y = 0;
    }


    public void moveUp(){
        y-=1;
    }
    public void moveDown(){
        y+=1;
    }
    public void moveLeft(){
        x-=1;
    }
    public void moveRight(){
        x+=1;
    }

    public boolean isPresent(int a){
        if(inputBuffer.contains(a)){
            return true;
        }
        return false;
    }

    public void resetPosition(){
        x=0;
        y=0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;   
    }
}
