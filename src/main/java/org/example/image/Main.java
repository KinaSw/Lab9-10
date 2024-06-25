package org.example.image;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        long start, end;
        ImageProcessing img = new ImageProcessing();
        try{
            img.read("thailand.jpeg");
            start = System.currentTimeMillis();
            img.increaseBrightness(50);
            end = System.currentTimeMillis();
            img.write("thailand2.jpeg");
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
