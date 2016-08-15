package com.tiy.ssa.weekthree.day1;

public class Rectangle implements Shape
{
    protected int height, width;
    
    public Rectangle(int height, int width)
    {
        this.height = height;
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }

    @Override
    public void draw()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float area()
    {
        return getWidth() * getHeight();
    }

}
