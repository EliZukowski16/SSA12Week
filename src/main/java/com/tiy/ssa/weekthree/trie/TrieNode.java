package com.tiy.ssa.weekthree.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TrieNode
{
    private Map<Character, TrieNode> children;
    private Character nodeValue;
    private boolean isWord = false;
    int depth;

    public TrieNode()
    {
        children = new HashMap<>();
        depth = 0;
    }

    public TrieNode(Character c, int depth)
    {
        this.nodeValue = c;
        children = new HashMap<>();
        this.depth = depth;
    }

    public int addWord(String word)
    {
        if (word.isEmpty())
        {
            return depth++;
        }

        if (word.length() == 1)
        {
            nodeValue = word.charAt(0);
            isWord = true;

            return depth;
        }
        else
        {
            nodeValue = word.charAt(0);

            TrieNode child = children.get(word.charAt(1));
            String restOfWord = word.substring(1);

            if (child == null)
            {
                children.put(word.charAt(1), new TrieNode(word.charAt(1), (this.depth + 1)));
                return children.get(word.charAt(1)).addWord(restOfWord);
            }
            else
            {
                return child.addWord(restOfWord);
            }
        }
    }

    public boolean contains(String word)
    {
        if (word.isEmpty())
        {
            return false;
        }

        if (word.length() == 1)
        {
            if (isWord)
                return true;
            return false;
        }

        TrieNode child = children.get(word.charAt(1));
        String restOfWord = word.substring(1);

        if (child != null)
        {
            return children.get(word.charAt(1)).contains(restOfWord);
        }

        return false;

    }

    public boolean remove(String word)
    {
        if (word.isEmpty())
        {
            return false;
        }
        
        if(word.length() == 1)
        {
            isWord = false;
            return true;
        }

        TrieNode child = children.get(word.charAt(1));
        String restOfWord = word.substring(1);

        if (child == null)
        {
            return false;
        }
        else
        {
            return children.get(word.charAt(1)).remove(restOfWord);
        }
    }

    public void clear()
    {
        children = new HashMap<>();
    }

    public List<String> suggest(String word)
    {
        List<String> suggestedWords = new ArrayList<>();
        TrieNode node = getNode(word);
        
        suggestedWords.addAll(collectWords(node, word));
        
        return suggestedWords;
    }
    
    private List<String> collectWords(TrieNode node, String builtWord)
    {
        List<String> words = new ArrayList<>();
        builtWord = builtWord + String.valueOf(nodeValue);
        if(isWord)
        {
            words.add(builtWord);
        }
        
        if(node.children.isEmpty())
        {
            return words;
        }
        else
        {
            for(Entry e : node.children.entrySet())
            {
                TrieNode child = children.get(e.getKey());
                words.addAll(collectWords(child, builtWord));
            }
        }
        
        return words;
    }
    
    private TrieNode getNode(String word)
    {   
        if(word.length() == 1)
        {
            return this;
        }
        else
        {
            TrieNode child = children.get(word.charAt(1));
            String restOfWord = word.substring(1);
            if (child != null)
            {
                return child.getNode(restOfWord);
            }
        }
        
        return null;
    }
}
