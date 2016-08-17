package com.tiy.ssa.weekthree.chess;

public class Knight extends ChessPiece
{
    private ChessPiece king;
    private ChessPiece bishop;
    private ChessPiece rook;

    public Knight(Location currentLocation)
    {
        super(currentLocation, 3);
        king = new King(currentLocation);
        bishop = new Bishop(currentLocation);
        rook = new Rook(currentLocation);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (onBoard(where) && !where().equals(where))
        {
            int xMove = where.getXPosition() - where().getXPosition();
            int yMove = where.getYPosition() - where().getYPosition();

            if ((Math.abs(xMove) + Math.abs(yMove)) == 3)
                if (!(xMove == 0 || yMove == 0))
                    return true;
        }
        return false;
    }

}
