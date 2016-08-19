package com.tiy.ssa.weekthree.trie;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TrieNodeTest
{

    TrieNode testTrie;
    Set<String> dictionary;

    @Before
    public void setup() throws IOException
    {
        testTrie = new TrieNode();
        dictionary = new HashSet<>();

        BufferedReader reader = null;

        try
        {
            reader = Files.newBufferedReader(
                    Paths.get("C:/Users/admin/workspace/SSA12Week/resources/corncob_lowercase.txt"),
                    Charset.defaultCharset());

            String line;

            while (null != (line = reader.readLine()))
            {
                String[] words = line.split("\\W+");
                for (String word : words)
                {
                    if (!word.isEmpty())
                    {
                        this.testTrie.addWord(word);
                        this.dictionary.add(word);
                        assertTrue(testTrie.contains(word));
                    }
                }
            }
        }
        catch (IOException iex)
        {
            System.err.println(iex);
            throw iex;
        }
        finally
        {
            if (null != reader)
                reader.close();
        }
    }

    @Test
    public void testThatClearEmptiesTrie()
    {
        testTrie.clear();

        for (String s : dictionary)
        {
            assertFalse(testTrie.contains(s));
        }
    }

    @Test
    public void testThatRemoveCorrectlyRemovesWord()
    {
        for (String s : dictionary)
        {
            assertTrue(testTrie.contains(s));
            assertTrue(testTrie.remove(s));
            assertFalse(testTrie.contains(s));
            assertFalse(testTrie.remove(s));
        }
    }
    
    @Test
    public void testThatRemoveIsCaseInsensitive()
    {
        for (String s : dictionary)
        {
            assertTrue(testTrie.contains(s.toUpperCase()));
            assertTrue(testTrie.remove(s.toLowerCase()));
            assertFalse(testTrie.contains(s.toLowerCase()));
            assertFalse(testTrie.remove(s.toUpperCase()));
        }
    }
    
    @Test
    public void testThatNoSuggestionsAreReturnedForBlankEntry()
    {
        List<String> suggestions = testTrie.suggest("");
        
        assertEquals(0, suggestions.size());
        
        testTrie.addWord("");
        
        suggestions = testTrie.suggest("");
        
        assertEquals(0, suggestions.size());
    }

    @Test
    public void testThatSuggestionWorksCorrectly()
    {
        for (int i = 0; i < 26; i++)
        {
            List<String> suggestions = testTrie.suggest(String.valueOf('a' + i));
            List<String> subDictionary = new ArrayList<>();

            for (String s : dictionary)
            {
                if (s.startsWith(String.valueOf('a' + i)))
                {
                    subDictionary.add(s);
                }

            }

            subDictionary.sort(Comparator.naturalOrder());

            assertEquals(subDictionary, suggestions);

        }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                List<String> suggestions = testTrie.suggest(String.valueOf(i) + String.valueOf(j));
                List<String> subDictionary = new ArrayList<>();

                for (String s : dictionary)
                {
                    if (s.startsWith(String.valueOf('a' + i) + String.valueOf('a' + i)))
                    {
                        subDictionary.add(s);
                    }
                }

                subDictionary.sort(Comparator.naturalOrder());

                assertEquals(subDictionary, suggestions);
            }
        }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                for (int h = 0; h < 10; h++)
                {
                    List<String> suggestions = testTrie
                            .suggest(String.valueOf('a' + i) + String.valueOf('a' + j) + String.valueOf('a' + h));
                    List<String> subDictionary = new ArrayList<>();

                    for (String s : dictionary)
                    {

                        if (s.startsWith(String.valueOf('a' + i) + String.valueOf('a' + j) + String.valueOf('a' + h)))
                        {
                            subDictionary.add(s);
                        }

                    }

                    subDictionary.sort(Comparator.naturalOrder());

                    assertEquals(subDictionary, suggestions);
                }
            }
        }
    }

}
