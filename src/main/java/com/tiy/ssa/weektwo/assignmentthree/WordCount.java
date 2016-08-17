package com.tiy.ssa.weektwo.assignmentthree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WordCount
{
    private List<String> allWords = new ArrayList<>();
    private Map<String, Integer> wordMap = new HashMap<>();

    public void addWord(String word)
    {
        allWords.add(word.toLowerCase());

        if (wordMap.get(word.toLowerCase()) != null)
        {
            Integer count = wordMap.get(word.toLowerCase());
            wordMap.put(word.toLowerCase(), ++count);
        }
        else
        {
            wordMap.put(word.toLowerCase(), 1);
        }
    }

    public int count(String word)
    {
        if (wordMap.get(word.toLowerCase()) != null)
        {
            return wordMap.get(word.toLowerCase());
        }

        return 0;

    }

    public List<String> top(int many)
    {

        return wordMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(many)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> bottom(int many)
    {

        return wordMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .limit(many)
                .map(Entry::getKey)
                .collect(Collectors.toList());
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
