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
        assertTrue(testKnight.getCurrentPosition().equals(testKnight.getHomePosition()));
    }

    @Test
    public void testThatKnightsMove()
    {
        Knight testKnight = new Knight();
        testKnight.move();
        System.out.println("One Move - Non-Deterministic");
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");
        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterTwoMoves()
    {
        Knight testKnight = new Knight();
        testKnight.move();
        System.out.println("Two Moves - Non-Deterministic");
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");

        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterThreeMoves()
    {
        Knight testKnight = new Knight();
        testKnight.move();
        System.out.println("Three Moves - Non-Deterministic");
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");

        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightReturnsHomeAfterOptimalNumberOfMoves()
    {
        Knight testKnight = new Knight();
        System.out.println("Four Moves - Non-Deterministic - Should Return Home");
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.move();
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));

    }

    @Test
    public void testLazyMove()
    {
        Knight testKnight = new Knight();
        System.out.println("Test of Deterministic Move - Four Moves");
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
        
        System.out.println("Test of Deterministic Move - Four additional moves");
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        testKnight.lazyMove();
        System.out.println(testKnight.getCurrentPosition());
        System.out.println("");

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

}
