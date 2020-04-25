package com.bl.moodanalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

        public static MoodAnalyser createMoodAnalyserObject(String msg) {
            try {
                Class<?> moodAnalyserClass = Class.forName("com.moodanalyse.MoodAnalyser");
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
                return (MoodAnalyser) moodConstructor.newInstance(msg);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
