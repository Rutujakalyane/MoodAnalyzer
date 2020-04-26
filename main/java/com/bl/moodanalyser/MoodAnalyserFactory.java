package com.bl.moodanalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {


    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyserException {
        try {
           Class moodAnalyserClass = Class.forName("com.bl.moodanalyser.MoodAnalyser");
            Constructor  moodConstructor = moodAnalyserClass.getConstructor();
            return (MoodAnalyser) moodConstructor.newInstance();
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
    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalyserException {
        try {
            Class moodAnalyserClass = Class.forName("com.bl.moodanalyser.MoodAnalyser");
            Constructor moodConstructor = moodAnalyserClass.getConstructor(String.class);
            return (MoodAnalyser) moodConstructor.newInstance(message);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, "please Enter Proper Class Name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, "please Enter Proper Method Name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object invokeMethod(MoodAnalyser moodAnalyserObject, String methodName) throws MoodAnalyserException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        }catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD,
                    "Define Proper method Name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch ( InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
