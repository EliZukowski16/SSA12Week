package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooTests
{

	@Test
	public void helloClassTest()
	{
		assertEquals(5, new Foo().helloClass());
	}
	
	@Test
	public void hiClassTest()
	{
		assertEquals(4, new Foo().hiClass());
	}

}
