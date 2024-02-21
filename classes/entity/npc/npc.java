package classes.entity.npc;

import classes.entity.entity;
import java.awt.*;


public class npc extends entity{
    private Color c;
    private int width;
    private int height;
    private int space_width;
    private int space_height;

    private int direction_x;
    private int direction_y;


    public npc(int x, int y, int id_entity, String entity_name,int width,int height, Color c, int space_width,int space_height){
        super(x,y,id_entity,entity_name);
        this.c = c;
        this.width = width;
        this.height = height;
        this.space_width = space_width;
        this.space_height = space_height;
        this.direction_x = super.x;
        this.direction_y = super.y;
    }

    public void drawEntity(Graphics graph){
        Color cache = graph.getColor();
        graph.setColor(c);
        graph.drawRect(super.x, super.y, width, height);
        graph.drawString(super.getEntityName(), super.x, super.y-(height/2));
        graph.setColor(cache);
    }

    public void updateNpcStatus(){
        int pos[] = {super.x,super.y};
        if(super.x == direction_x && super.y == direction_y){
            pos = generatePos();
            direction_x = pos[0];
            direction_y = pos[1];
        }
            if(direction_x > super.x){
                super.x += 1;
            }
            if(direction_x < super.x){
                super.x -= 1;
            }
            if(direction_y > super.y){
                super.y += 1;
            }
            if(direction_y < super.y){
                super.y -= 1;
            }

    }

    public int[] generatePos(){
        int pos[] = {0, 0};

        int x = (int)Math.floor(Math.random() * space_width+1);
        int y = (int)Math.floor(Math.random() * space_height+1);
        
        pos[0] = x;
        pos[1] = y;
        return pos;
    }

    public int getDirectionX(){
        return direction_x;
    }
    public int getDirectionY(){
        return direction_y;
    }
}
