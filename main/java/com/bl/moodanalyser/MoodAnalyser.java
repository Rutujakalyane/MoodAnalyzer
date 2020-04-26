package com.bl.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalyserException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.exceptionType.ENTERED_EMPTY,"please enter proper Mood");
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.ENTERED_NULL,"please enter proper Mood");
        }
    }

    public boolean equals(MoodAnalyser another) {
        if (this.message == another.message) {
            return true;
        }
        return false;
    }


}




   

   