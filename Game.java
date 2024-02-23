import Window.Window;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.Timer;
import java.awt.*;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game{

    private static final int no_error = 0;
    private static final int generic_error_status = 1;
    private static final int unable_to_open = 2;


    private static Window wi;
    private static final int TICK = 16;
    public static Graphics graph;


    public static void main(String args[]){
        Game gameRuntime = new Game();
        try{
            wi = new Window(1200,750);
        }catch(IOException ex){
            System.out.println("EXCEPTION -> " + ex.getMessage()+ "\nSTACK TRACE -> "+ex.getStackTrace());
            System.exit(unable_to_open);
        }

        graph = wi.getGraphics();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(64);

        scheduler.scheduleAtFixedRate(()->{
            SwingUtilities.invokeLater(()->{
                gameRuntime.update();
            });
        }, 0, TICK, TimeUnit.MILLISECONDS);
        wi.paint(graph);
    }

    private void update(){
        wi.game_gui.updateStatus();
        wi.repaint();
    }
}
