package com.tiy.ssa.weekone.assignmentfour;

public class Location
{
    public final int x, y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

 

    @Override
    public boolean equals(Object obj)
    {
        
        if(obj == this)
        {
            return true;
        }
        
        if(!(obj instanceof Location))
        {
            return false;
        }
        
        Location testLocation = (Location) obj;
        
        return this.getLocation().equals(testLocation.getLocation());
    }



    public Location offset(int x, int y)
    {
        return new Location(this.x + x, this.y + y);
    }

    public String getLocation()
    {
        return x + "," + y;
    }

}
