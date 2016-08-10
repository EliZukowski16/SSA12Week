package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AssociativeGrammarTest
{
    
    AssociativeGrammar correctProgram;
    AssociativeGrammar invalidProgram;
    
    @Before
    public void setup()
    {
        correctProgram = new AssociativeGrammar("()({[]})");
    }

    @Test
    public void testTheCorrectProgramCompiles()
    {
        assertTrue(correctProgram.compiles());
    }

}
