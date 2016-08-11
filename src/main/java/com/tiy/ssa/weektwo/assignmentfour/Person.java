package com.tiy.ssa.weektwo.assignmentfour;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.tiy.ssa.weektwo.assignmentthree.SocialSecurityNumber;
import com.tiy.ssa.weektwo.assignmenttwo.Name;

public class Person 
{
    final Name name;
    final SocialSecurityNumber ssn;
    Person parentI, parentII;
    LocalDate birth, death;
    final List<Person> children = new ArrayList<>();



    public Person(Name name, SocialSecurityNumber ssn)
    {
        this.name = name;
        this.ssn = ssn;
    }

    public Name getName()
    {
        return this.name;
    }

    public SocialSecurityNumber getSsn()
    {
        return this.ssn;
    }

    public Person getParentI()
    {
        return this.parentI;
    }

    public Person getParentII()
    {
        return this.parentII;
    }

    public LocalDate getBirth()
    {
        return this.birth;
    }

    public LocalDate getDeath()
    {
        return this.death;
    }

    public void setParentI(Person parentI)
    {
        this.parentI = parentI;
    }

    public void setParentII(Person parentII)
    {
        this.parentII = parentII;
    }

    public void setBirth(LocalDate birth)
    {
        this.birth = birth;
    }

    public void setDeath(LocalDate death)
    {
        this.death = death;
    }


    public boolean addChild(Person person)
    {
        if (this.children.contains(person))
            return false;
        if (person.parentI == null)
            person.parentI = this;
        else if (person.parentII == null)
            person.parentII = this;
        else if (! person.parentI.equals(this) && ! person.parentII.equals(this))
            return false; //
        this.children.add(person);
        return true;
    }

    public int addChildren(Collection<? extends Person> children)
    {
        int successes = 0;
        for (Person child : children)
        {
            if (addChild(child))
                successes++;
        }
        return successes;
    }

    public List<Person> getChildren()
    {
        return new ArrayList<>(this.children);
    }

    public int age()
    {
        LocalDate now = LocalDate.now();
        int diff = now.getYear() - this.birth.getYear();
        return now.getDayOfYear() >= this.birth.getDayOfYear() ? diff : --diff;
    }

    public boolean isAlive()
    {
        return null == this.death;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.ssn);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Person other = (Person) obj;
        if (! Objects.equals(this.ssn, other.ssn))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return String.format("%s (%s)", this.name, this.ssn);
    }
    
}
