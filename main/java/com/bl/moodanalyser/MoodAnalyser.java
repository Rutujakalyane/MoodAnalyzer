package com.bl.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser()
        {
            this.message=null;
        }
    public MoodAnalyser(String message)
        {
            if(message.contains("sad"))
                this.message="SAD";
            else
                this.message="HAPPY";

        }

        public String analyseMood()
        {
            return this.message;
        }
    }