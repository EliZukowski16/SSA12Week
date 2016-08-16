package com.tiy.ssa.weekthree.day2;

import com.tiy.ssa.weekthree.day1.Rectangle;
import com.tiy.ssa.weekthree.day1.Shape;

public class Square2 implements Shape
{
    
    private Rectangle rectangle;

    public Square2(int dimension)
    {
        rectangle = new Rectangle(dimension, dimension);
    }
    
    public void setDimension(int dimension)
    {
        rectangle.setHeight(dimension);
        rectangle.setWidth(dimension);
    }
    
    public int getDimension()
    {
        return rectangle.getHeight();
    }

    @Override
    public void draw()
    {
        rectangle.draw();
    }

    @Override
    public float area()
    {
        return rectangle.area();
    }

}
