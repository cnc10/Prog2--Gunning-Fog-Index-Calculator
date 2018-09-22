package prog2;
/*
CSE 17
Claudia Cohen
CNC219
Program Description: Create a program to use the Gunning Fog Index to evaluate the grade level of a text
Program #2
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
public class Prog2 {
    public static void main(String[] args) {
        String textBody = readFile(args); //String called textBody that will contain the text, the sentences the words, testing
        GunningFog gradeLevel = new GunningFog(textBody);
        DecimalFormat df2 = new DecimalFormat(".##");
        
        System.out.println("The Gunning Fog Grade Level for the Gettysburg Address is: " +df2.format(gradeLevel.calculateIndex()));
        
    }
    public static String readFile(String[] args){
       String result = "";
       StringBuilder textOut = new StringBuilder();
       BufferedReader fin = null; //buffered reader called Fin
       String line = null;
       try{
           fin = new BufferedReader(new FileReader("in.txt")); //from file reader read in.txt into buffered reader
           while ((line = fin.readLine()) != null) { //while when we read next line from fin and its not nothing
               textOut.append(line + " ");
               System.out.println(line); 
           }
           
           
       } catch (IOException ex) { //will discuss on Friday
            ex.printStackTrace();
        } finally {
        } //pass the file name to the file reader constructor
       result = textOut.toString();
       return result;
    }

}
