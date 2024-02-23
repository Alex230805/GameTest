package Window.gui;

import java.io.IOException;

import Window.*;

import Window.gui.start_gui.*;


public class gui {
    private int width;
    private int height;


    public start_gui start;

    
    public gui(int width,int height) throws IOException{
        this.width = width;
        this.height = height;
        try{
            start = new start_gui(width, height);
        }catch(IOException ex ){
            throw ex;
        }

        start.setVisible(false);
    }

    public void appendElement(Window win){
        win.add(start);
    }

    public void enabelStartgui(){
        start.setVisible(true);
    }
    public void disableStartgui(){
        start.setVisible(false);
    }

    public void updateStatus(){

        start.updateStatus();
        
    }
}
