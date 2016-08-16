package com.tiy.ssa.weekthree.chess;

public class Queen extends ChessPiece
{
    private Rook rook;
    private Bishop bishop;

    public Queen(Location currentLocation)
    {
        super(currentLocation, 8);
        rook = new Rook(currentLocation);
        bishop = new Bishop(currentLocation);
    }

    @Override
    public boolean canMove(Location where)
    {   
        if(rook.canMove(where) || bishop.canMove(where))
            return true;
        
        return false;
    }

}
