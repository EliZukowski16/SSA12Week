package com.tiy.ssa.weektwo.assignmentfour;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentfour.Registry.Relations;
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
        // unknown parents
        Person greatGrandfather = new Person(new Name("Klement", "McIllvaine"), new SocialSecurityNumber("012345678"));
        greatGrandfather.setBirth(LocalDate.of(1895, Month.JANUARY, 3));
        greatGrandfather.setDeath(LocalDate.of(1934, Month.JULY, 17));
        assertTrue("", this.registry.add(greatGrandfather));

        Person greatGrandmother = new Person(new Name("Mary", "McIllvaine"), new SocialSecurityNumber("012345679"));
        greatGrandmother.setBirth(LocalDate.of(1901, Month.APRIL, 15));
        greatGrandmother.setDeath(LocalDate.of(1934, Month.AUGUST, 29));
        assertTrue("", registry.add(greatGrandmother));

        // *******************************
        Person grandfather = new Person(new Name("Joseph", "Theissner"), new SocialSecurityNumber("112345671"));
        grandfather.setBirth(LocalDate.of(1915, Month.MARCH, 11));
        grandfather.setDeath(LocalDate.of(1948, Month.MAY, 1));
        // unknown parents
        assertTrue("", this.registry.add(grandfather));
        // marries ->
        Person grandma = new Person(new Name("Helena", "Theissner"), new SocialSecurityNumber("112345672"));
        grandma.setBirth(LocalDate.of(1924, Month.DECEMBER, 22));
        grandma.setDeath(LocalDate.of(2015, Month.MAY, 7));
        greatGrandfather.addChild(grandma);
        greatGrandmother.addChild(grandma);
        assertTrue("", this.registry.add(grandma));
        // has sister
        Person temp = new Person(new Name("Dorothea", "Theissner"), new SocialSecurityNumber("112345673"));
        temp.setBirth(LocalDate.of(1926, Month.MAY, 23));
        temp.setDeath(LocalDate.of(2008, Month.MARCH, 13));
        greatGrandfather.addChild(temp);
        greatGrandmother.addChild(temp);
        assertTrue("", this.registry.add(temp));
        // *************************************************************************
        // JT & HT's children:
        Person mother = new Person(new Name("Janet", "Theissner"), new SocialSecurityNumber("212345670"));
        mother.setBirth(LocalDate.of(1941, Month.MAY, 11));
        // still alive
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
        // unknown parents
        assertTrue("", this.registry.add(temp));

        // Babs and Roger's children: née
        Person candy = new Person(new Name("Candy", "Verdun née Torgo"), new SocialSecurityNumber("312345670"));
        candy.setBirth(LocalDate.of(1976, Month.NOVEMBER, 4));
        // still alive
        assertTrue("", this.registry.add(candy));

        Person adam = new Person(new Name("Adam", "Torgo"), new SocialSecurityNumber("312345671"));
        adam.setBirth(LocalDate.of(1980, Month.DECEMBER, 14));
        assertTrue("", this.registry.add(adam));

        aunt.addChildren(Arrays.asList(candy, adam));
        temp.addChildren(Arrays.asList(candy, adam));

        assertEquals("", 10, this.registry.size());

        // Candy's children, just ignore her husband for now:
        Person child = new Person(new Name("Erin", "Verdun"), new SocialSecurityNumber("412345670"));
        child.setBirth(LocalDate.of(2000, Month.OCTOBER, 12));
        candy.addChild(child);
        assertTrue("", this.registry.add(child));

        child = new Person(new Name("Michael", "Verdun"), new SocialSecurityNumber("412345671"));
        child.setBirth(LocalDate.of(2002, Month.JUNE, 29));
        candy.addChild(child);
        assertTrue("", this.registry.add(child));

        // Adam's children (ignore wife for now
        child = new Person(new Name("Mya", "Torgo"), new SocialSecurityNumber("412345672"));
        child.setBirth(LocalDate.of(2016, Month.MAY, 12));
        adam.addChild(child);
        assertTrue("", this.registry.add(child));

        assertEquals("", 13, this.registry.size());

        // Other 'side'
        grandma = new Person(new Name("Eleanor", "Nagle"), new SocialSecurityNumber("112345674"));
        grandma.setBirth(LocalDate.of(1930, Month.AUGUST, 18));
        grandma.setDeath(LocalDate.of(1992, Month.NOVEMBER, 11));
        assertTrue("", this.registry.add(grandma));

        // one child
        Person father = new Person(new Name("Milton", "Nagle"), new SocialSecurityNumber("212345674"));
        father.setBirth(LocalDate.of(1941, Month.JULY, 5));
        grandma.addChild(father);
        assertTrue("", this.registry.add(father));

        // Pa & ma childlren
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

        // and now children's children, expediently we won't worry about spouses
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
    public void testAncestors()
    {
        assertEquals(7, registry.ancestors(new SocialSecurityNumber("412345670")).size());
        assertEquals(8, registry.ancestors(new SocialSecurityNumber("512345670")).size());
        assertEquals(0, registry.ancestors(new SocialSecurityNumber("112345674")).size());
    }

    @Test
    public void testProgenitor()
    {
        assertEquals(registry.get(new SocialSecurityNumber("012345678")),
                registry.progenitor(new SocialSecurityNumber("512345671")));
        assertEquals(registry.get(new SocialSecurityNumber("012345678")),
                registry.progenitor(new SocialSecurityNumber("412345671")));
        assertEquals(registry.get(new SocialSecurityNumber("012345678")),
                registry.progenitor(new SocialSecurityNumber("212345670")));
        assertEquals(registry.get(new SocialSecurityNumber("112345674")),
                registry.progenitor(new SocialSecurityNumber("112345674")));
    }

    @Test
    public void testDescendants()
    {
        assertEquals(0, registry.descendants(new SocialSecurityNumber("412345670")).size());
        assertEquals(6, registry.descendants(new SocialSecurityNumber("212345670")).size());
        assertEquals(15, registry.descendants(new SocialSecurityNumber("012345678")).size());
    }

    @Test
    public void testYoungestDescendant()
    {
        assertEquals(registry.get(new SocialSecurityNumber("512345671")),
                registry.youngestDescendant(new SocialSecurityNumber("212345670")));
        assertEquals(registry.get(new SocialSecurityNumber("412345672")),
                registry.youngestDescendant(new SocialSecurityNumber("212345671")));
    }

    @Test
    public void testOldestLivingRelative()
    {
        assertEquals(registry.get(new SocialSecurityNumber("212345670")),
                registry.oldestLivingRelative(new SocialSecurityNumber("412345675")));
        assertEquals(registry.get(new SocialSecurityNumber("312345670")),
                registry.oldestLivingRelative(new SocialSecurityNumber("412345671")));
    }

    @Test
    public void testAreTwoPeopleRelated()
    {
        assertTrue(registry.areRelated(new SocialSecurityNumber("312345670"), new SocialSecurityNumber("212345672")));
        assertTrue(registry.areRelated(new SocialSecurityNumber("412345674"), new SocialSecurityNumber("112345672")));
        assertFalse(registry.areRelated(new SocialSecurityNumber("212345672"), new SocialSecurityNumber("412345674")));
    }
    
    @Test
    public void testTestRelationsOfPeople()
    {
        assertEquals(Relations.CHILD, registry.related(new SocialSecurityNumber("212345672"), new SocialSecurityNumber("312345670")));
        assertEquals(Relations.PARENT, registry.related(new SocialSecurityNumber("212345671"), new SocialSecurityNumber("112345671")) );
        assertEquals(Relations.GRANDPARENT, registry.related(new SocialSecurityNumber("412345675"), new SocialSecurityNumber("112345672")));
        assertEquals(Relations.GRANDCHILD, registry.related(new SocialSecurityNumber("012345679"), new SocialSecurityNumber("212345670")));
        assertEquals(Relations.NIBLING, registry.related(new SocialSecurityNumber("112345673"), new SocialSecurityNumber("212345671")));
        assertEquals(Relations.AUNCLE, registry.related(new SocialSecurityNumber("312345671"), new SocialSecurityNumber("212345670")));
        assertEquals(Relations.COUSIN, registry.related(new SocialSecurityNumber("412345673"), new SocialSecurityNumber("312345670")));
        assertEquals(Relations.SIBLING, registry.related(new SocialSecurityNumber("112345673"), new SocialSecurityNumber("112345672")));
        assertEquals(Relations.OTHER, registry.related(new SocialSecurityNumber("512345670"), new SocialSecurityNumber("112345671")));
        assertEquals(Relations.OTHER, registry.related(new SocialSecurityNumber("312345671"), new SocialSecurityNumber("312345671")));
        assertEquals(Relations.NONE, registry.related(new SocialSecurityNumber("212345672"), new SocialSecurityNumber("112345674")));
        
    }
}
