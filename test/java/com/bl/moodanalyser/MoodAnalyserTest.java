package com.bl.moodanalyser;
import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyserTest {
    @Test
    public void whenMood_IsSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad Mood");
        String message = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",message);
    }

    @Test
    public void whenIn_AnyMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any Mood");
        String message = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",message);
    }

    @Test
    public void whenMood_IsNull_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String message = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", message);
    }



}

