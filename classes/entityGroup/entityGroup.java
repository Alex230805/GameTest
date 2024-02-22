package classes.entityGroup;

import java.util.*;

import Window.input.input;
import Window.input.inputBufferInterface;
import classes.entity.entity;
import classes.entity.entityIdInterface;

import classes.entity.npc.npc;
import classes.entity.player.*;;

public class entityGroup implements entityGroupInterface,entityIdInterface, inputBufferInterface{

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

    public void updatePlayerDataX(int x){
        player p = getPlayer();
        p.setX(x);
    }

    public void updatePlayerDataY(int y){
        player p = getPlayer();
        p.setY(y);
    }

    public void loadInfo(input inputLayer){
        player p = getPlayer();
        inputLayer.setX(p.getX());
        inputLayer.setX(p.getY());
    }

    public void updateNpcAi(){
        for(int i=0;i<entityContainer.size();i++){
            if(entityContainer.get(i).getId_entity() == generic_npc){
                npc e = (npc)entityContainer.get(i);
                if(!e.getPassive()){
                    e.updateNpcStatus();
                }
            }
        }   
    }

    public void castPlayerAction(){
        player p = getPlayer();
        int pov_x = p.getPovX();
        int pov_y = p.getPovY();

        if(pov_x != 0 && pov_y != 0){
            // ray casting code here for casting entity around
        }
    }

    private player getPlayer(){
        int i=0;
        while(entityContainer.get(i).getId_entity() != playerEntityId){
            i++;
        }
        player p = (player)entityContainer.get(i);
        return p;
    }
}
