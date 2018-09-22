package prog2;
/*
CSE 17
Claudia Cohen
CNC219
Program Description: Create a program to use the Gunning Fog Index to evaluate the grade level of a text
Program #2
*/
public class GunningFog {
    private String textBody;
    private int sentenceCount, wordCount, complexWordCount;
    
    public String gettextBody() { //class method for getter
        return textBody;
    }
    
    public void setText(String textBodyIn) { //class method for setter
        this.textBody= textBodyIn;
    }
    //constructor
    GunningFog(String textBodyIn){
        this.textBody = textBodyIn;
        this.sentenceCount = 0;
        this.wordCount = 0;
        this.complexWordCount = 0;
    }
    public int getSentenceCount(){
        return this.sentenceCount;
    }
    public int getWordCount(){
        return this.wordCount;
    }
    public int getcomplexWordCount(){
        return this.complexWordCount;
    }
    public double calculateIndex(){
        double result = 0.0; //result = Gunning Fog Index 
        for(int index = 0; index < textBody.length(); index++){
            if(textBody.charAt(index) == '.'){
                sentenceCount++;
            }
        }
        
        String[] words;
        words = textBody.split(" ");
        for(int index = 0; index < words.length; index++){
            Word currentWord = new Word(words[index]);
            
            //System.out.println(currentWord.getText());
            if(currentWord.isComplex()){
                complexWordCount++;
                //System.out.println("complex word: " + currentWord.getText());
            }
            wordCount++;
        }
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Complex Word Count: " + complexWordCount);
        result = .4 * (((double)wordCount/sentenceCount) + 100 * ((double)complexWordCount/wordCount));
        return result;
    }
    
}
