package com.tiy.ssa.weektwo.assignmenttwo;

import java.util.Objects;

public class Name
{
    final String first, last;

    public Name(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    public String getFirst()
    {
        return this.first;
    }

    public String getLast()
    {
        return this.last;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.first);
        hash = 23 * hash + Objects.hashCode(this.last);
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.first, other.first))
        {
            return false;
        }
        if (!Objects.equals(this.last, other.last))
        {
            return false;
        }
        return true;
    }
}