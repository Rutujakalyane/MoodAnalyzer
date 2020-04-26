package com.bl.moodanalyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String className) throws MoodAnalyserException {
        try {
            Class moodAnalyserClass = Class.forName("com.bl.moodanalyser.MoodAnalyser");
            Constructor moodConstructor = moodAnalyserClass.getConstructor();
            return (MoodAnalyser) moodConstructor.newInstance();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, "Please enter proper class name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, "Please enter proper method");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor moodConstructor(String className, Class constructor) throws MoodAnalyserException {
        try {
            Class moodAnalyser = Class.forName(className);
            return moodAnalyser.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Object invokeMethod(MoodAnalyser moodAnalyserObject, String methodName) throws MoodAnalyserException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, "Define Proper method Name");
        }
    }
    public static void setFieldValue(Object obj, String fieldName, String fieldValue) throws MoodAnalyserException {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_SUCH_FIELD, "NO_SUCH_FIELD");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.exceptionType.NO_ACCESS, "NO_ACCESS");
        }
    }
}
