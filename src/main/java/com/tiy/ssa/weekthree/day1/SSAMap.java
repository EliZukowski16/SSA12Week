package com.tiy.ssa.weekthree.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SSAMap<K, V> implements Map<K, V>
{
    @Override
    public abstract V get(Object key);

    @Override
    public abstract V put(K key, V value);

    @Override
    public abstract V remove(Object key);

    @Override
    public abstract Set<Entry<K, V>> entrySet();

    @Override
    public void clear()
    {
        for (Iterator<Entry<K, V>> i = entrySet().iterator(); i.hasNext();)
        {
            i.next();
            i.remove();
        }
    }

    @Override
    public boolean containsKey(Object key)
    {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value)
    {
        return entrySet().stream().anyMatch(e -> e.getValue().equals(value));
    }

    @Override
    public V getOrDefault(Object key, V defaultValue)
    {
        V value;
        return (value = get(key)) != null ? value : defaultValue;
    }

    @Override
    public Set<K> keySet()
    {
        return entrySet().stream().map(Entry::getKey).collect(Collectors.toSet());
    }

    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        m.entrySet().stream().forEach(e -> put(e.getKey(), e.getValue()));
    }

    @Override
    public int size()
    {
        return (int) entrySet().stream().count();
    }

    @Override
    public Collection<V> values()
    {
        return entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
    }

    @Override
    public V replace(K key, V value)
    {
        return put(key, value);
    }

}
