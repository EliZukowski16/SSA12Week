package com.tiy.ssa.weektwo.assignmentone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListsTest
{
    List<String> testList1 = new ArrayList<>();
    List<String> testList2 = new ArrayList<>();
    
    @Before
    public void setup()
    {
        testList1.add("a");
        testList1.add("bb");
        testList1.add("ccc");
        testList1.add("dddd");
        testList1.add("bbbbb");
        testList1.add("ddd");
        
        testList2.add("bb");
        testList2.add("ccc");
        testList2.add("ddd");
        testList2.add("dddd");
        testList2.add("bbbb");
        testList2.add("a");
    }
    
    @After
    public void clear()
    {
        testList1.clear();
        testList2.clear();
    }

    @Test
    public void testMergingOfTwoLists()
    {   
        
        List<String> mergedList = Lists.match(testList1, testList2);
        
        assertTrue(testList1.containsAll(mergedList));
        assertTrue(testList2.containsAll(mergedList));
        
        for(String s : testList1)
        {
            if(testList2.contains(s))
            {
                assertTrue(mergedList.contains(s));
            }
            else
            {
                assertFalse(mergedList.contains(s));
            }
        }
        
        for(String s : testList2)
        {
            if(testList1.contains(s))
            {
                assertTrue(mergedList.contains(s));
            }
            else
            {
                assertFalse(mergedList.contains(s));
            }
        }      
    }
    
    @Test
    public void testMergingOfTwoListsWithSets()
    {   
        
        List<String> mergedList = Lists.matchSet(testList1, testList2);
        
        assertTrue(testList1.containsAll(mergedList));
        assertTrue(testList2.containsAll(mergedList));
        
        for(String s : testList1)
        {
            if(testList2.contains(s))
            {
                assertTrue(mergedList.contains(s));
            }
            else
            {
                assertFalse(mergedList.contains(s));
            }
        }
        
        for(String s : testList2)
        {
            if(testList1.contains(s))
            {
                assertTrue(mergedList.contains(s));
            }
            else
            {
                assertFalse(mergedList.contains(s));
            }
        }      
    }
    
    @Test
    public void testSortingOfList()
    {
        List<String> sortedList = Lists.descendingBySize(testList1);
        
        for(int i = 0; i < sortedList.size() - 1; i++)
        {
            assertTrue(sortedList.get(i).length() >= sortedList.get(i + 1).length());
        }
    }

}
