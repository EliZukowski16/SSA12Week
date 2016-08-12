package com.tiy.ssa.weektwo.assignmentfour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;

public class Registry
{
    final Map<SocialSecurityNumber, Person> registry = new HashMap<>();

    public Person progenitor(SocialSecurityNumber ssn)
    {

    }

    public List<Person> descendants(SocialSecurityNumber ssn)
    {

    }

    public List<Person> ancestors(SocialSecurityNumber ssn)
    {
        Person person = registry.get(ssn);
        List<Person> ancestors = new ArrayList<>();

        ancestors.add(person);

        // for(int i = 0; i < ancestors.size(); i++)
        // {
        // for(Entry e : registry.entrySet())
        // {
        // Person testPerson = registry.get(e.getKey());
        // if(testPerson.getChildren().contains(ancestors.get(i)) &&
        // !(ancestors.contains(testPerson)))
        // ancestors.add(testPerson);
        // }
        // }
        //

        for (int i = 0; i < ancestors.size(); i++)
        {
            Person testPerson = ancestors.get(i);

            registry.entrySet().stream().filter(s -> s.getValue().getChildren().contains(testPerson))
                    // .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Person::age)))
                    .map(Entry::getValue).forEachOrdered(s -> ancestors.add(s));
        }

        ancestors.remove(person);

        return new ArrayList<>(ancestors);
    }

    public boolean add(Person person)
    {
        if (registry.putIfAbsent(person.ssn, person) == null)
            return true;
        return false;

    }
    
    public Person oldestLivingRelative(SocialSecurityNumber ssn)
    {
        List<Person> ancestors = this.ancestors(ssn);
        
        if(ancestors.isEmpty())
            return registry.get(ssn);

        return ancestors.stream().filter(s -> s.isAlive()).max(Comparator.comparing(Person::age)).get();

    }
       
    public Person youngestDescendant(SocialSecurityNumber one)
    {

    }
    
    public boolean areRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        
    }
    
    public Person get(SocialSecurityNumber ssn)
    {
        return registry.getOrDefault(ssn, null);
    }
    
    public Relationship related(SocialSecurityNumber ssn)
    {
        
    }

    public static enum Relations
    {
        PARENT, SIBLING, GRANDPARENT, CHILD, GRANDCHILD, AUNCLE, NIBLING
    }

}
