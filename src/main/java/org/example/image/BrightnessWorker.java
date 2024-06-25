package org.example.image;

import org.example.image.Clamp;

import java.awt.image.BufferedImage;

public class BrightnessWorker implements Runnable{
    public int start;
     public int end;
     public BufferedImage image;
     public int value;
     public BrightnessWorker(int start, int end) {
         this.start = start;
         this.end = end;
         this.image= image;
         this.value=value;
     }
    @Override
    public void run() {
        int width = image.getWidth();
        int height = image.getHeight();
        int blue;
        int green;
        int red;
        int newRgb;
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                int rgb = image.getRGB(x,y);
                blue = rgb & 0xFF;
                green = (rgb >> 8) & 0xFF;
                red = (rgb >> 16) & 0xFF;
                blue = Clamp.clamp(blue + value, 0, 255);
                green = Clamp.clamp(green + value, 0, 255);
                red = Clamp.clamp(red + value, 0, 255);
                newRgb = (0xFF << 24)|(red << 16) | (green << 8) | blue;
                // System.out.println("RGB signed 32 bit = "+rgb+" hex: "+Integer.toHexString(rgb) + " binary:" + Integer.toBinaryString(rgb)+ " blue: " + blue + " green: "+green + " red: "+red + " new RGB: "+Integer.toBinaryString(newRgb));
                image.setRGB(x,y,newRgb);
            }
        }
    }

}
