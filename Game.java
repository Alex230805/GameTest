

import Window.Window;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.*;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game{
    private static Window wi;
    private static final int TICK = 17;
    public static Graphics graph;


    public static void main(String args[]){
        Game gameRuntime = new Game();
        wi = new Window(1200,800);
        graph = wi.getGraphics();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(120);

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