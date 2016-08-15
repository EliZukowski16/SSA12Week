package com.tiy.ssa.weekthree.day1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DecoratorSSAMapTest
{

    DecoratorSSAMap<String, Integer> testMap;

    @Before
    public void setup()
    {
        testMap = new DecoratorSSAMap<>();
    }

    @Test
    public void testSSAMapContainsByKey()
    {
        testMap.put("Test 1", 1);
        assertEquals(1, (int) testMap.get("Test 1"));

        assertTrue(testMap.containsKey("Test 1"));
        assertFalse(testMap.containsKey("Test 2"));
    }

    @Test
    public void testSSAMapContainsByValue()
    {
        testMap.put("Test 1", 1);

        assertTrue(testMap.containsValue(1));
        assertFalse(testMap.containsValue(2));
    }

    @Test
    public void testSSAMapGetOrDefault()
    {
        testMap.put("Test 1", 1);

        assertEquals(1, (int) testMap.getOrDefault("Test 1", 0));
        assertEquals(0, (int) testMap.getOrDefault("Test 2", 0));
    }

    @Test
    public void testSSAMapSize()
    {
        assertEquals(0, testMap.size());

        testMap.put("Test 1", 1);

        assertEquals(1, testMap.size());

        testMap.put("Test 2", 2);

        assertEquals(2, testMap.size());
    }

    @Test
    public void testSSAMapIsEmpty()
    {
        assertTrue(testMap.isEmpty());

        testMap.put("Test 1", 1);

        assertFalse(testMap.isEmpty());

        testMap.put("Test 2", 2);

        assertFalse(testMap.isEmpty());
    }

    @Test
    public void testSSAMapClear()
    {
        testMap.put("Test 1", 1);
        testMap.put("Test 2", 2);
        testMap.clear();

        assertEquals(0, testMap.size());
        assertEquals(null, testMap.get("Test 1"));
        assertEquals(null, testMap.get("Test 2"));
    }

    @Test
    public void testSSAMapSetOfKeys()
    {
        Set<String> keySet = new HashSet<>();
        keySet.add("Test 1");
        keySet.add("Test 2");
        keySet.add("Test 3");
        
        testMap.put("Test 1", 1);
        testMap.put("Test 2", 2);
        testMap.put("Test 3", 3);
        
        assertEquals(keySet, testMap.keySet());
    }
    
    @Test
    public void testSSAMapReplace()
    {
        testMap.put("Test 1", 1);
        testMap.put("Test 2", 2);
        
        assertTrue(testMap.containsKey("Test 1"));
        
        assertEquals(1, (int) testMap.remove("Test 1"));
        
        assertEquals(null, testMap.remove("Test 1"));
    }
    
    @Test
    public void testSSAMapValues()
    {
        testMap.put("Test 1", 1);
        testMap.put("Test 2", 2);
        testMap.put("Test 3", 3);
        
        List<Integer> valueList = new ArrayList<>();
        valueList.add(1);
        valueList.add(2);
        valueList.add(3);
        
        assertTrue(testMap.values().contains(1));
        assertTrue(testMap.values().contains(2));
        assertTrue(testMap.values().contains(3));
        assertEquals(3, testMap.values().size());
    }
    
    public void testSSAMapPutAll()
    {
        Map<String, Integer> testMap2 = new HashMap<>();
        
        testMap2.put("Test 1", 1);
        testMap2.put("Test 2", 2);
        testMap2.put("Test 3", 3);
        
        assertTrue(testMap.isEmpty());
        
        testMap.putAll(testMap2);
        
        assertFalse(testMap.isEmpty());
        assertEquals(3, testMap.size());
        assertTrue(testMap.containsKey("Test 1"));
        assertTrue(testMap.containsKey("Test 2"));
        assertTrue(testMap.containsKey("Test 3"));
        assertTrue(testMap.containsValue(1));
        assertTrue(testMap.containsValue(2));
        assertTrue(testMap.containsValue(3));
        
        assertEquals(1, (int) testMap.get("Test 1"));
        assertEquals(2, (int) testMap.get("Test 2"));
        assertEquals(3, (int) testMap.get("Test 3"));
    }

}
