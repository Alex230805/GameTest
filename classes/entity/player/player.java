package classes.entity.player;

import classes.entity.entity;

import java.awt.*;

import Window.input.inputBufferInterface;

public class player extends entity implements inputBufferInterface{
    private int width;
    private int height;
    private int space_width;
    private int space_height;

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
    }

    public void drawEntity(Graphics graph){
        graph.setColor(Color.WHITE);
        graph.drawRect((super.x*speedFactor)+(space_width/2), (super.y*speedFactor)+(space_height/2), width, height);
    }
}
