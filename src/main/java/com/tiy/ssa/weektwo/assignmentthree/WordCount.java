package com.tiy.ssa.weektwo.assignmentthree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;



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

    private Map<String, Integer> getWordCounts()
    {
        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String s : allWords)
        {
            wordOccurrences.putIfAbsent(s, count(s));
        }

        return wordOccurrences;
    }
    
    private Map<String, Integer> sortWords(Map<String, Integer> wordOccurrences, Direction direction)
    {
        Map<String, Integer> sortedWords = new LinkedHashMap<>();
        Stream<Map.Entry<String, Integer>> wordStream = wordOccurrences.entrySet().stream();
        
        if(direction == Direction.TOP)
        {
            wordStream.sorted(Map.Entry.comparingByValue((Comparator.reverseOrder())))
            .forEachOrdered(e -> sortedWords.put(e.getKey(), e.getValue()));
        }
        else
        {
            wordStream.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                    .forEachOrdered(e -> sortedWords.put(e.getKey(), e.getValue()));
        }
        
        return sortedWords;
    }
    
    public List<String> top(int many)
    {
        List<String> sortedWords = new ArrayList<>();
        Map<String, Integer> sortedMap = sortWords(getWordCounts(), Direction.TOP);
        
        Iterator<Entry<String, Integer>> wordIterator = sortedMap.entrySet().iterator();
        
        for(int i = 0; i < many; i++)
        {
            sortedWords.add(wordIterator.next().getKey());
        }
        
        return sortedWords;
    }
    
    public List<String> bottom(int many)
    {
        List<String> sortedWords = new ArrayList<>();
        Map<String, Integer> sortedMap = sortWords(getWordCounts(), Direction.BOTTOM);
        
        Iterator<Entry<String, Integer>> wordIterator = sortedMap.entrySet().iterator();
        
        for(int i = 0; i < many; i++)
        {
            sortedWords.add(wordIterator.next().getKey());
        }
        
        return sortedWords;
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
