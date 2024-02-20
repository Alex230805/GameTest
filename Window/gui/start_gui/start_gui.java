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

public class start_gui extends JPanel implements entityIdInterface, KeyListener, inputBufferInterface{
    private int width;
    private int height;
    public player p;
    public player p1;
    public static input inputLayer;
    public entityGroup entityContainer;

    public start_gui(int width,int height){
        entityContainer = new entityGroup();
        inputLayer = new input();
        this.width = width;
        this.height = height;
        p = new player(1, 1, playerEntityId, "Player", 100, 100, width/2,height/2);
        p1 = new player(1, 1, playerEntityId, "Hello", 50, 50, 400,400);

        entityContainer.insertEntity(p);
        entityContainer.insertEntity(p1);


        p1.setFocus(true);

        addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics graph){
        super.paintComponent(graph);
        graph.setFont(graph.getFont());

        

        graph.setColor(Color.BLACK);
        graph.fillRect(0, 0, width, height);

        p.drawEntity(graph);
        p1.drawEntity(graph);

        debug debuginfo = new debug();
        debuginfo.addDebugInfo("Panel 0: Start GUI");
        debuginfo.addDebugInfo("Entity 0: " + p.getEntityName());
        debuginfo.addDebugInfo("Entity 0 id: " + p.getId_entity());
        debuginfo.addDebugInfo("Entity 0 X position: " + p.getX());
        debuginfo.addDebugInfo("Entity 0 Y position: " + p.getY());

        debuginfo.addDebugInfo("Entity 1: " + p1.getEntityName());
        debuginfo.addDebugInfo("Entity 1 id: " + p1.getId_entity());
        debuginfo.addDebugInfo("Entity 1 X position: " + p1.getX());
        debuginfo.addDebugInfo("Entity 1 Y position: " + p1.getY());

        debuginfo.addDebugInfo("x: "+inputLayer.getX());
        debuginfo.addDebugInfo("y: "+inputLayer.getY());
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

            if(inputLayer.isPresent(KeyEvent.VK_W)){
                entityContainer.loadInfo(inputLayer);
                inputLayer.moveUp();
                
                entityContainer.updateEntityDataY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_S)){
                entityContainer.loadInfo(inputLayer);
                inputLayer.moveDown();
                
                entityContainer.updateEntityDataY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_D)){
                entityContainer.loadInfo(inputLayer);
                inputLayer.moveRight();

                entityContainer.updateEntityDataX(inputLayer.getX());

            }
            if(inputLayer.isPresent(KeyEvent.VK_A)){
                entityContainer.loadInfo(inputLayer);
                inputLayer.moveLeft();

                entityContainer.updateEntityDataX(inputLayer.getX());
            }
        }
}
