package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest
{

    Collection<User> users = new ArrayList<>();
    
    static Collection<Name> children(Collection<? extends User> users)
    {
        Collection<Name> childrenNames = new HashSet<>();
        
        for(User u : users)
        {
            if(u.getAge() < 16)
            {
                childrenNames.add(new Name(u.getFirstName(), u.getLastName()));
            }
        }
        
        return childrenNames;
    }
    
    static float adultAverageAge(Collection<? extends User> users)
    {
        int totalAge = 0;
        int totalAdults = 0;
        float averageAge = 0.0f;
        
        for(User u : users)
        {
            if(u.getAge() >= 16)
            {
                totalAge += u.getAge();
                totalAdults++;
            }
        }
        
        averageAge = (float) totalAge / (float) totalAdults;
        return averageAge;
    }
    
    @Before
    public void setup()
    {
        users.add(new User("Bob", "Smith", 20));
        users.add(new User("Bob", "Thompson", 10));
        users.add(new User("Bob", "Thompson", 15));
        users.add(new User("Bob", "Jones", 30));
        users.add(new User("Stan", "Smith", 15));
        users.add(new User("Stan", "Thompson", 40));
        users.add(new User("Stan", "Jones", 12));
        users.add(new User("John", "Smith", 50));
        users.add(new User("John", "Thompson", 8));
        users.add(new User("John", "Jones", 25));
    }
    
    @After
    public void clear()
    {
        users.clear();
    }
    
    @Test
    public void testChildrenAreSet()
    {   
        Collection<Name> childrenTest1 = new ArrayList<>(children(users));
        Collection<Name> childrenTest2 = new HashSet<>(children(users));
        
        assertTrue(childrenTest1.size() == childrenTest2.size());
        
        for(User u : users)
        {
            if(u.getAge() < 16)
            {
                assertTrue(childrenTest1.contains(new Name(u.getFirstName(), u.getLastName())));
                assertTrue(childrenTest2.contains(new Name(u.getFirstName(), u.getLastName())));
            }
            else
            {
                assertFalse(childrenTest1.contains(new Name(u.getFirstName(), u.getLastName())));
                assertFalse(childrenTest2.contains(new Name(u.getFirstName(), u.getLastName())));
            }
        }  
    }
    
    @Test
    public void testAdultAverageAgeIsCorrect()
    {
        float averageAge = adultAverageAge(users);
        
        float manualAverageAge = (20.0f + 30.0f + 40.0f + 50.0f + 25.0f)/ 5.0f;
        
        assertEquals(manualAverageAge, averageAge, 0.01);
    }

}
