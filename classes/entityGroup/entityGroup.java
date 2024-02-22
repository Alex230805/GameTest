package classes.entityGroup;

import java.util.*;


import Window.input.input;
import Window.input.inputBufferInterface;
import classes.entity.entity;
import classes.entity.entityIdInterface;

import classes.entity.npc.npc;
import classes.entity.player.*;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.geom.*;

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
        new Thread(new Runnable(){
            @Override
            
            public void run(){
                player p = getPlayer();
                p.setX(x);
            }
        }).start();
    }

    public void updatePlayerDataY(int y){
        new Thread(new Runnable(){
            public void run(){
                player p = getPlayer();
                p.setY(y);
            }
        }).start();
    }

    public void loadInfo(input inputLayer){
        new Thread(new Runnable(){
            @Override

            public void run(){
                player p = getPlayer();
                inputLayer.setX(p.getX());
                inputLayer.setX(p.getY());
            }
        }).start();
    }

    public void updateNpcAi(){
        new Thread(new Runnable(){
            @Override

            public void run(){
                for(int i=0;i<entityContainer.size();i++){
                    if(entityContainer.get(i).getId_entity() == generic_npc){
                        npc e = (npc)entityContainer.get(i);
                        if(!e.getPassive()){
                            e.updateNpcStatus();
                        }
                    }
                }   
            }
        }).start();
    }

    public void castPlayerAction(){
        return;
    }

    public void castplayerCollisionWithEntity(){
        new Thread(new Runnable(){
            @Override

            public void run(){
                player p = getPlayer();
                Rectangle player_area = p.getBounds();
                int pos = entityContainer.indexOf(p);
        
                for(int i=0;i<entityContainer.size();i++){
                    if(i!=pos){
                        Rectangle ea = entityContainer.get(i).getBounds();

                        if(ea.intersects(player_area) || player_area.intersects(ea)){
                            System.out.println("Collision detect");
                            p.setEntityCollision(true);
                        }
                    }
                }
            }
        }).start();
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
