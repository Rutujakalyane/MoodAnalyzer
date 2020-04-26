package com.bl.moodanalyser;

    public class MoodAnalyserException extends Exception{

        public enum exceptionType {
            ENTERED_NULL, ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,No_ACCESS,METHOD_INVOCATION_ISSUE;
        }
        exceptionType type;
        public MoodAnalyserException(String message) {
            super(message);
        }

        public MoodAnalyserException( exceptionType type, String message) {
            super(message);
            this.type = type;
        }
    }





