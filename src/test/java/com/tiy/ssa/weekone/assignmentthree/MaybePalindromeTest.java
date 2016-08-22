package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MaybePalindromeTest
{
	
	MaybePalindrome testPalindrome;
	static final Logger LOGGER = LogManager.getLogger();

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testStringIsNotEmpty() throws Exception
	{
//		Exception is thrown if an empty string or null value is passed into constructor
		thrown.expect(Exception.class);
		testPalindrome = new MaybePalindrome("");
		testPalindrome = new MaybePalindrome(null);
	}

	@Test
	public void testStringIsNotPalindrome() throws Exception
	{
		testPalindrome = new MaybePalindrome("Racecars");
		assertFalse(testPalindrome.isPalindrome());
		LOGGER.debug(testPalindrome.toString());
	}
	
	@Test
	public void testStringIsPalindome() throws Exception
	{
		testPalindrome = new MaybePalindrome("MadAm");
		assertTrue(testPalindrome.isPalindrome());
		LOGGER.debug(testPalindrome.toString());
	}
}
