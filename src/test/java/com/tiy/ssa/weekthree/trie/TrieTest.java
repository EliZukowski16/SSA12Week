package com.tiy.ssa.weekthree.trie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class TrieTest
{

    T9Trie text9Trie;
    static Set<String> dictionary;
    static List<char[]> t9;
    static Map<String, List<String>> subDictionaryThreeDigits;
    static Map<String, List<String>> subDictionaryTwoDigits;
    static Map<String, List<String>> subDictionaryOneDigit;
    
    @BeforeClass
    public static void setupBeforeClass() throws IOException
    {
        t9 = new ArrayList<>();

        t9.add(0, new char[]
        {});
        t9.add(1, new char[]
        {});
        t9.add(2, new char[]
        { 'a', 'b', 'c' });
        t9.add(3, new char[]
        { 'd', 'e', 'f' });
        t9.add(4, new char[]
        { 'g', 'h', 'i' });
        t9.add(5, new char[]
        { 'j', 'k', 'l' });
        t9.add(6, new char[]
        { 'm', 'n', 'o' });
        t9.add(7, new char[]
        { 'p', 'q', 'r', 's' });
        t9.add(8, new char[]
        { 't', 'u', 'v' });
        t9.add(9, new char[]
        { 'w', 'x', 'y', 'z' });
        
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
                        dictionary.add(word);
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
        
        subDictionaryOneDigit = new HashMap<>();
        subDictionaryTwoDigits = new HashMap<>();
        subDictionaryThreeDigits = new HashMap<>();
        String prefix;
        
        for (int i = 0; i < 10; i++)
        {
            List<String> subDictionary = new ArrayList<>();

            for (String s : dictionary)
            {
                for (Character c : t9.get(i))
                {
                    if (s.startsWith(String.valueOf(c)))
                    {
                        subDictionary.add(s);
                    }
                }
            }

            prefix = String.valueOf(i);

            subDictionary.sort(Comparator.naturalOrder());
            
            subDictionaryOneDigit.put(prefix, subDictionary);

        }
        
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                List<String> subDictionary = new ArrayList<>();

                for (String s : dictionary)
                {
                    for (Character c : t9.get(i))
                    {
                        for (Character d : t9.get(j))
                        {
                            if (s.startsWith(String.valueOf(c) + String.valueOf(d)))
                            {
                                subDictionary.add(s);
                            }
                        }
                    }
                }

                prefix = String.valueOf(i) + String.valueOf(j);

                subDictionary.sort(Comparator.naturalOrder());
                
                subDictionaryTwoDigits.put(prefix, subDictionary);
            }
        }
        
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                for (int h = 0; h < 10; h++)
                {
                    
                    List<String> subDictionary = new ArrayList<>();

                    for (String s : dictionary)
                    {
                        for (Character c : t9.get(i))
                        {
                            for (Character d : t9.get(j))
                            {
                                for (Character e : t9.get(h))
                                {
                                    if (s.startsWith(String.valueOf(c) + String.valueOf(d) + String.valueOf(e)))
                                    {
                                        subDictionary.add(s);
                                    }
                                }
                            }
                        }
                    }
                    prefix = String.valueOf(i) + String.valueOf(j) + String.valueOf(h);

                    subDictionary.sort(Comparator.naturalOrder());
                    
                    subDictionaryThreeDigits.put(prefix, subDictionary);

                }
            }
        }
    }

    @Before
    public void setup() throws IOException
    {
        text9Trie = new T9Trie();
        for(String s : dictionary)
        {
            text9Trie.addWord(s);
            assertTrue(text9Trie.contains(s));
        }
        
    }

    @Test
    public void testThatClearEmptiesTrie()
    {
        text9Trie.clear();

        for (String s : dictionary)
        {
            assertFalse(text9Trie.contains(s));
        }
    }

    @Test
    public void testThatRemoveCorrectlyRemovesWord()
    {
        for (String s : dictionary)
        {
            assertTrue(text9Trie.contains(s));
            assertTrue(text9Trie.remove(s));
            assertFalse(text9Trie.contains(s));
            assertFalse(text9Trie.remove(s));
        }
    }

    @Test
    public void testThatRemoveIsCaseInsensitive()
    {
        for (String s : dictionary)
        {
            assertTrue(text9Trie.contains(s.toUpperCase()));
            assertTrue(text9Trie.remove(s.toLowerCase()));
            assertFalse(text9Trie.contains(s.toLowerCase()));
            assertFalse(text9Trie.remove(s.toUpperCase()));
        }
    }

    @Test
    public void testThatNoSuggestionsAreReturnedForBlankEntry()
    {
        List<String> suggestions = text9Trie.suggest("");

        assertEquals(0, suggestions.size());

        text9Trie.addWord("");

        suggestions = text9Trie.suggest("");

        assertEquals(0, suggestions.size());
    }

    @Test
    public void testThatNoSuggestionsAreReturnedForBadEntry()
    {
        List<String> suggestions = text9Trie.suggest("a");

        assertEquals(0, suggestions.size());

        suggestions = text9Trie.suggest("<>{}?/@$$");

        assertEquals(0, suggestions.size());
    }

    @Test
    public void testThatSuggestionWorksCorrectlyForOneDigit()
    {
        for(Entry<String, List<String>> e : subDictionaryOneDigit.entrySet())
        {
            assertEquals(e.getValue(), text9Trie.suggest(e.getKey()));
        }
        
//        for (int i = 0; i < 10; i++)
//        {
//            List<String> suggestions = text9Trie.suggest(String.valueOf(i));
//            List<String> subDictionary = new ArrayList<>();
//
//            for (String s : dictionary)
//            {
//                for (Character c : t9.get(i))
//                {
//                    if (s.startsWith(String.valueOf(c)))
//                    {
//                        subDictionary.add(s);
//                    }
//                }
//            }
//
//            subDictionary.sort(Comparator.naturalOrder());
//
//            assertEquals(subDictionary, suggestions);
//
//        }
    }

    @Test
    public void testThatSuggestionWorksCorrectlyForTwoDigits()
    {
        for(Entry<String, List<String>> e : subDictionaryTwoDigits.entrySet())
        {
            assertEquals(e.getValue(), text9Trie.suggest(e.getKey()));
        }
        
//        for (int i = 0; i < 10; i++)
//        {
//            for (int j = 0; j < 10; j++)
//            {
//                List<String> suggestions = text9Trie.suggest(String.valueOf(i) + String.valueOf(j));
//                List<String> subDictionary = new ArrayList<>();
//
//                for (String s : dictionary)
//                {
//                    for (Character c : t9.get(i))
//                    {
//                        for (Character d : t9.get(j))
//                        {
//                            if (s.startsWith(String.valueOf(c) + String.valueOf(d)))
//                            {
//                                subDictionary.add(s);
//                            }
//                        }
//                    }
//                }
//
//                subDictionary.sort(Comparator.naturalOrder());
//
//                assertEquals(subDictionary, suggestions);
//            }
//        }
    }

    @Test
    public void testThatSuggestionWorksCorrectlyForThreeDigits()
    {
        for(Entry<String, List<String>> e : subDictionaryThreeDigits.entrySet())
        {
            assertEquals(e.getValue(), text9Trie.suggest(e.getKey()));
        }
        
//        for (int i = 0; i < 10; i++)
//        {
//            for (int j = 0; j < 10; j++)
//            {
//                for (int h = 0; h < 10; h++)
//                {
//                    List<String> suggestions = text9Trie
//                            .suggest(String.valueOf(i) + String.valueOf(j) + String.valueOf(h));
//                    List<String> subDictionary = new ArrayList<>();
//
//                    for (String s : dictionary)
//                    {
//                        for (Character c : t9.get(i))
//                        {
//                            for (Character d : t9.get(j))
//                            {
//                                for (Character e : t9.get(h))
//                                {
//                                    if (s.startsWith(String.valueOf(c) + String.valueOf(d) + String.valueOf(e)))
//                                    {
//                                        subDictionary.add(s);
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    subDictionary.sort(Comparator.naturalOrder());
//
//                    assertEquals(subDictionary, suggestions);
//                }
//            }
//        }
    }
}
