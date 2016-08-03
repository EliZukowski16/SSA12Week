package com.tiy.ssa.weekone.assignmenttwo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class PrecisionBatteryTest
{

PrecisionBattery testPrecisionBattery;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void createTestBattery() throws Exception
	{
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(100));
	}
	
	@Test
	public void testBatteryWillNotAcceptNegativeEnergyValues() throws Exception
	{
//		When creating new instances of Battery, should throw an exception 
//		if negative values are passed into the Battery
		thrown.expect(Exception.class);
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(-100));
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(-100), BigDecimal.valueOf(-50));
	}
	
	@Test
	public void testBatteryWillNotAcceptCurrentChargeHigherThanMaxCharge() throws Exception
	{
//		When creating new instances of Battery, should throw an exception 
//		if the current charge is set higher than the maximum capacity
		thrown.expect(Exception.class);
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(0), BigDecimal.valueOf(100));
	}
	
	@Test
	public void testBatteryChargesCorrectlyWhenFull()
	{
//		Battery charge should not increase if battery is fully charged
		assertEquals(BigDecimal.valueOf(100), testPrecisionBattery.charge(BigDecimal.valueOf(0)));
		assertEquals(BigDecimal.valueOf(100), testPrecisionBattery.charge(BigDecimal.valueOf(10)));
	}
	
	@Test
	public void testBatteryChargesCorrectlyWhenNotFull() throws Exception
	{
//		Battery charge should increase appropriately when charged and battery is not full
//		Charge should not increase above maximum capacity
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(100), BigDecimal.valueOf(0));
		assertEquals(BigDecimal.valueOf(20), testPrecisionBattery.charge(BigDecimal.valueOf(20)));
		assertEquals(BigDecimal.valueOf(30.1), testPrecisionBattery.charge(BigDecimal.valueOf(10.1)));
		assertEquals(BigDecimal.valueOf(40.2), testPrecisionBattery.charge(BigDecimal.valueOf(10.1)));
		assertEquals(BigDecimal.valueOf(100), testPrecisionBattery.charge(BigDecimal.valueOf(80)));
	}
	
	@Test
	public void testBatteryDischargesCorrectly()
	{
//		Battery charge should decrease appropriately when discharged
//		Charge should not decrease below zero
		assertEquals(BigDecimal.valueOf(90), testPrecisionBattery.discharge(BigDecimal.valueOf(10)));
		assertEquals(BigDecimal.valueOf(79.9), testPrecisionBattery.discharge(BigDecimal.valueOf(10.1)));
		assertEquals(BigDecimal.valueOf(69.8), testPrecisionBattery.discharge(BigDecimal.valueOf(10.1)));
		assertEquals(BigDecimal.valueOf(0), testPrecisionBattery.discharge(BigDecimal.valueOf(90)));
	}
	
	@Test
	public void testBatteryDischargesCorrectlyWhenEmpty() throws Exception
	{
//		Test to make sure an empty battery will not discharge any further
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(0));
		assertEquals(BigDecimal.ZERO, testPrecisionBattery.discharge(BigDecimal.valueOf(50)));
//		Test to make sure a full or partially charged battery will only 
//		discharge to zero when an attempt is made to discharge it further than
//		the current charge left in the battery
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(100));
		assertEquals(BigDecimal.ZERO, testPrecisionBattery.discharge(BigDecimal.valueOf(200)));
		
	}
	
	@Test
	public void testBatteryPrecisionAfterCyclingRepeatedly() throws Exception
	{
//		Repeatedly charge and discharge the battery with slightly different values
//		to show that BigDecimal fixes problem with accumulation of error found in floats or doubles
		testPrecisionBattery = new PrecisionBattery(BigDecimal.valueOf(100), BigDecimal.valueOf(50));
		for(int i = 0; i < 10000; i++)
		{
			testPrecisionBattery.charge(BigDecimal.valueOf(10.002));
			testPrecisionBattery.discharge(BigDecimal.valueOf(10.001));
		}
		
		assertEquals(60, testPrecisionBattery.getRemaining().floatValue(), .1);
		assertEquals(60, testPrecisionBattery.getRemaining().floatValue(), .01);
		assertEquals(60, testPrecisionBattery.getRemaining().floatValue(), .001);
	}
	
	@Test
	public void testRunTimeOfBattery() throws Exception
	{
//		Tests expected run time of battery in minutes if we pass in a value of power in KW
		assertEquals(60, testPrecisionBattery.howLong(BigDecimal.valueOf(100)));
		assertEquals(30, testPrecisionBattery.howLong(BigDecimal.valueOf(200)));
		assertEquals(49, testPrecisionBattery.howLong(BigDecimal.valueOf(120)));
		assertEquals(45, testPrecisionBattery.howLong(BigDecimal.valueOf(133.3)));
	}
	
	@Test
	public void testRunTimeOfBatteryThrowsExceptionForNegativeOrZeroPower() throws Exception
	{
//		Tests that an exception is thrown by howLong() if we try to pass a negative or zero value for power
		thrown.expect(Exception.class);
		testPrecisionBattery.howLong(BigDecimal.valueOf(-100));
		testPrecisionBattery.howLong(BigDecimal.valueOf(0));
	}

}
