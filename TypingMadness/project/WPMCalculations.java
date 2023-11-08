import java.time.LocalTime;

public class WPMCalculations {

    private int correctCharCount;
    private int wrongCharCount;
    private int totalCharCount;
    private double bigNum;
    private double accuracyPercent;
    private String[] wordsGiven;
    private String[] wordsTyped;

    private double startTime;
    private double endTime;
    private double elapsedTime;
    private double elapsedSeconds;
    
    /**
     * getWPM();
     * * * returns words per minute.
     * 
     * startTest();
     * * * records time of test start
     * 
     * calculateAccuracy();
     * * * counts the number of total, correct and incorrect characters, and calculates the percentage accuracy
     * 
     * getAccuracy();5
     * * * returns accuracy
     * 
     * getElapsedSeconds();
     * * * returns elapsed seconds
     */

    public int getWPM () {
        // raw WPM formula (total characters typed / 5) / time in minutes
        double rawWPM = ((((double) totalCharCount/5) / elapsedSeconds) * 60);
        // wpm formula: raw wpm - (wrong characters typed / time in minutes)
        int wpm = (int) (rawWPM - ((double) ( wrongCharCount / elapsedSeconds)));
        return wpm;
    }

    public void startTest(String wordsOut){
        wordsGiven = wordsOut.split(" ");
        startTime = LocalTime.now().toNanoOfDay(); // records time when test starts
    }

    public void endTest(String wordsIn){
        endTime = LocalTime.now().toNanoOfDay(); // records time when test ends
        elapsedTime = endTime - startTime; // elapsed time in nanoseconds
        elapsedSeconds = elapsedTime / 1000000000.0;
        wordsTyped = wordsIn.split(" ");
        
        calculateAccuracy();
    }

    public void calculateAccuracy(){
                // if number of words typed is equal to words given
                if (wordsGiven.length == wordsTyped.length){
                    for (int i = 0; i < wordsGiven.length; i++){ 
                        if (wordsGiven[i].equals(wordsTyped[i])){
                            correctCharCount += wordsGiven[i].length();
                        }
                        else{
                            // if the typed word has the same amount of characters as the word given
                            if (wordsGiven[i].length() == wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                            }
                            // if typed word has missing characters
                            else if (wordsGiven[i].length() > wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsTyped[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                        
                                    }
                                }
                                int diff = wordsGiven[i].length() - wordsTyped[i].length();
                                wrongCharCount += diff;
                            }
                            // typed word has extra characters
                            else{
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                                int diff = wordsTyped[i].length() - wordsGiven[i].length();
                                wrongCharCount += diff;
                            }
                        }
                    }
                }
                else if (wordsGiven.length >= wordsTyped.length){
                    // if typed output is missing words
                    for (int i = 0; i < wordsTyped.length; i++){
                        if (wordsGiven[i].equals(wordsTyped[i])){
                            correctCharCount += wordsGiven[i].length();
                        }
                        else{
                            // if typed input has the same amount of words as words given
                            if (wordsGiven[i].length() == wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                            }
                            // if typed input has missing words
                            else if (wordsGiven[i].length() > wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsTyped[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                        
                                    }
                                }
                                int diff = wordsGiven[i].length() - wordsTyped[i].length();
                                wrongCharCount += diff;
                            }
                            // if typed input has extra words
                            else{ 
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                                int diff = wordsTyped[i].length() - wordsGiven[i].length();
                                wrongCharCount += diff;
                            }
                        }
                    }
                }
                else if (wordsGiven.length <= wordsTyped.length){
                    // if typed input has extra words
                    for (int i = 0; i < wordsGiven.length; i++){
                        if (wordsGiven[i].equals(wordsTyped[i])){
                            correctCharCount += wordsGiven[i].length();
                        }
                        else{
                            // if typed input has the same amount of words as words given
                            if (wordsGiven[i].length() == wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                            }
                            // if typed input has missing words
                            else if (wordsGiven[i].length() > wordsTyped[i].length()){ 
                                for (int num = 0; num < wordsTyped[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                        
                                    }
                                }
                                int diff = wordsGiven[i].length() - wordsTyped[i].length();
                                wrongCharCount += diff;
                            }
                            // if typed input has extra words
                            else{ 
                                for (int num = 0; num < wordsGiven[i].length(); num++){
                                    if (wordsGiven[i].charAt(num) == wordsTyped[i].charAt(num)){
                                        correctCharCount++;
                                    }
                                    else{
                                        wrongCharCount++;
                                    }
                                }
                                int diff = wordsTyped[i].length() - wordsGiven[i].length();
                                wrongCharCount += diff;
                            }
                        }
                    }
                }
                
                totalCharCount = correctCharCount + wrongCharCount;
                bigNum = correctCharCount * 100;
                accuracyPercent = bigNum/totalCharCount;
    } // END ACCURACY METHOD

    public double getAccuracy(){
        calculateAccuracy();
        return accuracyPercent;
    }

    public double getElapsedSeconds(){
        return elapsedSeconds;
    }
}
