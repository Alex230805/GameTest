package classes.entity;

import java.awt.*;

public class entity extends Component implements entityIdInterface{
    public int x;
    public int y;
    private int id_entity;
    private String entity_name;
    private int positionGroup = 0;
    
    public entity(int x,int y, int id_entity, String entity_name){
        this.x = x;
        this.y = y;
        this.id_entity = id_entity;
        this.entity_name = new String(entity_name.toString());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId_entity() {
        return id_entity;
    }

    public String getEntityName() {
        return entity_name;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setPositionGroup(int pos){
        positionGroup = pos;
    }

    public int getPositionGroup(){
        return positionGroup;
    }

    @Override
    public String toString() {
        return "entity [x=" + x + ", y=" + y + ", id_entity=" + id_entity + ", entity_name=" + entity_name + "]";
    }


    public boolean isFocused(){
        return false;
    }
    public void setFocus(boolean b){
    }
}
