package com.tiy.ssa.weektwo.assignmentfour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;

public class Registry
{
    final Map<SocialSecurityNumber, Person> registry = new HashMap<>();

    public Person progenitor(SocialSecurityNumber ssn)
    {
        List<Person> ancestors = this.ancestors(ssn);

        if (ancestors.isEmpty())
            return registry.get(ssn);

        return ancestors.stream().max(Comparator.comparing(Person::age)).get();

    }

    public List<Person> descendants(SocialSecurityNumber ssn)
    {
        Person person = registry.get(ssn);
        List<Person> descendants = new ArrayList<>();
        
        descendants.add(person);
        
        for (int i = 0; i < descendants.size(); i++)
        {
            Person testPerson = descendants.get(i);
            
            List<Person> testChildren = new ArrayList<>(testPerson.getChildren());

            registry.entrySet().stream()
                    .filter(s -> (testChildren.contains(s.getValue())))
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Person::age)))
                    .map(Entry::getValue)
                    .forEachOrdered(s -> {if(!descendants.contains(s)) {descendants.add(s);}});
                    
        }
        
        descendants.remove(person);
        
        return descendants;

    }

    public List<Person> ancestors(SocialSecurityNumber ssn)
    {
        Person person = registry.get(ssn);
        List<Person> ancestors = new ArrayList<>();

        ancestors.add(person);

        for (int i = 0; i < ancestors.size(); i++)
        {
            Person testPerson = ancestors.get(i);

            registry.entrySet().stream()
                    .filter(s -> s.getValue().getChildren().contains(testPerson))
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Person::age)))
                    .map(Entry::getValue)
                    .forEachOrdered(s -> {if(!ancestors.contains(s)) {ancestors.add(s);}});
                    
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

        return ancestors.stream()
                .filter(s -> s.isAlive())
                .max(Comparator.comparing(Person::age))
                .get();

    }
       
    public Person youngestDescendant(SocialSecurityNumber ssn)
    {
        List<Person> descendants = this.descendants(ssn);
        
        if(descendants.isEmpty())
            return registry.get(ssn);
        
        return descendants.stream()
                .filter(s -> s.isAlive())
                .min(Comparator.comparing(Person::age))
                .get();
    }
    
    public boolean areRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        if(one.equals(two))
            return true;
        
        if(areAncestorsRelated(one, two) || areDescendantsRelated(one,two))
            return true;
        
        return false;
        
        
        
    }
    
    public Person get(SocialSecurityNumber ssn)
    {
        return registry.getOrDefault(ssn, null);
    }
    
    public Relationship related(SocialSecurityNumber ssn)
    {
        
    }
    
    public int size()
    {
        return registry.size();
    }

    public static enum Relations
    {
        PARENT, CHILD, GRANDPARENT, GRANDCHILD, COUSIN, SIBLING, NIBLING, AUNCLE, NONE;
    }
    
    private boolean areAncestorsRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        List<Person> oneAncestors = this.ancestors(one);
        List<Person> twoAncestors = this.ancestors(two);
        oneAncestors.retainAll(twoAncestors);
        
        if(!oneAncestors.isEmpty())
            return true;
        
        return false;
    }
    
    private boolean areDescendantsRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        List<Person> oneDescendants = this.descendants(one);
        List<Person> twoDescendants = this.descendants(two);
        oneDescendants.retainAll(twoDescendants);
        
        if(!oneDescendants.isEmpty())
            return true;
        
        return false;
    }

}
