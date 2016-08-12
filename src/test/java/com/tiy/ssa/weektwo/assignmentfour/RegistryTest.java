package com.tiy.ssa.weektwo.assignmentfour;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;
import com.tiy.ssa.weektwo.assignmenttwo.Name;

public class RegistryTest
{
    Registry testRegistry;
    
    Person testPersonProgenitor;
    Person testPerson1stGenOne;
    Person testPerson1stGenTwo;
    Person testPerson1stGenThree;
    Person testPerson2ndGenOne;
    Person testPerson2ndGenTwo;
    Person testPerson2ndGenThree;
    Person testPerson3rdGenOne;
    Person testPerson3rdGenTwo;
    Person testPerson3rdGenThree;
    Person testPersonYoungest;
    
    @Before
    public void setup()
    {
        testRegistry = new Registry();
        
        testPersonProgenitor = new Person(new Name("Adam", "Smith"), new SocialSecurityNumber("000-000-0001"));
        testPerson1stGenOne = new Person(new Name("Andrew", "Jones"), new SocialSecurityNumber("000-001-0001"));
        testPerson1stGenTwo = new Person(new Name("Bridget", "Jones"), new SocialSecurityNumber("000-001-0002"));
        testPerson1stGenThree = new Person(new Name("Chris", "Jones"), new SocialSecurityNumber("000-001-0003"));
        testPerson2ndGenOne = new Person(new Name("Alice", "Thompson"), new SocialSecurityNumber("000-002-0001"));
        testPerson2ndGenTwo = new Person(new Name("Bob", "Thompson"), new SocialSecurityNumber("000-002-0002"));
        testPerson2ndGenThree = new Person(new Name("Claire", "Thompson"), new SocialSecurityNumber("000-002-0003"));
        testPerson3rdGenOne = new Person(new Name("Alfonso", "Robinson"), new SocialSecurityNumber("000-003-0001"));
        testPerson3rdGenTwo = new Person(new Name("Betty", "Robinson"), new SocialSecurityNumber("000-003-0001"));
        testPersonYoungest = new Person(new Name("Amy", "Miller"), new SocialSecurityNumber("000-004-0001"));
        
//        testRegistry.add(testPersonProgenitor);
//        testRegistry.add(testPerson1stGenOne);
//        testRegistry.add(testPerson1stGenTwo);
//        testRegistry.add(testPerson1stGenThree);
//        testRegistry.add(testPerson2ndGenOne);
//        testRegistry.add(testPerson2ndGenTwo);
//        testRegistry.add(testPerson2ndGenThree);
//        testRegistry.add(testPerson3rdGenOne);
//        testRegistry.add(testPerson3rdGenTwo);
//        testRegistry.add(testPerson3rdGenThree);
//        testRegistry.add(testPersonProgenitor);
       
    }
    
    @After
    public void tearDown()
    {
        
    }
    
    
    @Test
    public void testCanAddAndGetPersonFromRegistry()
    {
        assertTrue(testRegistry.add(testPersonProgenitor));
        assertFalse(testRegistry.add(testPersonProgenitor));
        assertEquals(testRegistry.get(testPersonProgenitor.getSsn()), testPersonProgenitor);     
    }
    
    @Test
    public void testThatChildrenGetAddedToPeopleCorrectly()
    {
        testPersonProgenitor.addChild(testPerson1stGenOne);
        
        assertTrue(testPersonProgenitor.getChildren().contains(testPerson1stGenOne));
        assertFalse(testPersonProgenitor.getChildren().contains(testPerson1stGenTwo));
        
        List<Person> testChildren = new ArrayList<>();
        
        testChildren.add(testPerson1stGenTwo);
        testChildren.add(testPerson1stGenThree);
        testChildren.add(testPerson1stGenOne);
        
        assertEquals(2, testPersonProgenitor.addChildren(testChildren));
        assertTrue(testPersonProgenitor.getChildren().containsAll(testChildren));
        
    }
    




}
