package classes.entityGroup;

import java.util.*;

import Window.gui.start_gui.start_gui;
import Window.input.input;
import Window.input.inputBufferInterface;
import classes.entity.entity;
import classes.entity.entityIdInterface;

import classes.entity.npc.npc;
import classes.entity.player.*;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.geom.*;

public class entityGroup implements entityGroupInterface, entityIdInterface, inputBufferInterface {

    public entity selectedEntity;

    public entityGroup() {
    }

    public void insertEntity(entity e) {
        int pointer = entityContainer.size();
        e.setPositionGroup(pointer);
        entityContainer.add(e);
    }

    public void deleteEntity(entity e) {
        int pointer = e.getPositionGroup();
        entityContainer.remove(pointer);
    }

    public void updatePlayerDataX(int x) {
        player p = getPlayer();
        p.setX(x);
    }

    public void updatePlayerDataY(int y) {
        player p = getPlayer();
        p.setY(y);
    }

    public void loadInfo(input inputLayer) {
        player p = getPlayer();
        inputLayer.setX(p.getX());
        inputLayer.setX(p.getY());
    }

    public void updateNpcAi() {

        for (int i = 0; i < entityContainer.size(); i++) {
            if (entityContainer.get(i).getId_entity() == generic_npc) {
                npc e = (npc) entityContainer.get(i);
                if (!e.getPassive()) {
                    e.updateNpcStatus();
                }
            }
        }
    }

    public void castPlayerAction() {
        return;
    }

    public void castPlayerEntityCollision() {
        player p = getPlayer();
        Area player_area = new Area(p.getBounds());
        int pos = entityContainer.indexOf(p);

        for (int i = 0; i < entityContainer.size(); i++) {
            if (i != pos) {
                Area ea = new Area(entityContainer.get(i).getBounds());
                if (ea.intersects(player_area.getBounds2D()) || player_area.intersects(ea.getBounds2D())) {
                    p.setEntityCollision(true);
                }
            }
        }
    }

    public void castEntityEntityCollision() {

        player p = getPlayer();
        int pos = entityContainer.indexOf(p);

        for (int i = 0; i < entityContainer.size(); i++) {
            if (i != pos) {
                Area a1 = new Area(entityContainer.get(i).getBounds());
                for (int z = 0; z < entityContainer.size(); z++) {
                    if (z != pos) {
                        Area a2 = new Area(entityContainer.get(z).getBounds());
                        npc e = (npc) entityContainer.get(i);
                        npc e2 = (npc) entityContainer.get(z);

                        if ((entityContainer.get(i) != entityContainer.get(z))
                                && (a1.intersects(a2.getBounds2D()) || a2.intersects(a1.getBounds2D()))
                                && ((e.getRegeneratedDirection() == false)
                                        || (e2.getRegeneratedDirection() == false))) {
                            e.forceDirectionChanging();
                            e2.forceDirectionChanging();
                        }
                    }
                }
            }

        }
    }

    private player getPlayer() {
        int i = 0;
        while (entityContainer.get(i).getId_entity() != playerEntityId) {
            i++;
        }
        player p = (player) entityContainer.get(i);
        return p;
    }

    public void parseEntity(JPanel st){
        for(int i=0;i<entityContainer.size();i++){
            st.add(entityContainer.get(i));
        }
    }
}
