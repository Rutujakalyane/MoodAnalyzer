package com.bl.moodanalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bl.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
           throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_CLASS,"Please enter proper class name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD,"Please enter proper method");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
