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
        super.addMouseListener(this);
    }

    public void drawEntity(Graphics graph){
        Color c = graph.getColor();
        graph.setColor(Color.RED);


        graph.fillRect(super.x*speedFactor+width/2, super.y*speedFactor+height/2, width, height);
        graph.drawString(super.getEntityName(), super.x*speedFactor+width/2, super.y*speedFactor+height/2);
        graph.setColor(c);
    }

    public void mouseExited(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    public void mouseEntered(MouseEvent m){}
    
    public void mousePressed(MouseEvent m){

    }
    
    public void mouseClicked(MouseEvent m){
        System.out.println("Attack!!");  
        Point p = m.getPoint();

        pov_x = p.x;
        pov_y = p.y;      
        
    }

    public int getPovX(){
        return pov_x;
    }

    public int getPovY(){
        return pov_y;
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
