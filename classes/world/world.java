package classes.world;

import classes.entity.player.*;
import classes.entity.entityIdInterface;
import classes.entity.npc.*;

import classes.entityGroup.*;

import java.awt.*;

import Window.input.inputBufferInterface;

public class world implements entityIdInterface,entityGroupInterface, inputBufferInterface{
    private int width;
    private int height;
    private double gravity_factor;

    public player main_player;

    public npc c1;
    public npc c2;
    public npc c3;
    public npc c4;

    public entityGroup entityContainer;

    public world(int width,int height,double gravity_factor){
        this.width = width;
        this.height = height;
        this.gravity_factor = gravity_factor;
        entityContainer = new entityGroup();

        main_player = new player(1, 1, playerEntityId, "Player", 50, 50, width,height);
        
        c1 = new npc((int)Math.floor(Math.random() * width/speedFactor + 1),(int)Math.floor(Math.random() * height/speedFactor + 1), generic_npc, "NPC 2", 60,60, Color.GRAY, width,height);
        c2 = new npc((int)Math.floor(Math.random() * width/speedFactor + 1),(int)Math.floor(Math.random() * height/speedFactor + 1), generic_npc, "NPC 3", 10,10, Color.YELLOW, width,height);
        c3 = new npc((int)Math.floor(Math.random() * width/speedFactor + 1),(int)Math.floor(Math.random() * height/speedFactor + 1), generic_npc, "NPC 4", 20,40, Color.RED, width,height);
        c4 = new npc((int)Math.floor(Math.random() * width/speedFactor + 1),(int)Math.floor(Math.random() * height/speedFactor + 1), generic_npc, "NPC 5", 80,80, Color.CYAN, width,height);

        c1.setPassive(false);
        c2.setPassive(false);
        c3.setPassive(false);
        c4.setPassive(false);

        main_player.setFocus(true);


        entityContainer.insertEntity(main_player);
        entityContainer.insertEntity(c1);
        entityContainer.insertEntity(c2);
        entityContainer.insertEntity(c3);
        entityContainer.insertEntity(c4);
    }

    public void updateWorldTick(){
        entityContainer.updateNpcAi();
        //entityContainer.castPlayerAction();
        entityContainer.castPlayerEntityCollision();
        entityContainer.castEntityEntityCollision();
    }

    public void paintWorld(Graphics graph){
        main_player.drawEntity(graph);

        c1.drawEntity(graph);
        c2.drawEntity(graph);
        c3.drawEntity(graph);
        c4.drawEntity(graph);

        Color c = graph.getColor();

        graph.setColor(Color.GREEN);
        graph.fillRect(width/2,50 , main_player.getLifePoints()*5, 10);
        graph.setColor(Color.GRAY);
        graph.drawRect(width/2-1,49 , 501, 10);
        graph.setColor(c);
    }

    public void updatePlayerX(int x){
        entityContainer.updatePlayerDataX(x);
    }
    public void updatePlayerY(int y){
        entityContainer.updatePlayerDataY(y);
    }
}
