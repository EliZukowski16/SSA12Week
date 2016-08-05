package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathsTest
{

	@Test
	public void testSquareRootsOfPositiveNumbers()
	{
		assertEquals((int) Math.sqrt(4), Maths.squareRoot(4));
		assertEquals((int) Math.sqrt(15), Maths.squareRoot(15));
		assertEquals((int) Math.sqrt(16), Maths.squareRoot(16));
		assertEquals((int) Math.sqrt(255), Maths.squareRoot(255));
		assertEquals((int) Math.sqrt(258898211), Maths.squareRoot(258898211));
	}
	
	@Test
	public void testSquareRootsOfNegativeNumbers()
	{
		assertEquals((int) Math.sqrt(-4), Maths.squareRoot(-4));
		assertEquals((int) Math.sqrt(-15), Maths.squareRoot(-15));
		assertEquals((int) Math.sqrt(-16), Maths.squareRoot(-16));
		assertEquals((int) Math.sqrt(-255), Maths.squareRoot(-255));
		assertEquals((int) Math.sqrt(-258898211), Maths.squareRoot(-258898211));
	}
	
	@Test
	public void testCubeRootsOfPositiveNumbers()
	{
		assertEquals((int) Math.cbrt(16), Maths.cubeRoot(16));
		assertEquals((int) Math.cbrt(64), Maths.cubeRoot(64));
		assertEquals((int) Math.cbrt(255), Maths.cubeRoot(255));
		assertEquals((int) Math.cbrt(258898211), Maths.cubeRoot(258898211));
		assertEquals((int) Math.cbrt(80000), Maths.cubeRoot(80000));
	}
	
	@Test
	public void testCubeRootsOfNegativeNumbers()
	{
		assertEquals((int) Math.cbrt(-16), Maths.cubeRoot(-16));
		assertEquals((int) Math.cbrt(-64), Maths.cubeRoot(-64));
		assertEquals((int) Math.cbrt(-255), Maths.cubeRoot(-255));
		assertEquals((int) Math.cbrt(-258898211), Maths.cubeRoot(-258898211));
		assertEquals((int) Math.cbrt(-80000), Maths.cubeRoot(-80000));
	}
	
	@Test
	public void testRootsOfZero()
	{
		assertEquals((int) Math.sqrt(0), Maths.squareRoot(0));
		assertEquals((int) Math.cbrt(0), Maths.cubeRoot(0));
	}
	
	@Test
	public void testLogBaseTwo()
	{
		assertEquals((int) (Math.log10(16)/Math.log10(2)), Maths.logBaseTwo(16));
		assertEquals((int) (Math.log10(255)/Math.log10(2)), Maths.logBaseTwo(255));
		assertEquals((int) (Math.log10(856421315)/Math.log10(2)), Maths.logBaseTwo(856421315));
	}
	
	@Test
	public void testLogBaseThree()
	{
		assertEquals((int) (Math.log10(16)/Math.log10(3)), Maths.logBaseThree(16));
		assertEquals((int) (Math.log10(255)/Math.log10(3)), Maths.logBaseThree(255));
		assertEquals((int) (Math.log10(856421315)/Math.log10(3)), Maths.logBaseThree(856421315));
	}

}
