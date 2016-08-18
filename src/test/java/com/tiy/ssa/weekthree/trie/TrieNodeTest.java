package com.tiy.ssa.weekthree.trie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrieNodeTest
{

    TrieNode testTrie;
    
    @Before
    public void setup()
    {
        testTrie = new TrieNode();
    }
    
    @Test
    public void test()
    {
        assertEquals(0, testTrie.addWord(""));
        assertEquals(1, testTrie.addWord("a"));
        assertEquals(2, testTrie.addWord("ab"));
        assertEquals(3, testTrie.addWord("abc"));
        assertEquals(3, testTrie.addWord("ccc"));
        assertTrue(testTrie.contains("a"));
        assertTrue(testTrie.contains("ab"));
        assertTrue(testTrie.contains("abc"));
        assertFalse(testTrie.contains("ad"));
        assertFalse(testTrie.contains(""));
        
        assertTrue(testTrie.remove("ab"));
        assertFalse(testTrie.contains("ab"));
        
        System.out.println(testTrie.suggest("ab"));
    }

}
