package classes.entity.npc;

import classes.entity.entity;
import java.awt.*;

import Window.input.inputBufferInterface;


public class npc extends entity implements inputBufferInterface{
    private Color c;
    private int width;
    private int height;
    private int space_width;
    private int space_height;

    private int direction_x;
    private int direction_y;
    private boolean playerFocus;
    private boolean passive;
    private boolean regeneratedDirectionFlag = false;

    private int hit_box_size = 10;

    public npc(int x, int y, int id_entity, String entity_name,int width,int height, Color c, int space_width,int space_height){
        super(x,y,id_entity,entity_name);
        this.c = c;
        this.width = width;
        this.height = height;
        this.space_width = space_width;
        this.space_height = space_height;
        this.direction_x = super.x;
        this.direction_y = super.y;
        playerFocus = false;
        passive = false;
        setBounds(x, y, width+hit_box_size, height+hit_box_size);
        setVisible(true);
    }

    public void drawEntity(Graphics graph){
        Color cache = graph.getColor();
        graph.setColor(c);

        graph.fillRect(super.x*GenericNPCspeedFactor, super.y*GenericNPCspeedFactor, width, height);

        graph.drawString(super.getEntityName(), super.x*GenericNPCspeedFactor, (super.y*GenericNPCspeedFactor)-(height/2));
        graph.setColor(cache);

    }

    public void updateNpcStatus(){
        int pos[] = {super.x,super.y};
        if(super.x == direction_x && super.y == direction_y){
            pos = generatePos();
            direction_x = pos[0];
            direction_y = pos[1];
            regeneratedDirectionFlag = false;
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

        int x = (int)Math.floor(Math.random() * space_width/GenericNPCspeedFactor+1);
        int y = (int)Math.floor(Math.random() * space_height/GenericNPCspeedFactor+1);
        
        pos[0] = x;
        pos[1] = y;
        return pos;
    }

    public void forceDirectionChanging(){
        int pos[] = {super.x,super.y};
        pos = generatePos();
        direction_x = pos[0];
        direction_y = pos[1];
        regeneratedDirectionFlag = true;
    }

    public boolean getRegeneratedDirection(){
        return regeneratedDirectionFlag;
    }
    public void setRegeneratedDirection(boolean b){
        this.regeneratedDirectionFlag = b;
    }

    public int getDirectionX(){
        return direction_x;
    }
    public int getDirectionY(){
        return direction_y;
    }


    public void setPlayerFocus(boolean b){
        this.playerFocus = b;
    }

    public  boolean getPlayerFocus(){
        return playerFocus;
    }


    public void setPassive(boolean b){
        this.passive = b;
    }
    public boolean getPassive(){
        return passive;
    }

    @Override

    public int getX(){
        return super.x*GenericNPCspeedFactor-space_width/2;
    }

    public int getY(){
        return super.y*GenericNPCspeedFactor-space_height/2;
    }
}


