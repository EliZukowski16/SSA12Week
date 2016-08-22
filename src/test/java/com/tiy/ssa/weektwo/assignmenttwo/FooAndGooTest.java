package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class FooAndGooTest
{
    Set<Foo> foo = new HashSet<>();
    Set<Goo> goo = new HashSet<>();
    
    static Logger LOGGER = LogManager.getLogger();
    
    
    @Test
    public void testFoo()
    {
        Foo fooOne = new Foo("Test");
        Foo fooTwo = new Foo("Test");
        
        LOGGER.info("fooOne HashCode: {}", fooOne.hashCode());
        LOGGER.info("fooTwo HashCode: {}", fooTwo.hashCode());
        
        assertTrue(foo.add(fooOne));
        assertTrue(foo.add(fooTwo));
    }
    
    
    @Test
    public void testGoo()
    {
        Goo gooOne = new Goo("Test");
        Goo gooTwo = new Goo("Test");
        
        LOGGER.info("gooOne HashCode: {}", gooOne.hashCode());
        LOGGER.info("gooTwo HashCode: {}", gooTwo.hashCode());
        
        assertTrue(goo.add(gooOne));
        assertFalse(goo.add(gooTwo));
    }
 

}
