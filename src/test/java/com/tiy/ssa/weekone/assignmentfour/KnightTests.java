package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class KnightTests
{

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
        testKnight.move();
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String finalLocation = testKnight.getPosition();
        assertNotEquals(initialLocation, finalLocation);
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterTwoMoves()
    {
        Knight testKnight = new Knight();
        String initialLocation = testKnight.getPosition();
        testKnight.move();
        System.out.println(testKnight.getPosition());
        testKnight.move();
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String finalLocation = testKnight.getPosition();

        assertNotEquals(initialLocation, finalLocation);
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterThreeMoves()
    {
        Knight testKnight = new Knight();
        testKnight.move();
        System.out.println("Three Moves");
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String initialLocation = testKnight.getPosition();
        testKnight.move();
        System.out.println(testKnight.getPosition());
        testKnight.move();
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String finalLocation = testKnight.getPosition();

        assertNotEquals(initialLocation, finalLocation);
    }

    @Test
    public void testThatKnightReturnsHomeAfterOptimalNumberOfMoves()
    {
        Knight testKnight = new Knight();
        String initialLocation = testKnight.getPosition();
        testKnight.move();
        System.out.println(testKnight.getPosition());
        testKnight.move();
        System.out.println(testKnight.getPosition());
        testKnight.move();
        System.out.println(testKnight.getPosition());
        testKnight.move();
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String finalLocation = testKnight.getPosition();

        assertEquals(initialLocation, finalLocation);

    }

    @Test
    public void testLazyMove()
    {
        Knight testKnight = new Knight();
        String initialLocation = testKnight.getPosition();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        System.out.println("");
        String finalLocation = testKnight.getPosition();

        assertEquals(initialLocation, finalLocation);

        initialLocation = testKnight.getPosition();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getPosition());
        finalLocation = testKnight.getPosition();

        assertEquals(initialLocation, finalLocation);
    }

}
