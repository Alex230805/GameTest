package classes.entity.player;

import classes.entity.entity;
import classes.entityGroup.entityGroupInterface;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;


import Window.input.inputBufferInterface;

public class player extends entity implements inputBufferInterface,MouseListener,entityGroupInterface{
    private int width;
    private int height;
    private int space_width;
    private int space_height;
    private boolean focused = false;

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
        graph.setColor(Color.RED);
        graph.fillRect((super.x*speedFactor)+space_width, (super.y*speedFactor)+space_height, width, height);
    }

    public void mouseExited(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    public void mouseEntered(MouseEvent m){}
    
    public void mousePressed(MouseEvent m){

    }
    
    public void mouseClicked(MouseEvent m){
        
    }

    public String getEntityName(){
        return super.getEntityName();
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
