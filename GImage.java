/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Claudia Cohen
//CNC219
//4/11/19
//Prog 5- Create a file an url importer to change an image into ascii art

package prog5;

import java.awt.image.BufferedImage;

/**
 *
 * @author Claudia
 */
public class GImage {
    private BufferedImage rawImage;
    GImage(BufferedImage rawImageIn){ //GImage constructor
        this.rawImage = rawImageIn;
    }
    private void convertToGray(){ //method that will convert each pixel in the image to grayscale value
        int imageHeight = rawImage.getHeight(); //get image dimensions
        int imageWidth = rawImage.getWidth(); //get image dimensions
        int rgb = 0; //pixel numerical color value
        int red; //pixel red value
        int green; //pixel green value
        int blue; //pixel blue value
        for(int index = 0; index < imageHeight; index++){ //navigate x 
            for(int jndex = 0; jndex < imageWidth; jndex++){ //navigate y 
                rgb = rawImage.getRGB(index, jndex); //get the color of the current pixel at x and y
                red = (rgb >> 16) & 0xFF; //shift out red
                green = (rgb >> 8) & 0xFF; //shift out green
                blue = rgb & 0xFF; //shift out blue
                rgb = (red + green + blue) / 3; //average of pixels
                red = rgb; //store average
                green = rgb; //store average 
                blue = rgb; //store average
                rgb = red; //shift in red 
                rgb = (rgb << 8) + green; //shift in green
                rgb = (rgb << 8) + blue; //shift in blue
                rawImage.setRGB(index, jndex, rgb); //set pixel to grayscale color
            }
        }
    }
    public char[][] convertToChars(){
        int imageHeight = rawImage.getHeight(); //get image dimensions
        int imageWidth = rawImage.getWidth(); //get image dimensions
        int rgb = 0; //pixel numerical color value
        String grayScaleCharacters = "@%#*=-:. "; //character substitution map
        char[][] convertedImage = new char[imageHeight][imageWidth]; //ascii art 
        for(int index = 0; index < rawImage.getWidth(); index++){ //navigate x
            for(int jndex = 0; jndex < rawImage.getHeight(); jndex++){ //navigate y
                rgb = rawImage.getRGB(index,jndex ); //get color of the current pixel at x and y 
                rgb = (rgb >> 16) & 0xFF; //shift out the red value, any value is fine since they are all the same         
                convertedImage[jndex][index] = grayScaleCharacters.charAt(rgb/29); //get ascii substitution value from the m
            }
        }
        return convertedImage; //return ascii art
    }   
}

