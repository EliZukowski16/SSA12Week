package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class KnightTests
{
    
    static final Logger LOGGER = LogManager.getLogger("com.tiy.ssa.weekone.assignmentfour.KnightTests");

    @Test
    public void testThatKnightsCurrentPositionIsStartingPositionIfNoMovesMade()
    {
        Knight testKnight = new Knight();
        
        
        LOGGER.info("No Moves");
        LOGGER.info("Starting Position {}",testKnight.getCurrentPosition());
        assertTrue(testKnight.getCurrentPosition().equals(testKnight.getHomePosition()));
    }

    @Test
    public void testThatKnightsMove()
    {
        Knight testKnight = new Knight();
        LOGGER.info("One Move - Non-Deterministic");
        LOGGER.info("Starting Position: {}", testKnight.getCurrentPosition());
        
        testKnight.move();
        LOGGER.info("Position 1: {}", testKnight.getCurrentPosition());
        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterTwoMoves()
    {
        Knight testKnight = new Knight();
        LOGGER.info("Two Moves - Non Deterministic");
        LOGGER.info("Starting Position: {}", testKnight.getCurrentPosition());
        
        for(int i = 0; i < 2; i++)
        {
            testKnight.move();
            LOGGER.info("Position {}: {}", i+1, testKnight.getCurrentPosition());
        }

        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightDoesNotBackTrackAfterThreeMoves()
    {
        Knight testKnight = new Knight();
        LOGGER.info("Three Moves - Non-Deterministic");
        LOGGER.info("Starting Position: {}", testKnight.getCurrentPosition());
        
        for(int i = 0; i < 3; i++)
        {
            testKnight.move();
            LOGGER.info("Position {}: {}", i+1, testKnight.getCurrentPosition());
        }

        assertFalse(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

    @Test
    public void testThatKnightReturnsHomeAfterOptimalNumberOfMoves()
    {
        Knight testKnight = new Knight();
        LOGGER.info("Four Moves - Non-Deterministic - Should Return Home");
        LOGGER.info("Starting Position: {}", testKnight.getCurrentPosition());
        
        for(int i = 0; i < 4; i++)
        {
            testKnight.move();
            LOGGER.info("Position {}: {}", i+1, testKnight.getCurrentPosition());
        }

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));

    }

    @Test
    public void testLazyMove()
    {
        Knight testKnight = new Knight();
        LOGGER.info("Test of Deterministic Move - Four Moves");
        LOGGER.info("Starting Position: {}", testKnight.getCurrentPosition());
       
        for(int i = 0; i < 4; i++)
        {
            testKnight.lazyMove();
            LOGGER.info("Position {}: {}", i+1, testKnight.getCurrentPosition());
        }
        

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
        
        LOGGER.info("Test of Deterministic Move - Four Additional Moves");
        LOGGER.info("Current Position: {}", testKnight.getCurrentPosition());
        
        for(int i = 0; i < 4; i++)
        {
            testKnight.lazyMove();
            LOGGER.info("Position {}: {}", i+1, testKnight.getCurrentPosition());
        }
        

        assertTrue(testKnight.getHomePosition().equals(testKnight.getCurrentPosition()));
    }

}
