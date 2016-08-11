package com.tiy.ssa.weektwo.assignmentfour;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;
import com.tiy.ssa.weektwo.assignmenttwo.Name;

public class RegistryTest
{
    Registry testRegistry = new Registry();
    
    Person testPersonOne = new Person(new Name("John", "Smith"), new SocialSecurityNumber("123456789"));
    Person testPersonTwo = new Person(new Name("Bob", "Smith"), new SocialSecurityNumber("123456788"));
    Person testPersonThree = new Person(new Name("Sam", "Smith"), new SocialSecurityNumber("123456787"));
    Person testPersonFour = new Person(new Name("Joe", "Smith"), new SocialSecurityNumber("123456786"));
    Person testPersonFive = new Person(new Name("Greg", "Smith"), new SocialSecurityNumber("123456785"));
    Person testPersonSix = new Person(new Name("Mary", "Smith"), new SocialSecurityNumber("123456784"));
    
    
    @Test
    public void testOne()
    {
        testPersonOne.addChild(testPersonTwo);
        testPersonTwo.addChild(testPersonThree);
        testPersonThree.addChild(testPersonFour);
        testPersonFive.addChild(testPersonFour);
        testPersonSix.addChild(testPersonThree);
        testRegistry.add(testPersonOne);
        testRegistry.add(testPersonTwo);
        testRegistry.add(testPersonThree);
        testRegistry.add(testPersonFour);
        testRegistry.add(testPersonFive);
        testRegistry.add(testPersonSix);

        List<Person> ancestors = testRegistry.ancestors(testPersonFour.getSsn());

        for (Person p : ancestors)
        {
            System.out.println(p.getName().getFirst());
        }
        
        assertFalse(ancestors.contains(testPersonFour));
        assertTrue(ancestors.contains(testPersonThree));
        assertTrue(ancestors.contains(testPersonTwo));
        assertTrue(ancestors.contains(testPersonOne));
        assertTrue(ancestors.contains(testPersonFive));
        assertTrue(ancestors.contains(testPersonSix));

    }
    




}
