package com.tiy.ssa.weekthree.chess;

public class Bishop extends ChessPiece
{
    public Bishop(Location currentLocation)
    {
        super(currentLocation, 3);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (onBoard(where) && !where().equals(where))
        {
            int xMove = where.getXPosition() - where().getXPosition();
            int yMove = where.getYPosition() - where().getYPosition();

            if (Math.abs(xMove) == Math.abs(yMove))
                return true;
        }
        return false;
    }
}
