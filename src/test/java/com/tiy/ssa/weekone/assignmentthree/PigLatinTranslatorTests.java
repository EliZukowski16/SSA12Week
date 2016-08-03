package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PigLatinTranslatorTests
{
	PigLatinTranslator testTranslator;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testThatEmptyOrNullStringThrowsException() throws Exception
	{
//		Tests to make sure an exception is thrown if a blank string or null is passed to the constructor
		thrown.expect(Exception.class);
		testTranslator = new PigLatinTranslator("");
		testTranslator = new PigLatinTranslator(null);
		
	}
	
	@Test
	public void testWordsThatBeginWithVowelsTranslated() throws Exception
	{
//		Test for appropriate behavior if a word begins with 
		testTranslator = new PigLatinTranslator("Above");
		assertEquals("Aboveway", testTranslator.translate());
		testTranslator = new PigLatinTranslator("Amazing every is out under");
		assertEquals("Amazingway everyway isway outway underway", testTranslator.translate());
	}
	
	@Test
	public void testWordsThatBeginWithConsonantFollowedByVowel() throws Exception
	{
		testTranslator = new PigLatinTranslator("Ten");
		assertEquals("Entay", testTranslator.translate());
		testTranslator = new PigLatinTranslator("Four five Six seven Nine");
		assertEquals("Ourfay ivefay Ixsay evensay Inenay", testTranslator.translate());
	}
	
	@Test
	public void testWordsThatBeginWithTwoConsonants() throws Exception
	{
		testTranslator = new PigLatinTranslator("The");
		assertEquals("Ethay", testTranslator.translate());
		testTranslator = new PigLatinTranslator("The this That story Glad");
		assertEquals("Ethay isthay Atthay orystay Adglay", testTranslator.translate());
	}
	
	@Test
	public void testRandomSentence() throws Exception
	{
		testTranslator = new PigLatinTranslator("My favorite letter is d");
		assertEquals("Myay avoritefay etterlay isway day", testTranslator.translate());
		testTranslator = new PigLatinTranslator("E is my favorite letter");
		assertEquals("Eway isway myay avoritefay etterlay", testTranslator.translate());
		testTranslator = new PigLatinTranslator("Pig Latin is hard to speak");
		assertEquals("Igpay Atinlay isway ardhay otay eakspay", testTranslator.translate());
	}

}
