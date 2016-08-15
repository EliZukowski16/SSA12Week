package com.tiy.ssa.weekthree.day1;

import java.util.HashMap;
import java.util.Map;

public class MapUtils<K, V>
{
    
    final Map<K, V> map = new HashMap<>();
    
    public void add(K key, V value)
    {
        this.map.put(key, value);
    }
    
    public V getOrDefault(K key, V def)
    {   
        V retValue;
        
        return (retValue = map.get(key)) != null ? retValue : def;
    }

}
