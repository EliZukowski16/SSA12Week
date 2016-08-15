package com.tiy.ssa.weekthree.day1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest
{
    Rectangle testRectangle;
    Square testSquare;

    @Test
    public void testToCreateRectangleAndEnsureThatHeightAndWidthAreWhatWeSet()
    {
        testRectangle = new Rectangle(5, 10);
        assertEquals(5, testRectangle.getHeight());
        assertEquals(10, testRectangle.getWidth());
    }
    
    @Test
    public void testThatRectangleAreaIsCorrect()
    {
        testRectangle = new Rectangle(5, 10);
        assertEquals(50, testRectangle.area(), .01);
    }
    
    @Test
    public void testThatAreaOfRectangleChangesWhenWeChangeHeightOrWidth()
    {
        testRectangle = new Rectangle(5, 10);
        
        testRectangle.setHeight(10);
        assertEquals(100, testRectangle.area(), .01);
        
        testRectangle.setWidth(5);
        assertEquals(50, testRectangle.area(), .01);
    }
    
    @Test
    public void testCreateASquareAndEnsureThatHeightAndWidthAreWhatWeSet()
    {
        testSquare = new Square(10);
        assertEquals(10, testSquare.getHeight());
        assertEquals(10, testSquare.getWidth());
    }
    
    @Test
    public void testThatAreaOfSquareIsCorrect()
    {
        testSquare = new Square(10);
        assertEquals(100, testSquare.area(), .01);
    }
    
    @Test
    public void testThatHeightOfSquareChangesIfWeChangeWidth()
    {
        testSquare = new Square(10);
        testSquare.setWidth(5);
        assertEquals(5, testSquare.getWidth());
        assertEquals(5, testSquare.getHeight());
        assertEquals(25, testSquare.area(), .01);
    }
    
    @Test
    public void testThatWidthOfSquareChangesIfWeChangeHeight()
    {
        testSquare = new Square(10);
        testSquare.setHeight(5);
        assertEquals(5, testSquare.getWidth());
        assertEquals(5, testSquare.getHeight());
        assertEquals(25, testSquare.area(), .01);
    }
    
    @Test
    public void testThatARectangleWeMakeASquareFollowsSquareSizeRules()
    {
        testRectangle = new Square(5);
        
        assertEquals(5, testRectangle.getHeight(), .01);
        assertEquals(5, testRectangle.getWidth(), .01);
        
        testRectangle.setWidth(10);
        
        assertEquals(50, testRectangle.area(), .01);
    }
}
