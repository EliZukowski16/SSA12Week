package com.tiy.ssa.weektwo.assignmentthree;

import static org.junit.Assert.*;

import org.junit.Test;

public class SocialSecurityNumberTests
{
    
    @Test
    public void last4()
    {
        assertEquals("1234", new SocialSecurityNumber("999281234").last4Digits());
    }
    
}
