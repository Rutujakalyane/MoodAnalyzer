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
    }







