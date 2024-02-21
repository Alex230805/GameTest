package Window;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Window.gui.gui;
import Window.input.inputBufferInterface;

public class Window extends JFrame implements inputBufferInterface{
    private int width;
    private int height;
    public gui game_gui;

    public Window(int width,int height){
        this.width = width;
        this.height = height;
        game_gui = new gui(width,height);
        game_gui.appendElement(this);
        game_gui.enabelStartgui();
        setBounds(0, 0, width, height);
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e){
                System.exit(0);
           }
        });
        addKeyListener(game_gui.start);
        setVisible(true);
    }
}
