/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//test this progam with the getsyburg address
package prog2;

/**
 *
 * @author Claudia
 */
/*
CSE 17
Claudia Cohen
CNC219
Program Description: Create a program to use the Gunning Fog Index to evaluate the grade level of a text
Program #2
*/
public class Word {//create class Word for storing a single word from the text
   //public constructor takes in String as a parameter
    private String text; //actual word
    private int numSyllables; //syllables in this word
    public boolean isComplex(){
        return this.numSyllables >= 3;
    }
    
    public Word(String textIn){
        //constructor that will store a single string in String text
        this.text = textIn;
        this.numSyllables = syllableCounter(text);
    }
    public String getText(){
        return this.text;
    }
    public int getNumSyllables(){
        return this.numSyllables;
    }
    public void setText(String textIn){
        this.text = textIn; 
        this.numSyllables = syllableCounter(text);
    }
    public static int syllableCounter(String wordIn) {
            int result = 0;
            if(wordIn.endsWith(",")){
                wordIn = wordIn.substring(0,wordIn.length()-1);
            }
            if(wordIn.endsWith(";")){
                wordIn = wordIn.substring(0,wordIn.length()-1);
            }
            if(wordIn.endsWith(":")){
                wordIn = wordIn.substring(0,wordIn.length()-1);
            }
            if(wordIn.endsWith(".")){
                wordIn = wordIn.substring(0,wordIn.length()-1);
            }
            if(wordIn.endsWith("es")) {
                wordIn = wordIn.substring(0, wordIn.length()-2);
	    }
	    if(wordIn.endsWith(("ed"))) {
	    		wordIn = wordIn.substring(0,wordIn.length()-2);
	    }
	    if(wordIn.endsWith("ing")) {
	    		wordIn = wordIn.substring(0, wordIn.length()-3);
	    	}
	    if(wordIn.endsWith("e")) {
	    		wordIn = wordIn.substring(0, wordIn.length()-1);
	    }
		wordIn = doubleVowel(wordIn);
		result = vowelCounter(wordIn);
		
		return result;
	}
	
	public static String doubleVowel(String wordIn) {
		for(int index = 0; index < wordIn.length()-1; index++) {
		   if(vowelDetector(wordIn.charAt(index))) {
			   if(vowelDetector(wordIn.charAt(index+1))) {
				   if(index+2 < wordIn.length()) {
					   wordIn = wordIn.substring(0, index+1) + wordIn.substring(index+2); 
				   } 
			   } 
		   }
		}
		return wordIn;
	}
	    
    //find each vowel and see if it is followed by a vowel, find a method
   public static boolean vowelDetector(char ch){ //tells us whether or not ch is a vowel
	   boolean result = false;
	   if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
			   || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
		   result = true;
	   }
	   return result;
   }
   public static int vowelCounter(String wordIn){ //tells us how many vowels are in wordIn
	   int result = 0;
	   for(int index = 0; index < wordIn.length(); index++) {
		   if(vowelDetector(wordIn.charAt(index))) {
			   result += 1; 
		   }
	   }
           if(wordIn.endsWith("y") || wordIn.endsWith("Y")){
               result += 1;
           }
	   return result;
	   
   }    
}
    

