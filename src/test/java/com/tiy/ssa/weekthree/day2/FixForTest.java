package com.tiy.ssa.weekthree.day2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class FixForTest
{
    
    Iterator<String> iOverString;
    static Logger LOGGER = LogManager.getLogger();

    @Test
    public void test()
    {
        iOverString = Arrays.asList("It's", "the", "end").iterator();
        for(String s : new FixFor<>(iOverString))
            LOGGER.info(s);
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
            LOGGER.info(s);
        }
        
        keys.add("potato");
        
    }

}
