package com.tiy.ssa.weekthree.day2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FixForTest
{
    
    Iterator<String> iOverString;

    @Test
    public void test()
    {
        iOverString = Arrays.asList("It's", "the", "end").iterator();
        for(String s : new FixFor<>(iOverString))
            System.out.println(s);
    }
    
    @Test
    public void setTest()
    {
        Map<String, Integer> testMap = new HashMap<>();
        
        testMap.put("One", 1);
        testMap.put("Two", 2);
        testMap.put("Three", 3);
        
        Set<String> keys = testMap.keySet();
        
        for(String s : keys)
        {
            System.err.println(s);
        }
        
        keys.add("potato");
        
    }

}
