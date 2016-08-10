package com.tiy.ssa.weektwo.assignmentthree;

import java.util.ArrayList;
import java.util.List;

public class WordCount
{
    
    List<String> allWords = new ArrayList<>();

    /**
     * 
     * @param word
     *            callers are responsible for ensuring <code>word</code> <br>
     *            is an actual word, parsing is done by the caller
     */
    public void addWord(String word)
    {
        allWords.add(word.toLowerCase());
    }

    public int count(String word)
    {
        int occurrenceOfWord = 0;
        for(String s : allWords)
        {
            if(s.equals(word.toLowerCase()))
            {
                occurrenceOfWord++;
            }
        }
        
        return occurrenceOfWord;

    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in descending poularity order, so
     *         top <code>many</code> words
     */
    public List<String> top(int many)
    {
        List<String> topWords = new ArrayList<>();
        List<Integer> occurrenceOfWords = new ArrayList<>();
        
        List<String> wordsToReturn = new ArrayList<>();
       
        for(String s : allWords)
        {
            if(!(topWords.contains(s)))
            {
                topWords.add(s);
                occurrenceOfWords.add(this.count(s));
            }
        }
        
        for(int i = 0; i < many; i++)
        {
            int occurrenceOfWord = 0;
            int indexOfWord = 0;
            
            for(int j = 0; j < topWords.size(); j++)
            {
                if(occurrenceOfWords.get(j) >= occurrenceOfWord)
                {
                    occurrenceOfWord = occurrenceOfWords.get(j);
                    indexOfWord = j;
                }
            }
            
            wordsToReturn.add(topWords.get(indexOfWord));
            occurrenceOfWords.remove(indexOfWord);
            topWords.remove(indexOfWord);
        }
        
        return wordsToReturn;
        

    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in ascending least popularity
     *         order, so bottom <code>many</code> words
     */
    public List<String> bottom(int many)
    {
        List<String> bottomWords = new ArrayList<>();
        List<Integer> occurrenceOfWords = new ArrayList<>();
        
        List<String> wordsToReturn = new ArrayList<>();
       
        for(String s : allWords)
        {
            if(!(bottomWords.contains(s)))
            {
                bottomWords.add(s);
                occurrenceOfWords.add(this.count(s));
            }
        }
        
        for(int i = 0; i < many; i++)
        {
            int occurrenceOfWord = this.getMaxWordOccurrence();
            int indexOfWord = 0;
            
            for(int j = 0; j < bottomWords.size(); j++)
            {
                if(occurrenceOfWords.get(j) <= occurrenceOfWord)
                {
                    occurrenceOfWord = occurrenceOfWords.get(j);
                    indexOfWord = j;
                }
            }
            
            wordsToReturn.add(bottomWords.get(indexOfWord));
            occurrenceOfWords.remove(indexOfWord);
            bottomWords.remove(indexOfWord);
        }
        
        return wordsToReturn;

    }
    
    private int getMaxWordOccurrence()
    {
        int maxWordOccurrence = 0;
        
        for(String s : allWords)
        {
            if(this.count(s) >= maxWordOccurrence)
            {
                maxWordOccurrence = count(s);
            }
        }
        
        return maxWordOccurrence;
    }

    /**
     *
     * @return the input that is being word counted (maintaining the order
     *         prescribed by {@link #addWord(String) }
     * @see #addWord(String)
     */
    public String source()
    {
        String source = "";
        
        for(String s : allWords)
        {
            source += s;
        }
        
        return source;

    }
}
