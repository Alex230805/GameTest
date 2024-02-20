package classes.entityGroup;

import java.util.*;

import Window.input.input;
import classes.entity.entity;;

public class entityGroup implements entityGroupInterface{

    public entity selectedEntity;

    public entityGroup(){
    }

    public void insertEntity(entity e){
        int pointer = entityContainer.size();
        e.setPositionGroup(pointer);
        entityContainer.add(e);
    }
    public void deleteEntity(entity e){
        int pointer = e.getPositionGroup();
        entityContainer.remove(pointer);
    }

    public void updateEntityDataX(int x){
        for(int i=0;i<entityContainer.size();i++){
            if(entityContainer.get(i).isFocused() == true){
                entityContainer.get(i).setX(x);
                selectedEntity = entityContainer.get(i);
            }
        }
        
    }

    public void updateEntityDataY(int y){
        for(int i=0;i<entityContainer.size();i++){
            if(entityContainer.get(i).isFocused() == true){
                entityContainer.get(i).setY(y);
                selectedEntity = entityContainer.get(i);
            }
        }
    }

    public void loadInfo(input inputLayer){
        for(int i=0;i<entityContainer.size();i++){
            if(entityContainer.get(i).isFocused() == true){
                inputLayer.setX(entityContainer.get(i).getX());
                inputLayer.setY(entityContainer.get(i).getY());
            }
        }

    }
}
