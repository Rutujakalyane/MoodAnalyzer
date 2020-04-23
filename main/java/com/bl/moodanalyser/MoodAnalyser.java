package com.bl.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
        public MoodAnalyser(String message)
        {
            if(message == null){
                this.message=null;
            }else if(message.contains("happy")){
                this.message="HAPPY";}
            else
                this.message="SAD";
        }
        public String analyseMood() {
            try {
                if (message.contains("sad"))
                    return "SAD";
            } catch (NullPointerException e) {
                return "HAPPY";
            }
            return message;
        }

    }
}
