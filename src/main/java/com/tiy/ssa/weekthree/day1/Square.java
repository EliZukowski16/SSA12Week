package com.tiy.ssa.weekthree.day1;

public class Square extends Rectangle
{
    public Square(int side)
    {
        super(side, side);
    }
    
    @Override
    public void setHeight(int height)
    {
        super.setHeight(height);
        super.setWidth(height);
    }
    
    @Override
    public void setWidth(int width)
    {
        super.setWidth(width);
        super.setHeight(width);
    }
}
