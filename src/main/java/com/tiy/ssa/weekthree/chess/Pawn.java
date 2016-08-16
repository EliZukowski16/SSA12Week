package com.tiy.ssa.weekthree.chess;

public class Pawn extends ChessPiece
{
    public Pawn(Location currentLocation)
    {
        super(currentLocation, 1);
    }
    
    @Override
    public boolean canMove(Location where)
    {
        if (onBoard(where) && !where().equals(where))
        {
            int xMove = where.getXPosition() - where().getXPosition();
            int yMove = where.getYPosition() - where().getYPosition();

            if (where().getYPosition() == 1)
                if (xMove == 0 && yMove <= 2 && yMove >= 1)
                    return true;
            if (yMove == 1 && xMove == 0)
                return true;
        }

        return false;
    }
}
