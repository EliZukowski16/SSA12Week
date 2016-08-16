package com.tiy.ssa.weekthree.chess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ChessPiece implements Piece
{
    private final Location currentLocation;
    private final int intrinsicValue;

    public ChessPiece(Location currentLocation, int intrinsicValue)
    {
        this.currentLocation = currentLocation;
        this.intrinsicValue = intrinsicValue;
    }

    @Override
    public Location where()
    {
        return currentLocation;
    }

    @Override
    public abstract boolean canMove(Location where);

    public int compareTo(Piece o)
    {
        ChessPiece i = (ChessPiece) o;
        
        if (this.intrinsicValue == i.intrinsicValue)
        {

            List<Location> centerLocations = new ArrayList<>();
            centerLocations.add(new Location(3, 3));
            centerLocations.add(new Location(4, 3));
            centerLocations.add(new Location(3, 4));
            centerLocations.add(new Location(4, 4));

            List<Double> thisDistances = new ArrayList<>();
            List<Double> otherDistances = new ArrayList<>();

            for (Location l : centerLocations)
            {
                int thisXDistance = l.getXPosition() - this.where().getXPosition();
                int thisYDistance = l.getYPosition() - this.where().getYPosition();

                thisDistances.add((double) Math.sqrt(Math.pow(thisXDistance, 2) + Math.pow(thisYDistance, 2)));

                int otherXDistance = l.getXPosition() - i.where().getXPosition();
                int otherYDistance = l.getYPosition() - i.where().getYPosition();

                otherDistances.add((double) Math.sqrt(Math.pow(otherXDistance, 2) + Math.pow(otherYDistance, 2)));
            }

            Double thisDistance = thisDistances.stream().min(Comparator.naturalOrder()).get();
            Double otherDistance = otherDistances.stream().min(Comparator.naturalOrder()).get();
            
            if(thisDistance < otherDistance)
                return 1;
            if(thisDistance > otherDistance)
                return -1;
            
            return 0;

        }
        
        if(this.intrinsicValue > i.intrinsicValue)
            return 1;
        return -1;

    }
    

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + intrinsicValue + getClass().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChessPiece other = (ChessPiece) obj;
        if (intrinsicValue != other.intrinsicValue)
            return false;
        if(intrinsicValue == other.intrinsicValue)
            if(!where().equals(other.where()))
                return false;
        return true;
    }
    
    protected boolean onBoard(Location where)
    {
        int xPosition = where.getXPosition();
        int yPosition = where.getYPosition();
        
        if(xPosition < 0 || xPosition > 7)
            return false;
        if(yPosition < 0 || yPosition > 7)
            return false;
        
        return true;
    }

}
