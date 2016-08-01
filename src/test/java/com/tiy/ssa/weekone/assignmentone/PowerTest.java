package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest
{

	@Test
	public void testPowerOfOne()
	{
		assertEquals(1, new Power().powerOfOne(1));
		assertEquals(2, new Power().powerOfOne(2));
		assertEquals(3, new Power().powerOfOne(3));
		assertEquals(4, new Power().powerOfOne(4));
		assertEquals(5, new Power().powerOfOne(5));
	}
	
	@Test
	public void testPowerOfTwo()
	{
		assertEquals(1, new Power().powerOfTwo(1));
		assertEquals(4, new Power().powerOfTwo(2));
		assertEquals(9, new Power().powerOfTwo(3));
		assertEquals(16, new Power().powerOfTwo(4));
		assertEquals(25, new Power().powerOfTwo(5));
	}
	
	@Test
	public void testPowerOfThree()
	{
		assertEquals(1, new Power().powerOfThree(1));
		assertEquals(8, new Power().powerOfThree(2));
		assertEquals(27, new Power().powerOfThree(3));
		assertEquals(64, new Power().powerOfThree(4));
		assertEquals(125, new Power().powerOfThree(5));
	}

}
