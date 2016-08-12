package com.tiy.ssa.weektwo.assignmentfour;
//package com.tiy.ssa.weektwo.assignmentfour;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;
//import com.tiy.ssa.weektwo.assignmenttwo.Name;
//
//public class RegistryTest
//{
//    Registry testRegistry;
//    
//    Person testPersonProgenitor;
//    Person testPerson1stGenOne;
//    Person testPerson1stGenTwo;
//    Person testPerson1stGenThree;
//    Person testPerson2ndGenOne;
//    Person testPerson2ndGenTwo;
//    Person testPerson2ndGenThree;
//    Person testPerson3rdGenOne;
//    Person testPerson3rdGenTwo;
//    Person testPerson3rdGenThree;
//    Person testPersonYoungest;
//    
//    List<Person> all1stGenPersons = new ArrayList<>();
//    List<Person> all2ndGenPersons = new ArrayList<>();
//    List<Person> all3rdGenPersons = new ArrayList<>();
//    
//    @Before
//    public void setup()
//    {
//        testRegistry = new Registry();
//        
//        testPersonProgenitor = new Person(new Name("Adam", "Andrews"), new SocialSecurityNumber("000-000-0001"));
//        testPerson1stGenOne = new Person(new Name("Andrew", "Bastille"), new SocialSecurityNumber("000-001-0001"));
//        testPerson1stGenTwo = new Person(new Name("Bridget", "Bastille"), new SocialSecurityNumber("000-001-0002"));
//        testPerson1stGenThree = new Person(new Name("Chris", "Bastille"), new SocialSecurityNumber("000-001-0003"));
//        testPerson2ndGenOne = new Person(new Name("Alice", "Clearwater"), new SocialSecurityNumber("000-002-0001"));
//        testPerson2ndGenTwo = new Person(new Name("Bob", "Clearwater"), new SocialSecurityNumber("000-002-0002"));
//        testPerson2ndGenThree = new Person(new Name("Claire", "Clearwater"), new SocialSecurityNumber("000-002-0003"));
//        testPerson3rdGenOne = new Person(new Name("Alfonso", "Davis"), new SocialSecurityNumber("000-003-0001"));
//        testPerson3rdGenTwo = new Person(new Name("Betty", "Davis"), new SocialSecurityNumber("000-003-0002"));
//        testPerson3rdGenThree = new Person(new Name("Carmelo", "Davis"), new SocialSecurityNumber("000-003-0003"));
//        testPersonYoungest = new Person(new Name("Amy", "Ellis"), new SocialSecurityNumber("000-004-0001"));
//        
//        all1stGenPersons.add(testPerson1stGenOne);
//        all1stGenPersons.add(testPerson1stGenTwo);
//        all1stGenPersons.add(testPerson1stGenThree);
//        
//        all2ndGenPersons.add(testPerson2ndGenOne);
//        all2ndGenPersons.add(testPerson2ndGenTwo);
//        all2ndGenPersons.add(testPerson2ndGenThree);
//        
//        all3rdGenPersons.add(testPerson3rdGenOne);
//        all3rdGenPersons.add(testPerson3rdGenTwo);
//        all3rdGenPersons.add(testPerson3rdGenThree);
//        
////        testRegistry.add(testPersonProgenitor);
////        testRegistry.add(testPerson1stGenOne);
////        testRegistry.add(testPerson1stGenTwo);
////        testRegistry.add(testPerson1stGenThree);
////        testRegistry.add(testPerson2ndGenOne);
////        testRegistry.add(testPerson2ndGenTwo);
////        testRegistry.add(testPerson2ndGenThree);
////        testRegistry.add(testPerson3rdGenOne);
////        testRegistry.add(testPerson3rdGenTwo);
////        testRegistry.add(testPerson3rdGenThree);
////        testRegistry.add(testPersonProgenitor);
//       
//    }
//    
//    @After
//    public void tearDown()
//    {
//        
//    }
//    
//    
//    @Test
//    public void testCanAddAndGetPersonToRegistry()
//    {
//        assertEquals(null, testRegistry.get(testPersonProgenitor.getSsn()));
//        assertTrue(testRegistry.add(testPersonProgenitor));
//        assertFalse(testRegistry.add(testPersonProgenitor));
//        assertEquals(testRegistry.get(testPersonProgenitor.getSsn()), testPersonProgenitor);     
//    }
//    
//    @Test
//    public void testThatChildrenGetAddedToPeopleCorrectly()
//    {
//        testPersonProgenitor.addChild(testPerson1stGenOne);
//        
//        assertTrue(testPersonProgenitor.getChildren().contains(testPerson1stGenOne));
//        assertFalse(testPersonProgenitor.getChildren().contains(testPerson1stGenTwo));
//        
//        List<Person> testChildren = new ArrayList<>();
//        
//        testChildren.add(testPerson1stGenTwo);
//        testChildren.add(testPerson1stGenThree);
//        testChildren.add(testPerson1stGenOne);
//        
//        assertEquals(2, testPersonProgenitor.addChildren(testChildren));
//        assertTrue(testPersonProgenitor.getChildren().containsAll(testChildren));
//    }
//    
//    @Test
//    public void testThatProperAncestorsAreReturnedForOneGeneration()
//    {
//        testRegistry.add(testPersonProgenitor);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        
//        for(Person p : all1stGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenOne.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenTwo.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenThree.getSsn()).isEmpty());
//        
//        testPersonProgenitor.addChild(testPerson1stGenOne);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson1stGenTwo.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenThree.getSsn()).isEmpty());
//        
//        testPersonProgenitor.addChildren(all1stGenPersons);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson1stGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson1stGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenThree.getSsn()).size());
//    }
//    
//    @Test
//    public void testThatProperAncestorsAreReturnedForTwoGenerations()
//    {
//        testRegistry.add(testPersonProgenitor);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        
//        for(Person p : all1stGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        testPersonProgenitor.addChildren(all1stGenPersons);
//        testRegistry.add(testPerson2ndGenOne);
//        testPerson1stGenOne.addChild(testPerson2ndGenOne);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        assertTrue(testRegistry.ancestors(testPerson1stGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson1stGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson1stGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(1, testRegistry.ancestors(testPerson1stGenThree.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenOne.getSsn()).size());
//        
//        for(Person p : all2ndGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        
//        testPerson1stGenOne.addChildren(all2ndGenPersons);
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenThree.getSsn()).size());
//        
//        testPerson1stGenTwo.addChild(testPerson2ndGenOne);
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(3, testRegistry.ancestors(testPerson2ndGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenThree.getSsn()).size());
//        
//        testPerson1stGenThree.addChild(testPerson2ndGenOne);
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(3, testRegistry.ancestors(testPerson2ndGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(2, testRegistry.ancestors(testPerson2ndGenThree.getSsn()).size());
//    }
//    
//    @Test
//    public void testThatProperAncestorsAreReturnedForThreeGenerations()
//    {
//        testRegistry.add(testPersonProgenitor);
//        assertTrue(testRegistry.ancestors(testPersonProgenitor.getSsn()).isEmpty());
//        
//        for(Person p : all1stGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        testPersonProgenitor.addChildren(all1stGenPersons);
//        
//        for(Person p : all2ndGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        testPerson1stGenOne.addChildren(all2ndGenPersons);
//        testPerson1stGenTwo.addChildren(all2ndGenPersons);
//        
//        testRegistry.add(testPerson3rdGenOne);
//        testPerson2ndGenOne.addChild(testPerson3rdGenOne);
//        
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(3, testRegistry.ancestors(testPerson2ndGenOne.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).contains(testPersonProgenitor));
//        assertEquals(3, testRegistry.ancestors(testPerson2ndGenTwo.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson2ndGenThree.getSsn()).contains(testPersonProgenitor));
//        assertEquals(3, testRegistry.ancestors(testPerson2ndGenThree.getSsn()).size());
//        assertTrue(testRegistry.ancestors(testPerson3rdGenOne.getSsn()).contains(testPerson2ndGenOne));
//        assertTrue(testRegistry.ancestors(testPerson3rdGenOne.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.ancestors(testPerson3rdGenOne.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.ancestors(testPerson3rdGenOne.getSsn()).contains(testPersonProgenitor));
//        assertEquals(4, testRegistry.ancestors(testPerson3rdGenOne.getSsn()).size());
//    }
//    
//    @Test
//    public void testThatProperDescendantsAreReturnedForSingleGeneration()
//    {
//        testRegistry.add(testPersonProgenitor);
//        assertTrue(testRegistry.descendants(testPersonProgenitor.getSsn()).isEmpty());
//        
//        for(Person p : all1stGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        testPersonProgenitor.addChild(testPerson1stGenOne);
//        
//        assertTrue(testRegistry.descendants(testPersonProgenitor.getSsn()).contains(testPerson1stGenOne));
//        assertEquals(1, testRegistry.descendants(testPersonProgenitor.getSsn()).size());
//        
//        testPersonProgenitor.addChildren(all1stGenPersons);
//        assertTrue(testRegistry.descendants(testPersonProgenitor.getSsn()).contains(testPerson1stGenOne));
//        assertTrue(testRegistry.descendants(testPersonProgenitor.getSsn()).contains(testPerson1stGenTwo));
//        assertTrue(testRegistry.descendants(testPersonProgenitor.getSsn()).contains(testPerson1stGenThree));
//        assertEquals(3, testRegistry.descendants(testPersonProgenitor.getSsn()).size());
//    }
//    
//    @Test
//    public void testThatProperDescendantsAreReturnedForTwoGenerations()
//    {
//        testRegistry.add(testPersonProgenitor);
//        
//        for(Person p : all1stGenPersons)
//        {
//            testRegistry.add(p);
//        }
//        testPersonProgenitor.addChildren(all1stGenPersons);
//    }
//
//}


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;
import com.tiy.ssa.weektwo.assignmenttwo.Name;
/**
 *
 * @author thurston
 */
public class RegistryTest
{
    Registry registry = new Registry();

    @Before
    public void universe()
    {
        this.registry = new Registry();
        //unknown parents
        Person greatGrandfather = new Person(new Name("Klement", "McIllvaine"), new SocialSecurityNumber("012345678"));
        greatGrandfather.setBirth(LocalDate.of(1895, Month.JANUARY, 3));
        greatGrandfather.setDeath(LocalDate.of(1934, Month.JULY, 17));
        assertTrue("", this.registry.add(greatGrandfather));

        Person greatGrandmother = new Person(new Name("Mary", "McIllvaine"), new SocialSecurityNumber("012345679"));
        greatGrandmother.setBirth(LocalDate.of(1901, Month.APRIL, 15));
        greatGrandmother.setDeath(LocalDate.of(1934, Month.AUGUST, 29));
        assertTrue("", registry.add(greatGrandmother));

        //*******************************
        Person grandfather = new Person(new Name("Joseph", "Theissner"), new SocialSecurityNumber("112345671"));
        grandfather.setBirth(LocalDate.of(1915, Month.MARCH, 11));
        grandfather.setDeath(LocalDate.of(1948, Month.MAY, 1));
        //unknown parents
        assertTrue("", this.registry.add(grandfather));
        //marries ->
        Person grandma = new Person(new Name("Helena", "Theissner"), new SocialSecurityNumber("112345672"));
        grandma.setBirth(LocalDate.of(1924, Month.DECEMBER, 22));
        grandma.setDeath(LocalDate.of(2015, Month.MAY, 7));
        greatGrandfather.addChild(grandma);
        greatGrandmother.addChild(grandma);
        assertTrue("", this.registry.add(grandma));
        //has sister
        Person temp = new Person(new Name("Dorothea", "Theissner"), new SocialSecurityNumber("112345673"));
        temp.setBirth(LocalDate.of(1926, Month.MAY, 23));
        temp.setDeath(LocalDate.of(2008, Month.MARCH, 13));
        greatGrandfather.addChild(temp);
        greatGrandmother.addChild(temp);
        assertTrue("", this.registry.add(temp));
        //*************************************************************************
        // JT & HT's children:
        Person mother = new Person(new Name("Janet", "Theissner"), new SocialSecurityNumber("212345670"));
        mother.setBirth(LocalDate.of(1941, Month.MAY, 11));
        //still alive
        assertTrue("", this.registry.add(mother));

        Person aunt = new Person(new Name("Babs", "Theissner"), new SocialSecurityNumber("212345671"));
        aunt.setBirth(LocalDate.of(1944, Month.JANUARY, 31));
        aunt.setDeath(LocalDate.of(1995, Month.AUGUST, 29));
        grandfather.addChildren(Arrays.asList(mother, aunt));
        grandma.addChildren(Arrays.asList(mother, aunt));
        assertTrue("", this.registry.add(aunt));

        // marries roger torgo ()
        temp = new Person(new Name("Roger", "Torgo"), new SocialSecurityNumber("212345672"));
        temp.setBirth(LocalDate.of(1942, Month.FEBRUARY, 5));
        temp.setDeath(LocalDate.of(1980, Month.SEPTEMBER, 23));
        //unknown parents
        assertTrue("", this.registry.add(temp));

        //Babs and Roger's children: née 
        Person candy = new Person(new Name("Candy", "Verdun née Torgo"), new SocialSecurityNumber("312345670"));
        candy.setBirth(LocalDate.of(1976, Month.NOVEMBER, 4));
        //still alive
        assertTrue("", this.registry.add(candy));

        Person adam = new Person(new Name("Adam", "Torgo"), new SocialSecurityNumber("312345671"));
        adam.setBirth(LocalDate.of(1980, Month.DECEMBER, 14));
        assertTrue("", this.registry.add(adam));

        aunt.addChildren(Arrays.asList(candy, adam));
        temp.addChildren(Arrays.asList(candy, adam));

        assertEquals("", 10, this.registry.size());


        //Candy's children, just ignore her husband for now:
        Person child = new Person(new Name("Erin", "Verdun"), new SocialSecurityNumber("412345670"));
        child.setBirth(LocalDate.of(2000, Month.OCTOBER, 12));
        candy.addChild(child);
        assertTrue("", this.registry.add(child));

        child = new Person(new Name("Michael", "Verdun"), new SocialSecurityNumber("412345671"));
        child.setBirth(LocalDate.of(2002, Month.JUNE, 29));
        candy.addChild(child);
        assertTrue("", this.registry.add(child));

        //Adam's children (ignore wife for now
        child = new Person(new Name("Mya", "Torgo"), new SocialSecurityNumber("412345672"));
        child.setBirth(LocalDate.of(2016, Month.MAY, 12));
        adam.addChild(child);
        assertTrue("", this.registry.add(child));

        assertEquals("", 13, this.registry.size());


        //Other 'side'
        grandma = new Person(new Name("Eleanor", "Nagle"), new SocialSecurityNumber("112345674"));
        grandma.setBirth(LocalDate.of(1930, Month.AUGUST, 18));
        grandma.setDeath(LocalDate.of(1992, Month.NOVEMBER, 11));
        assertTrue("", this.registry.add(grandma));

        //one child
        Person father = new Person(new Name("Milton", "Nagle"), new SocialSecurityNumber("212345674"));
        father.setBirth(LocalDate.of(1941, Month.JULY, 5));
        grandma.addChild(father);
        assertTrue("", this.registry.add(father));

        //Pa & ma childlren
        Person steven = new Person(new Name("Steven", "Nagle"), new SocialSecurityNumber("412345673"));
        steven.setBirth(LocalDate.of(1964, Month.NOVEMBER, 4));
        assertTrue("", this.registry.add(steven));

        Person kevin = new Person(new Name("Kevin", "Nagle"), new SocialSecurityNumber("412345674"));
        kevin.setBirth(LocalDate.of(1968, Month.SEPTEMBER, 22));
        assertTrue("", this.registry.add(kevin));

        Person jim = new Person(new Name("James", "Nagle"), new SocialSecurityNumber("412345675"));
        jim.setBirth(LocalDate.of(1969, Month.SEPTEMBER, 29));
        assertTrue("", this.registry.add(jim));

        Person jennifer = new Person(new Name("Jennifer", "Blush née Nagle"), new SocialSecurityNumber("412345676"));
        jennifer.setBirth(LocalDate.of(1972, Month.JUNE, 12));
        assertTrue("", this.registry.add(jennifer));

        assertEquals("", 4, father.addChildren(Arrays.asList(steven, kevin, jim, jennifer)));
        assertEquals("", 4, mother.addChildren(Arrays.asList(steven, kevin, jim, jennifer)));

        //and now children's children, expediently we won't worry about spouses
        child = new Person(new Name("Hanley", "Blush"), new SocialSecurityNumber("512345670"));
        child.setBirth(LocalDate.of(1999, Month.MARCH, 20));
        assertTrue("", this.registry.add(child));
        assertTrue("", jennifer.addChild(child));

        child = new Person(new Name("Ildiko", "Nagle"), new SocialSecurityNumber("512345671"));
        child.setBirth(LocalDate.of(2015, Month.DECEMBER, 2));
        assertTrue("", this.registry.add(child));
        assertTrue("", jim.addChild(child));

        assertEquals("", 21, this.registry.size());

    }
    
    @Test
    public void tests()
    {
        System.out.println(registry.size());
    }
}
