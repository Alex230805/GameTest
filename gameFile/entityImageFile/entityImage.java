package gameFile.entityImageFile;

import java.awt.image.*;

public class entityImage {
    private BufferedImage sprite;
    private String id;

    public entityImage(String id, BufferedImage img){
        this.sprite = img;
        this.id = new String(id.toString());
    }

    public String getId(){
        return id;
    }

    public BufferedImage getImg(){
        return sprite;
    }
}
