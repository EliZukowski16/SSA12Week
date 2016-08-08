package com.tiy.ssa.weekone.assignmentfour;

public class Location
{
    public final int x, y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // @Override
    // public boolean equals(Location testLocation)
    // {
    //
    // }

    public Location offset(int x, int y)
    {
        return new Location(this.x + x, this.y + y);
    }

    public String getLocation()
    {
        return x + "," + y;
    }

}
