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

            registry.entrySet().stream().filter(s -> (testChildren.contains(s.getValue())))
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Person::age))).map(Entry::getValue)
                    .forEachOrdered(s ->
                    {
                        if (!descendants.contains(s))
                        {
                            descendants.add(s);
                        }
                    });

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

            registry.entrySet().stream().filter(s -> s.getValue().getChildren().contains(testPerson))
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Person::age))).map(Entry::getValue)
                    .forEachOrdered(s ->
                    {
                        if (!ancestors.contains(s))
                        {
                            ancestors.add(s);
                        }
                    });

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

        if (ancestors.isEmpty())
            return registry.get(ssn);

        return ancestors.stream().filter(s -> s.isAlive()).max(Comparator.comparing(Person::age)).get();

    }

    public Person youngestDescendant(SocialSecurityNumber ssn)
    {
        List<Person> descendants = this.descendants(ssn);

        if (descendants.isEmpty())
            return registry.get(ssn);

        return descendants.stream().filter(s -> s.isAlive()).min(Comparator.comparing(Person::age)).get();
    }

    public boolean areRelated(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        if (one.equals(two))
            return true;

        if (!commonAncestors(one, two).isEmpty())
            return true;

        return false;

    }

    public Person get(SocialSecurityNumber ssn)
    {
        return registry.getOrDefault(ssn, null);
    }

    public Relations related(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        if (one.equals(two))
            return Relations.OTHER;

        List<Person> commonRelatives = commonAncestors(one, two);

        if (!commonRelatives.isEmpty())
        {

            if (isRelationChild(one, two))
                return Relations.CHILD;
            if (isRelationGrandChild(one, two))
                return Relations.GRANDCHILD;
            if (isRelationParent(one, two))
                return Relations.PARENT;
            if (isRelationGrandParent(one, two))
                return Relations.GRANDPARENT;
            if (isRelationSibling(one, two))
                return Relations.SIBLING;
            if (isRelationNibling(one, two))
                return Relations.NIBLING;
            if (isRelationAuncle(one, two))
                return Relations.AUNCLE;
            if (isRelationCousin(one, two))
                return Relations.COUSIN;

            return Relations.OTHER;
        }

        return Relations.NONE;
    }

    public int size()
    {
        return registry.size();
    }

    public static enum Relations
    {
        PARENT, CHILD, GRANDPARENT, GRANDCHILD, COUSIN, SIBLING, NIBLING, AUNCLE, NONE, OTHER;
    }

    private Person youngestCommonAncestor(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        return this.commonAncestors(one, two).stream().min(Comparator.comparingInt(Person::age)).get();
    }

    private Person oldestCommonDescendant(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        return this.commonDescendants(one, two).stream().max(Comparator.comparingInt(Person::age)).get();
    }

    private List<Person> commonAncestors(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        List<Person> oneAncestors = new ArrayList<>();
        List<Person> twoAncestors = new ArrayList<>();

        oneAncestors.addAll(ancestors(one));
        twoAncestors.addAll(ancestors(two));
        oneAncestors.add(registry.get(one));
        twoAncestors.add(registry.get(two));

        List<Person> commonAncestors = new ArrayList<>();

        for (Person p : oneAncestors)
        {
            if (twoAncestors.contains(p) && !(commonAncestors.contains(p)))
            {
                commonAncestors.add(p);
            }
        }

        return commonAncestors.stream().sorted(Comparator.comparingInt(Person::age)).collect(Collectors.toList());

    }

    private List<Person> commonDescendants(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        List<Person> oneDescendants = new ArrayList<>();
        List<Person> twoDescendants = new ArrayList<>();

        oneDescendants.addAll(descendants(one));
        twoDescendants.addAll(descendants(two));

        List<Person> commonDescendants = new ArrayList<>();

        for (Person p : commonDescendants)
        {
            if (twoDescendants.contains(p) && !(commonDescendants.contains(p)))
            {
                commonDescendants.add(p);
            }
        }

        return oneDescendants.stream().sorted(Comparator.comparingInt(Person::age).reversed())
                .collect(Collectors.toList());
    }

    private boolean isRelationChild(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.equals(personOne))
        {
            if (youngestCommonRelative.getChildren().contains(personTwo))
            {
                return true;
            }
        }

        return false;
    }

    private boolean isRelationGrandChild(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.equals(personOne))
        {
            List<Person> onesChildren = personOne.getChildren();
            for (Person p : onesChildren)
            {
                if (p.getChildren().contains(personTwo))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRelationParent(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.equals(personTwo))
        {
            if (youngestCommonRelative.getChildren().contains(personOne))
            {
                return true;
            }
        }

        return false;
    }

    private boolean isRelationGrandParent(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.equals(personTwo))
        {
            List<Person> twosChildren = personTwo.getChildren();
            for (Person p : twosChildren)
            {
                if (p.getChildren().contains(personOne))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRelationAuncle(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.getChildren().contains(personTwo))
        {
            List<Person> ycrChildren = youngestCommonRelative.getChildren();
            for (Person p : ycrChildren)
            {
                if (p.getChildren().contains(personOne))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRelationNibling(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.getChildren().contains(personOne))
        {
            List<Person> ycrChildren = youngestCommonRelative.getChildren();
            for (Person p : ycrChildren)
            {
                if (p.getChildren().contains(personTwo))
                {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean isRelationCousin(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        List<Person> ycrChildren = youngestCommonRelative.getChildren();
        boolean personOneFound = false;
        boolean personTwoFound = false;

        for (Person p : ycrChildren)
        {
            if (p.getChildren().contains(personOne))
            {
                personOneFound = true;
            }
            if (p.getChildren().contains(personTwo))
            {
                personTwoFound = true;
            }
        }

        if (personOneFound && personTwoFound)
        {
            return true;
        }

        return false;
    }

    private boolean isRelationSibling(SocialSecurityNumber one, SocialSecurityNumber two)
    {
        Person youngestCommonRelative = youngestCommonAncestor(one, two);
        Person personOne = registry.get(one);
        Person personTwo = registry.get(two);

        if (youngestCommonRelative.getChildren().contains(personOne)
                && youngestCommonRelative.getChildren().contains(personTwo))
        {
            return true;
        }

        return false;
    }

}
