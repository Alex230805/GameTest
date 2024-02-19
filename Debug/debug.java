package Debug;

import java.util.*;

import java.awt.*;

public class debug extends Panel{
    public ArrayList<String> debug_info;


    public debug(){
        debug_info = new ArrayList<>();
    }

    public void addDebugInfo(String g){
        debug_info.add(g);
    }

    public void displayInfo(Color c, Graphics graph){
            int offset = 15;
            int max_width = 0;
            int factor = 10;
            graph.setColor(Color.WHITE);

            String[] list = debug_info.toArray(String[]::new);

            max_width = list[0].length();

            for(int i=0;i<list.length;i++){
                if(list[i].length() > max_width){
                    max_width = list[i].length();
                }
            }

            max_width = (max_width*factor);


            graph.fillRect(20, 0, max_width, list.length*20);

            graph.setColor(c);

            for(int i=0;i<list.length;i++){
                graph.drawString(list[i].toString(),30,15+(offset*i));
            }

    }
}
