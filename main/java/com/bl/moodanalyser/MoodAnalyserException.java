package com.bl.moodanalyser;

    public class MoodAnalyserException extends Exception{

        public enum exceptionType { ENTERED_NULL, ENTERED_EMPTY };
        exceptionType type;

        public MoodAnalyserException(String message) {
            super(message);
        }

        public MoodAnalyserException( exceptionType type, String message) {
            super(message);
            this.type = type;
        }
    }





