package Window.gui.start_gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import classes.entity.entityIdInterface;
import classes.entity.player.player;
import classes.entityGroup.entityGroup;
import Debug.debug;
import Window.input.input;
import Window.input.inputBufferInterface;
import classes.entity.npc.*;

public class start_gui extends JPanel implements entityIdInterface, KeyListener, inputBufferInterface{
    private int width;
    private int height;
    public player p;
    public npc c;
    public npc c1;
    public npc c2;
    public static input inputLayer;
    public entityGroup entityContainer;

    public start_gui(int width,int height){
        entityContainer = new entityGroup();
        inputLayer = new input();
        this.width = width;
        this.height = height;

        p = new player(width/2, height/2, playerEntityId, "Player", 50, 50, width,height);
        c = new npc(200,300, generic_npc, "NPC 1", 40,40, Color.BLUE, width,height);
        c1 = new npc(600,100, generic_npc, "NPC 2", 60,60, Color.GRAY, width,height);
        c2 = new npc(90,0, generic_npc, "NPC 3", 10,10, Color.YELLOW, width,height);

        entityContainer.insertEntity(p);
        entityContainer.insertEntity(c);
        entityContainer.insertEntity(c1);
        entityContainer.insertEntity(c2);
        
        addMouseListener(p);
        p.setFocus(true);
        addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics graph){
        super.paintComponent(graph);
        graph.setFont(graph.getFont());

        

        graph.setColor(Color.BLACK);
        graph.fillRect(0, 0, width, height);

        p.drawEntity(graph);
        c.drawEntity(graph);
        c1.drawEntity(graph);


        debug debuginfo = new debug();
        debuginfo.addDebugInfo("Panel 0: Start GUI");
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Entity 0: " + p.getEntityName());
        debuginfo.addDebugInfo("Entity 0 X position: " + p.getX());
        debuginfo.addDebugInfo("Entity 0 Y position: " + p.getY());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Entity 1: " + c.getEntityName());
        debuginfo.addDebugInfo("Entity 1 X position: " + c.getX());
        debuginfo.addDebugInfo("Entity 1 Y position: " + c.getY());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Entity 2: " + c1.getEntityName());
        debuginfo.addDebugInfo("Entity 2 X position: " + c1.getX());
        debuginfo.addDebugInfo("Entity 2 Y position: " + c1.getY());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Entity 3: " + c2.getEntityName());
        debuginfo.addDebugInfo("Entity 3 X position: " + c2.getX());
        debuginfo.addDebugInfo("Entity 3 Y position: " + c2.getY());

        debuginfo.displayInfo(Color.BLACK, graph);

    }

    @Override

    public void keyPressed(KeyEvent e){
        new Thread(new Runnable() {
            public void run(){
                inputBuffer.add(e.getKeyCode());
            }
        }).start();
    }
    public void keyReleased(KeyEvent e){
        new Thread(new Runnable(){
            public void run(){
                inputBuffer.remove(e.getKeyCode());
            }
        }).start();
    }
    public void keyTyped(KeyEvent e){
        new Thread(new Runnable(){
            public void run(){
                System.out.println("-> "+e.getKeyChar());
            }
        }).start();
    }

    public void updateStatus(){
            entityContainer.updateNpcAi();
            if(inputLayer.isPresent(KeyEvent.VK_W)){
                inputLayer.moveUp();
                entityContainer.updateEntityDataY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_S)){
                inputLayer.moveDown();
                entityContainer.updateEntityDataY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_D)){
                inputLayer.moveRight();
                entityContainer.updateEntityDataX(inputLayer.getX());

            }
            if(inputLayer.isPresent(KeyEvent.VK_A)){
                inputLayer.moveLeft();
                entityContainer.updateEntityDataX(inputLayer.getX());
            }
        }
}
