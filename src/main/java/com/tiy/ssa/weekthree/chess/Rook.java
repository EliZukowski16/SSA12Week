package com.tiy.ssa.weekthree.chess;

public class Rook extends ChessPiece
{
    public Rook(Location currentLocation)
    {
        super(currentLocation, 5);
    }
    

    @Override
    public boolean canMove(Location where)
    {
        if (onBoard(where) && !where().equals(where))
        {

            int xMove = where.getXPosition() - where().getXPosition();
            int yMove = where.getYPosition() - where().getYPosition();

            if (Math.abs(xMove) >= 0 && Math.abs(yMove) >= 0)
                return false;

            return true;
        }

        return false;
    }

}
