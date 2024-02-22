package classes.entity.player;

import classes.entity.entity;
import classes.entityGroup.entityGroupInterface;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;


import Window.input.inputBufferInterface;

public class player extends entity implements MouseListener,entityGroupInterface, inputBufferInterface{
    private int width;
    private int height;
    private int space_width;
    private int space_height;
    private boolean focused = false;
    private int pov_x;
    private int pov_y;
    private int range = 10;
    public boolean mouseReleasedflag = false;
    private boolean enemyCollisionFlag = false;

    public player(  int x,int y, 
                    int id_entity, 
                    String entity_name,
                    int width,
                    int height,
                    int space_width,
                    int space_height ){
        super(x,y,id_entity,entity_name);
        this.width = width;
        this.height = height;
        this.space_width = space_width;
        this.space_height = space_height;
        setBounds(x, y, width, height);
        setVisible(true);
        super.addMouseListener(this);
    }

    public void drawEntity(Graphics graph){
        Color c = graph.getColor();
        graph.setColor(Color.RED);


        if(enemyCollisionFlag == true){
            graph.drawRect(super.x*speedFactor+space_width/2, super.y*speedFactor+space_height/2, width, height);

        }else{
            graph.fillRect(super.x*speedFactor+space_width/2, super.y*speedFactor+space_height/2, width, height);

        }
        graph.drawString(super.getEntityName(), super.x*speedFactor+space_width/2, super.y*speedFactor+space_height/2);
        graph.setColor(c);

        enemyCollisionFlag = false;
    }


    public void setEntityCollision(boolean b){
        enemyCollisionFlag = b;
    }
    public boolean getEntityCollision(){
        return enemyCollisionFlag;
    }

    public void mouseExited(MouseEvent m){}
    public void mouseReleased(MouseEvent m){
        mouseReleasedflag = true;
    }
    public void mouseEntered(MouseEvent m){}
    
    public void mousePressed(MouseEvent m){
        System.out.println("Attack!!");
    }
    
    public void mouseClicked(MouseEvent m){
        Point p = m.getPoint();

        pov_x = p.x-space_width/2;
        pov_y = p.y-space_height/2; 

        mouseReleasedflag = false;
    }

    public int getPovX(){
        return pov_x;
    }

    public int getPovY(){
        return pov_y;
    }

    @Override

    public int getX(){
        return super.x*speedFactor;
    }
    public int getY(){
        return super.y*speedFactor;
    }



    public void setPovX(int x){
        this.pov_x = x;
    }

    public void setPovY(int y){
        this.pov_y = y;
    }

    public int getRange(){
        return range;
    }

    @Override

    public boolean isFocused(){
        return focused;
    }
    @Override

    public void setFocus(boolean b){
        focused = b;
    }
}
