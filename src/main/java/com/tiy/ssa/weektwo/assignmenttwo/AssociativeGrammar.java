package com.tiy.ssa.weektwo.assignmenttwo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class AssociativeGrammar
{
    private final String originalInput;
    private String modifiedInput;
    
    
    public AssociativeGrammar(String originalInput)
    {
        this.originalInput = originalInput;
        modifiedInput = originalInput;
    }
    
    public String getSource()
    {
        return modifiedInput;
    }
    
    public String addOperator(char operator)
    {
        if(Pattern.matches("[/(/{/[/]/}/)]", String.valueOf(operator)))
        {
            modifiedInput += operator;
        }
        
        return modifiedInput;
    }
    
    public boolean compiles()
    {
        char[] splitInput = modifiedInput.toCharArray();
        
        Deque<Character> program = new ArrayDeque<>();
        
        for(Character c : splitInput)
        {
            if (c == '[' || c == '{' || c == '(')
            {
                program.addFirst(c);
            }
            
            if(c == ']' || c == '}' || c == ')')
            {
                if(program.size() != 0)
                {
                    if(c == ']')
                    {
                        if(program.peekFirst() == '[')
                        {
                            program.removeFirst();
                        }
                        else
                        {
                            return false;
                        }
                    }
                    if(c == '}')
                    {
                        if(program.peekFirst() == '{')
                        {
                            program.removeFirst();
                        }
                        else
                        {
                            return false;
                        }
                    }
                    if(c == ')')
                    {
                        if(program.peekFirst() == '(')
                        {
                            program.removeFirst();
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        if(program.size() != 0)
        {
            return false;
        }
        return true;
    }
}
