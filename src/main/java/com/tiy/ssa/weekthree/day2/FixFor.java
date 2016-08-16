package com.tiy.ssa.weekthree.day2;

import java.util.Iterator;

public class FixFor<T> implements Iterator<T>, Iterable<T>
{
    final Iterator<T> decorated;

    public FixFor(Iterator<T> decorated)
    {
        this.decorated = decorated;
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return decorated;
    }

    @Override
    public boolean hasNext()
    {
        return decorated.hasNext();
    }

    @Override
    public T next()
    {
        return decorated.next();
    }
    
    @Override
    public void remove()
    {
        decorated.remove();
    }

}
