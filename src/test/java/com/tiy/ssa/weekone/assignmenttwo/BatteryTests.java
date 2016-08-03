package com.tiy.ssa.weekone.assignmenttwo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class BatteryTests
{

	Battery testBattery;
	
	@Before
	public void createTestBattery()
	{
		testBattery = new Battery(100, 100);
	}
	
	@Test
	public void testBatteryChargesCorrectlyWhenFull()
	{
//		Battery charge should not increase if battery is fully charged
		assertEquals(100, testBattery.charge(0), 0.01);
		assertEquals(100, testBattery.charge(10), 0.01);
	}
	
	@Test
	public void testBatteryChargesCorrectlyWhenNotFull()
	{
//		Battery charge should increase appropriately when charged and battery is not full
//		Charge should not increase above maximum capacity
		testBattery = new Battery(100, 0);
		assertEquals(20, testBattery.charge(20), 0.01);
		assertEquals(30.1, testBattery.charge(10.1f), 0.01);
//		Below assert provides an example of the limits of precision in decimal math in Java
		assertNotEquals(40.2, testBattery.charge(10.1f), 0.0000001);
		assertEquals(100, testBattery.charge(80), 0.01);
	}
	
	@Test
	public void testBatteryDischargesCorrectly()
	{
//		Battery charge should decrease appropriately when discharged
//		Charge should not decrease below zero
		assertEquals(90, testBattery.discharge(10), 0.01);
		assertEquals(79.9, testBattery.discharge(10.1f), 0.01);
//		Below assert provides and example of the limits of precision in decimal math in Java
		assertNotEquals(69.8, testBattery.discharge(10.1f), 0.000001);
		assertEquals(0, testBattery.discharge(90), 0.01);
	}
	
	@Test
	public void testBatteryPrecisionAfterCyclingRepeatedly()
	{
//		Repeatedly charge and discharge the battery with slightly different values
//		and errors in decimal math will accumulate
		testBattery = new Battery(100, 50);
		for(int i = 0; i < 10000; i++)
		{
			testBattery.charge(10.002f);
			testBattery.discharge(10.001f);
		}
		
		assertEquals(60, testBattery.getCharge(), 0.1);
		assertEquals(60, testBattery.getCharge(), 0.01);
//		Demonstrates that much lower level of precision necessary to find
//		discrepancy between what we logically expect value to be and what it actually is
//		after a large number of rounds of decimal math have been performed
		assertNotEquals(60, testBattery.getCharge(), 0.001);
	}
	
}
