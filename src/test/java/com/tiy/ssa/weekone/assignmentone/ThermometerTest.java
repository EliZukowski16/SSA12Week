package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThermometerTest
{

	@Test
	public void testThermometerInitiallyInFahrenheitGivesFahrenheitOut()
	{
		assertEquals("", 78, new Thermometer(78, true).display(true));
		assertEquals("", 78, new Thermometer(78).display(true));
	}
	
	@Test
	public void testThermometerInitiallyInCelsiusGivesCelsiusOut()
	{
		assertEquals("", 55, new Thermometer(55, false).display(false));
	}
	
	@Test
	public void testThermometerInitiallyInFahrenheitGivesCelsiusOut()
	{
		assertEquals("", 100, new Thermometer(212, true).display(false));
		assertEquals("", 0, new Thermometer(32, true).display(false));
		assertEquals("", 100, new Thermometer(212).display(false));
		assertEquals("", 0, new Thermometer(32).display(false));
	}
	
	@Test
	public void testThermometerInitiallyInCelsiusGivesFahrenheitOut()
	{
		assertEquals("", 212, new Thermometer(100, false).display(true));
		assertEquals("", 32, new Thermometer(0, false).display(true));
	}
}


