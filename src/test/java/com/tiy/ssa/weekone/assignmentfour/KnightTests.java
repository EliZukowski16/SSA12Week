package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class KnightTests
{
//	Knight testKnight = new Knight();

	@Test
	public void testThatKnightsCurrentPositionIsStartingPositionIfNoMovesMade()
	{
		Knight testKnight = new Knight();
		assertEquals(testKnight.currentLocation.getLocation(), testKnight.startingLocation.getLocation());
	}
	
	@Test
	public void testThatKnightsMove()
	{
		Knight testKnight = new Knight();
		String initialLocation = testKnight.getPosition();
		testKnight.lazyMove();
		String finalLocation = testKnight.getPosition();
		assertNotEquals(initialLocation, finalLocation);
	}
	
	@Test 
	public void testThatKnightDoesNotBackTrack()
	{
		Knight testKnight = new Knight();
		String initialLocation = testKnight.getPosition();
		testKnight.lazyMove();
		testKnight.lazyMove();
		String finalLocation = testKnight.getPosition();
			
		assertNotEquals(initialLocation, finalLocation);
	}
	
	@Test 
	public void testThatKnightReturnsHomeAfterOptimalNumberOfMoves()
	{
		Knight testKnight = new Knight();
		String initialLocation = testKnight.getPosition();
		testKnight.lazyMove();
		testKnight.lazyMove();
		testKnight.lazyMove();
		testKnight.lazyMove();
		String finalLocation = testKnight.getPosition();
		
		assertEquals(initialLocation, finalLocation);
		
		for(Location l: testKnight.moves)
		{
			System.out.println(l.getLocation());
		}
	}
}
