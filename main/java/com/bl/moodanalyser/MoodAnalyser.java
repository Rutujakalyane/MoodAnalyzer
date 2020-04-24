package com.bl.moodanalyser;

public class MoodAnalyser {
        String message;

    public MoodAnalyser() {
        this("I am in Any Mood");
    }
    public MoodAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood() {
        try{
            if(message.contains("sad")){
                return "SAD";
            }else {
                return "HAPPY";
            }
        }catch (NullPointerException e){
            return "HAPPY";
        }
    }
}
   

   