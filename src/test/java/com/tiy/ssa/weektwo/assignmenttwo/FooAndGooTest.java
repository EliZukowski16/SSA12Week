package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FooAndGooTest
{
    Set<Foo> foo = new HashSet<>();
    Set<Goo> goo = new HashSet<>();
    
    
    @Test
    public void testFoo()
    {
        Foo fooOne = new Foo("Test");
        Foo fooTwo = new Foo("Test");
        
        System.out.println(fooOne);
        System.out.println(fooTwo);
        
        assertTrue(foo.add(fooOne));
        assertTrue(foo.add(fooTwo));
    }
    
    
    @Test
    public void testGoo()
    {
        Goo gooOne = new Goo("Test");
        Goo gooTwo = new Goo("Test");
        
        System.out.println(gooOne);
        System.out.println(gooTwo);
        
        assertTrue(goo.add(gooOne));
        assertFalse(goo.add(gooTwo));
    }
 

}
