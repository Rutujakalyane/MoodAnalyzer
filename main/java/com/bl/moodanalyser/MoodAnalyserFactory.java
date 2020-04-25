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
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
