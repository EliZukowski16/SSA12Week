package com.tiy.ssa.weektwo.assignmentone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
        
        for(int i = 0; i < mergedList.size(); i++)
        {
            for(int j = 0; j < mergedList.size(); j++)
            {
                if(i == j)
                {
                    assertTrue(mergedList.get(i).equals(mergedList.get(j)));
                }
                else
                {
                    assertFalse(mergedList.get(i).equals(mergedList.get(j)));
                }
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
        
        for(int i = 0; i < mergedList.size(); i++)
        {
            for(int j = 0; j < mergedList.size(); j++)
            {
                if(i == j)
                {
                    assertTrue(mergedList.get(i).equals(mergedList.get(j)));
                }
                else
                {
                    assertFalse(mergedList.get(i).equals(mergedList.get(j)));
                }
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
    
    @Test
    public void testSets()
    {
        Collection<Integer> s1 = new HashSet<>();
        Collection<Integer> s2 = new HashSet<>();
        
        s1.add(1);
        s1.add(2);
        s1.add(3);
        
        s2.add(3);
        s2.add(2);
        s2.add(1);
        
        assertTrue(s1.equals(s2));
        
        Collection<Integer> l1 = new ArrayList<>();
        Collection<Integer> l2 = new ArrayList<>();
        
        l1.add(1);
        l1.add(2);
        l1.add(3);
        
        l2.add(3);
        l2.add(2);
        l2.add(1);
        
        assertFalse(l1.equals(l2));
    }

}
