package com.tiy.ssa.weekthree.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foo
{
    
    public void fooTest()
    {
        List<String> strings = new ArrayList<>();
        strings.add("One");
        strings.add("Three");
        strings.add("Four");
        
        Collections.sort(strings, (o1, o2) -> o1.length() - o2.length());
    }

}
