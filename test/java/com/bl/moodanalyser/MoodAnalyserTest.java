package com.bl.moodanalyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
        @Test
        public void givenMessage_WhenSad_Should_ReturnSad() throws MoodAnalyserException {
            MoodAnalyser analyzer = new MoodAnalyser("this sad is message");
            String mood = analyzer.analyseMood();
            Assert.assertEquals("SAD",mood);
        }
        @Test
        public void givenMessage_WhenAny_ShouldReturnHappy() throws MoodAnalyserException {
            MoodAnalyser analyzer = new MoodAnalyser("I am in any mood");
            String mood = analyzer.analyseMood();
            Assert.assertEquals("HAPPY",mood);

        }
        @Test
        public void givenMessage_WhenNull_ShouldReturnHappy() throws MoodAnalyserException {
            MoodAnalyser analyzer = new MoodAnalyser("NULL");
            String  mood = analyzer.analyseMood();
            Assert.assertEquals("HAPPY",mood);
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
                Assert.assertEquals(MoodAnalyserException.exceptionType.ENTERED_EMPTY,e.type);
            }
        }
        @Test
        public void givenMoodAnalyserClass_whenProper_ShouldReturnObject() throws MoodAnalyserException {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyser moodAnalyserFactory = new MoodAnalyser();
            Assert.assertEquals(true,new MoodAnalyser().equals(moodAnalyserFactory));
        }
        @Test
        public void givenMoodAnalyserClass_whenNotProper_ReturnMoodAnalyserException() {
            try {
                MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            } catch (MoodAnalyserException e) {
                Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, e.type);
            }
        }
        @Test
        public void givenMoodAnalyserConstructor_WhenNotProper_ReturnMoodAnalyserException() {
            try {
                MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            } catch (MoodAnalyserException e) {
                Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.type);
            }
        }
        @Test
        public void givenMoodAnalyserClassParam_whenProper_ShouldReturnObject() throws MoodAnalyserException {
            MoodAnalyser moodAnalyserFactory = new MoodAnalyser();
            Assert.assertEquals(true,new MoodAnalyser().equals(moodAnalyserFactory));
        }
        @Test
        public void givenMoodAnalyserClassParam_whenImproper_ReturnMoodAnalyserException() {
            try {
                MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
            } catch (MoodAnalyserException e) {
                Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_CLASS, e.type);
            }
        }
        @Test
        public void givenMoodAnalyserClassParam_improperConstructor_ReturnMoodAnalyserException() {
            try {
                MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
            } catch (MoodAnalyserException e) {
                Assert.assertEquals(MoodAnalyserException.exceptionType.NO_SUCH_METHOD, e.type);
            }
        }
        @Test
        public void givenMessageUsingReflection_whenProper_ReturnHappy() {
            try {
                MoodAnalyser ReflectObject = MoodAnalyserFactory.createMoodAnalyser("I am in very Happy Mood");
                Object mood = MoodAnalyserFactory.invokeMethod(ReflectObject, "analyseMood");
                Assert.assertEquals("HAPPY",mood);
            } catch (MoodAnalyserException e) {
                e.printStackTrace();
            }
        }


}







