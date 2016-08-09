package com.tiy.ssa.weektwo.assignmentone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lists
{
    public static <T> List<T> match(List<T> one, List<T> other)
    {     
        List<T> mergedList = new ArrayList<>();
        
        for(T t : one)
        {
            if(one.contains(t) && other.contains(t) && !(mergedList.contains(t)))
            {
                mergedList.add(t);
            }
        }
        
        return mergedList;
        
    }
    
    public static List<String> descendingBySize(List<String> input)
    {
        List<String> sortedList = new ArrayList<>();
        
        for(String s : input)
        {
            for(int i = 0; i <= sortedList.size(); i++)
            {
                if(sortedList.size() == 0)
                {
                    sortedList.add(s);
                    break;
                }
                
                if(s.length() > sortedList.get(i).length())
                {
                    sortedList.add(i, s);
                    break;
                }
                
                if(i == sortedList.size())
                {
                    sortedList.add(s);
                    break;
                }
            }
        }
        
        return sortedList;
    }

}
