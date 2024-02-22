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
import classes.world.world;

public class start_gui extends JPanel implements entityIdInterface, KeyListener, inputBufferInterface{
    private int width;
    private int height;
    public static input inputLayer;
    public entityGroup entityContainer;
    private world world1;

    public start_gui(int width,int height){
        entityContainer = new entityGroup();
        inputLayer = new input();
        setBounds(0, 0, width, height);
        this.width = width;
        this.height = height;
        world1 = new world(width, height, 9.8);
        
        addMouseListener(world1.main_player);

        addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics graph){
        super.paintComponent(graph);

        graph.setColor(new Color(68, 189, 72,128));
        graph.fillRect(0, 0, width, height);

        world1.paintWorld(graph);
        


        debug debuginfo = new debug();
        debuginfo.addDebugInfo("Panel 0: Start GUI");
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Entity 0: " + world1.main_player.getEntityName());
        debuginfo.addDebugInfo("X position: " + world1.main_player.getX());
        debuginfo.addDebugInfo("Y position: " + world1.main_player.getY());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("Pov_x: " + world1.main_player.getPovX());
        debuginfo.addDebugInfo("Pov_y: " + world1.main_player.getPovY());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("NPC 1 interaction: " + world1.c1.getPlayerFocus());
        debuginfo.addDebugInfo("NPC 2 interaction: " + world1.c2.getPlayerFocus());
        debuginfo.addDebugInfo("NPC 3 interaction: " + world1.c3.getPlayerFocus());
        debuginfo.addDebugInfo("NPC 4 interaction: " + world1.c4.getPlayerFocus());
        debuginfo.addDebugInfo("----------------------------");
        debuginfo.addDebugInfo("NPC 1 x: "+ world1.c1.getX() + " y: "+world1.c1.getY());
        debuginfo.addDebugInfo("NPC 2 x: "+ world1.c2.getX() + " y: "+world1.c2.getY());
        debuginfo.addDebugInfo("NPC 3 x: "+ world1.c3.getX() + " y: "+world1.c3.getY());
        debuginfo.addDebugInfo("NPC 4 x: "+ world1.c4.getX() + " y: "+world1.c4.getY());

        debuginfo.displayInfo(Color.GRAY, graph);

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
    }

    public void updateStatus(){
            world1.updateWorldTick();
            if(inputLayer.isPresent(KeyEvent.VK_W)){
                inputLayer.moveUp();
                world1.updatePlayerY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_S)){
                inputLayer.moveDown();
                world1.updatePlayerY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_D)){
                inputLayer.moveRight();
                world1.updatePlayerX(inputLayer.getX());

            }
            if(inputLayer.isPresent(KeyEvent.VK_A)){
                inputLayer.moveLeft();
                world1.updatePlayerX(inputLayer.getX());
            }
        }
}
