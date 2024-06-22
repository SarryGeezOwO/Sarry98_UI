package com.Sarry_98;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AssetHandler {
    
    public BufferedImage loadImage(String path) {
        try (InputStream iS = getClass().getResourceAsStream(path)) {

            if(iS == null)
                throw new IllegalArgumentException("Image not found : " + path);
            
            return ImageIO.read(iS);

        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Font loadFont(String path) {
        try (InputStream iS = getClass().getResourceAsStream(path)) {

            if(iS == null)
                throw new IllegalArgumentException("Font not found : " + path);
            
            return Font.createFont(Font.TRUETYPE_FONT, iS);

        } catch(IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon resizeIcon(String path, Vector2 newSize) {
        ImageIcon base = new ImageIcon(loadImage(path));
        Image root = base.getImage();
        Image scaled = root.getScaledInstance(newSize.x, newSize.y, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

}
