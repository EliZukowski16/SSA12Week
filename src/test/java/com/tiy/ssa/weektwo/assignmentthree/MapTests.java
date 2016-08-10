package com.tiy.ssa.weektwo.assignmentthree;

import com.tiy.ssa.weektwo.assignmenttwo.Name;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class MapTests
{

    @Test
    public void initial()
    {
//        SocialSecurityNumber testSSN = new SocialSecurityNumber("123456789");
        Name testName = new Name("John", "Smith");
        
        Map<SocialSecurityNumber, Name> map = new HashMap<>();
        map.put(new SocialSecurityNumber("123456789"), new Name("John", "Smith"));
//        testSSN = new SocialSecurityNumber("123456788");
        map.put(new SocialSecurityNumber("123456788"), new Name("Bob", "Smith"));
        
        
        
        assertEquals(new Name("Bob", "Smith"), map.get(new SocialSecurityNumber("123456788")));
        
        for(Entry entry : map.entrySet())
        {
            System.out.println(entry.getKey().hashCode());
        }
        
        
    }

}
