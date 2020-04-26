package com.bl.moodanalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_Should_ReturnSad() throws MoodAnalyserException {
        MoodAnalyser analyzer = new MoodAnalyser("this sad is message");
        String mood = analyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public void givenMessage_WhenAny_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser analyzer = new MoodAnalyser("I am in any mood");
        String mood = analyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);

    }
    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser analyzer = new MoodAnalyser("NULL");
        String mood = analyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    @Test
    public void givenMessage_WhenNull_ShouldReturnMoodAnalyserException() {
        MoodAnalyser analyzer = new MoodAnalyser(null);
        try {
            analyzer.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.ENTERED_NULL, e.type);
        }
    }
    @Test
    public void givenMessage_WhenEmpty_ShouldReturnMoodAnalyserException() {
        MoodAnalyser analyser = new MoodAnalyser("");
        try {
            analyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.ENTERED_EMPTY, e.type);
        }
    }
    @Test
    public void givenMoodAnalyserClass_whenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserFactory = new MoodAnalyser();
        Assert.assertEquals(true, new MoodAnalyser().equals(moodAnalyserFactory));
    }

    @Test
    public void givenMoodAnalyserClass_whenNotProper_ReturnMoodAnalyserException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, e.type);
        }
    }
    @Test
    public void givenMoodAnalyserConstructor_WhenNotProper_ReturnMoodAnalyserException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    @Test
    public void givenMoodAnalyserClassParam_whenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyserFactory = new MoodAnalyser();
        Assert.assertEquals(true, new MoodAnalyser().equals(moodAnalyserFactory));
    }
    @Test
    public void givenMoodAnalyserClassParam_whenImproper_ReturnMoodAnalyserException() {
        try {
            MoodAnalyserFactory.moodConstructor("com.bl.moodanalyzer.MoodAnalyzer1", String.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, e.type);
        }
    }
    @Test
    public void givenMoodAnalyserClassParam_improperConstructor_ReturnMoodAnalyserException() {
        try {
            MoodAnalyserFactory.moodConstructor("com.bl.moodanalyser.MoodAnalyser",Integer.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    @Test
    public void givenMessageUsingReflection_whenProper_ReturnHappy() {
        try {
            MoodAnalyser ReflectObject = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
            Object mood = MoodAnalyserFactory.invokeMethod(ReflectObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_ImproperMethodName_ReturnMoodAnalyseException() {
        try {
            MoodAnalyser ReflectObject = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
            Object mood = MoodAnalyserFactory.invokeMethod(ReflectObject, "analyseMood123");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy() {
        try {
            Object obj = MoodAnalyserFactory.createMoodAnalyser("I m in Happy Mood");
            Object mood = MoodAnalyserFactory.invokeMethod((MoodAnalyser) obj, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessage_WithReflection_InCorrectMethod_ShouldReturn_NoSuchMethodError() {
        try {
            Object obj = MoodAnalyserFactory.createMoodAnalyser("I m in Happy Mood");
            Object mood = MoodAnalyserFactory.invokeMethod((MoodAnalyser) obj, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_onChangeMood_ShouldReturnHappy() {
        try {
            Object obj = MoodAnalyserFactory.createMoodAnalyser("");
            MoodAnalyserFactory.setFieldValue(obj, "message", "I m in Happy Mood");
            Object mood = MoodAnalyserFactory.invokeMethod((MoodAnalyser) obj, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}