package com.tiy.ssa.weektwo.assignmentthree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount
{
    private List<String> allWords = new ArrayList<>();

    private enum Direction
    {
        BOTTOM, TOP
    };

    public void addWord(String word)
    {
        allWords.add(word.toLowerCase());
    }

    public int count(String word)
    {
        int occurrenceOfWord = 0;
        for (String s : allWords)
        {
            if (s.equals(word.toLowerCase()))
            {
                occurrenceOfWord++;
            }
        }

        return occurrenceOfWord;

    }

    public List<String> top(int many)
    {
        return this.getWordSubset(this.getWordCounts(), Direction.TOP, many);
    }

    public List<String> bottom(int many)
    {
        return this.getWordSubset(this.getWordCounts(), Direction.BOTTOM, many);
    }

    private List<String> getWordSubset(Map<String, Integer> wordOccurrences, Direction direction, int many)
    {
        List<String> wordsToReturn = new ArrayList<>();

        for (int i = 0; i < many; i++)
        {
            int wordOccurrence = direction == Direction.BOTTOM ? getMaxWordOccurrence() : getMinWordOccurrence();
            String word = "";

            for (Entry e : wordOccurrences.entrySet())
            {
                switch (direction)
                {
                case BOTTOM:
                    if (((int) e.getValue() <= wordOccurrence))
                    {
                        wordOccurrence = (int) e.getValue();
                        word = String.valueOf(e.getKey());
                    }
                    break;
                case TOP:
                    if (((int) e.getValue() >= wordOccurrence))
                    {
                        wordOccurrence = (int) e.getValue();
                        word = String.valueOf(e.getKey());
                    }
                    break;
                }
            }

            wordsToReturn.add(word);
            wordOccurrences.remove(word);
        }

        return wordsToReturn;

    }

    private Map<String, Integer> getWordCounts()
    {
        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String s : allWords)
        {
            wordOccurrences.putIfAbsent(s, count(s));
        }

        return wordOccurrences;
    }

    private int getMaxWordOccurrence()
    {
        int maxWordOccurrence = 0;

        for (String s : allWords)
        {
            if (this.count(s) >= maxWordOccurrence)
            {
                maxWordOccurrence = count(s);
            }
        }

        return maxWordOccurrence;
    }

    private int getMinWordOccurrence()
    {
        int minWordOccurrence = this.getMaxWordOccurrence();

        for (String s : allWords)
        {
            if (this.count(s) <= minWordOccurrence)
            {
                minWordOccurrence = count(s);
            }
        }

        return minWordOccurrence;
    }

    public String source()
    {
        String source = "";

        for (String s : allWords)
        {
            source += s + " ";
        }

        return source.trim();

    }
}
