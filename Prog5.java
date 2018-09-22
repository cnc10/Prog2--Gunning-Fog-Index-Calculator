/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Claudia Cohen
//CNC219
//CSE 017
package prog5;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Claudia
 */
//Claudia Cohen
//CNC219
//4/11/19
//Prog 5- Create a file an url importer to change an image into ascii art


public class Prog5 {
   
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        String imagePath;
        BufferedImage rawImage = null;
        char[][] outputImage = null;
        try{
            System.out.println("Please Enter image file path or url (starting with http): "); //prompt console to input URL or file
            imagePath = myScanner.nextLine(); //store input

            if(imagePath.startsWith("http:")) { //if image is website
                URL importedImageURL = new URL(imagePath); //access image
                rawImage = ImageIO.read(importedImageURL); //read and store
            } else{ //if image stored in a file
                File importedImageFile = new File(imagePath); //access image
                rawImage = ImageIO.read(importedImageFile); //read and store
            }
        }
        catch(Exception e){ //catch file access or read errors
            System.out.println(e);
        }
        GImage convertedImage = new GImage(rawImage); //create custom GImage Object from Buffered image
        outputImage = convertedImage.convertToChars(); //create ascii image from grey scale raw image
        for(int index = 0; index < outputImage.length; index++){ //navagating x 
            for(int jndex = 0; jndex < outputImage[index].length; jndex++){ //and y to print out the image
                System.out.print(outputImage[index][jndex]); //print out image
            }
            System.out.println();
        }
        
        
    
    }
        // #5 create try catch and finally blocks because an exception will be thrown
        ////create a GImage object and pass buffered reader through constructor (does processing)
        //call method convertToChars() which returns a grid of char[][] that will store the buffered image string
//http://www.cse.lehigh.edu/~jfemister/img/me3.jpg
}
        
     
    

