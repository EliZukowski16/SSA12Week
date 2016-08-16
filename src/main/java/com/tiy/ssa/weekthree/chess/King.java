package com.tiy.ssa.weekthree.chess;

public class King extends ChessPiece
{
    public King(Location currentLocation)
    {
        super(currentLocation, 1000000);
    }
    
    @Override
    public boolean canMove(Location where)
    {
        if (onBoard(where) && !where().equals(where))
        {
            int xMove = where.getXPosition() - where().getXPosition();
            int yMove = where.getYPosition() - where().getYPosition();

            if (Math.abs(xMove) == 1 || Math.abs(yMove) == 1)
                return true;
        }
        return false;
    }
}
