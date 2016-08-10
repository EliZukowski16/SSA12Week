package com.tiy.ssa.weektwo.assignmentthree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WordCountTests
{

    static String SOURCE = "one two two three three three four four four four";
    WordCount wordCount = new WordCount();

    @Before
    public void parse()
    {
        this.wordCount = new WordCount();
        String[] words = SOURCE.split("\\W+"); // should take care of
                                               // punctuation and other special
                                               // characters
        for (String word : words)
        {
            this.wordCount.addWord(word);
        }
    }

    @Test
    public void testTopWordCounts()
    {
        List<String> testWords = new ArrayList<>();

        testWords.add("four");
        testWords.add("three");
        
        assertEquals(2, this.wordCount.bottom(2).size());
        assertEquals(testWords, this.wordCount.top(2));
        assertTrue(testWords.containsAll(this.wordCount.top(2)));
    }

    @Test
    public void testBottomWordCounts()
    {
        List<String> testWords = new ArrayList<>();
        testWords.add("one");
        testWords.add("two");
        testWords.add("three");

        assertEquals(3, this.wordCount.bottom(3).size());
        assertEquals(testWords, this.wordCount.bottom(3));
        assertTrue(testWords.containsAll(this.wordCount.bottom(3)));
    }

    @Test
    public void testCountsForIndividualWords()
    {
        assertEquals(1, this.wordCount.count("one"));
        assertEquals(2, this.wordCount.count("two"));
        assertEquals(3, this.wordCount.count("three"));
        assertEquals(4, this.wordCount.count("four"));
    }

}
