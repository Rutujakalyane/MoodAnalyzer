package com.bl.moodanalyser;
import org.junit.Assert;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void given_Message_whenSad_ShouldReturnHSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
