package Window.gui.start_gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import classes.entity.entityIdInterface;
import classes.entity.player.player;
import classes.entityGroup.entityGroup;
import Debug.debug;
import Window.input.input;
import Window.input.inputBufferInterface;
import classes.entity.npc.*;
import classes.world.world;

public class start_gui extends JPanel implements entityIdInterface, KeyListener, inputBufferInterface {
    private int width;
    private int height;
    public static input inputLayer;
    public entityGroup entityContainer;
    private world world1;

    public start_gui(int width, int height) throws IOException{
        entityContainer = new entityGroup();
        inputLayer = new input();
        setBounds(0, 0, width, height);
        this.width = width;
        this.height = height;
        try{
            world1 = new world(width, height, 9.8);
        }catch(IOException ex){
            throw ex;
        }
        world1.parseEntity(this);
        addMouseListener(world1.main_player);
        addKeyListener(this);
    }

    @Override

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        graph.setColor(new Color(68, 189, 72, 128));
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
        debuginfo.displayInfo(new Color(30, 30, 30, 220), graph);
    }

    @Override

    public void keyPressed(KeyEvent e) {
        inputBuffer.add(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {

        inputBuffer.remove(e.getKeyCode());

    }

    public void keyTyped(KeyEvent e) {
    }

    public void updateStatus() {
        world1.updateWorldTick();
        if (inputLayer.isPresent(KeyEvent.VK_W)) {
            inputLayer.moveUp();
            world1.updatePlayerY(inputLayer.getY());

        }
        if (inputLayer.isPresent(KeyEvent.VK_S)) {
            inputLayer.moveDown();
            world1.updatePlayerY(inputLayer.getY());

        }
        if (inputLayer.isPresent(KeyEvent.VK_D)) {
            inputLayer.moveRight();
            world1.updatePlayerX(inputLayer.getX());

        }
        if (inputLayer.isPresent(KeyEvent.VK_A)) {
            inputLayer.moveLeft();
            world1.updatePlayerX(inputLayer.getX());
        }
    }
}
