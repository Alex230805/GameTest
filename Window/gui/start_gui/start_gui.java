package Window.gui.start_gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import classes.entity.entityIdInterface;
import classes.entity.player.player;

import Debug.debug;
import Window.input.input;
import Window.input.inputBufferInterface;

public class start_gui extends JPanel implements entityIdInterface, KeyListener, inputBufferInterface{
    private int width;
    private int height;
    public player p;
    public static input inputLayer;
    int i = 0;

    public start_gui(int width,int height){
        inputLayer = new input();
        this.width = width;
        this.height = height;
        p = new player(1, 1, playerEntityId, "Player", 100, 100, width,height);
        addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics graph){
        super.paintComponent(graph);
        graph.setFont(graph.getFont());

        debug debuginfo = new debug();

        graph.setColor(Color.BLACK);
        graph.fillRect(0, 0, width, height);


        debuginfo.addDebugInfo("Panel 0: Start GUI");
        debuginfo.addDebugInfo("Entity 0: " + p.getEntityName());
        debuginfo.addDebugInfo("Clock Counter Paint: "+ i);
        debuginfo.addDebugInfo("x: "+inputLayer.getX());
        debuginfo.addDebugInfo("y: "+inputLayer.getY());


        debuginfo.displayInfo(Color.BLACK, graph);
        p.drawEntity(graph);
        i++; 
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
                inputLayer.moveUp();
                p.setY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_S)){
                inputLayer.moveDown();
                p.setY(inputLayer.getY());

            }
            if(inputLayer.isPresent(KeyEvent.VK_D)){
                inputLayer.moveRight();
                p.setX(inputLayer.getX());

            }
            if(inputLayer.isPresent(KeyEvent.VK_A)){
                inputLayer.moveLeft();
                p.setX(inputLayer.getX());

            }
        }
}
