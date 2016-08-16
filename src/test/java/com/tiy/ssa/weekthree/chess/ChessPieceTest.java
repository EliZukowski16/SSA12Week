package com.tiy.ssa.weekthree.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChessPieceTest
{

    ChessPiece king;
    ChessPiece bishop;
    ChessPiece queen;
    ChessPiece rook;
    ChessPiece knight;
    ChessPiece pawn;

    @Before
    public void setup()
    {
        Location origin = new Location(0, 0);

        king = new King(origin);
        bishop = new Bishop(origin);
        queen = new Queen(origin);
        rook = new Rook(origin);
        knight = new Knight(origin);
        pawn = new Pawn(origin);
    }

    @Test
    public void testKingTests()
    {
        assertTrue(king.equals(new King(new Location(0, 0))));
        assertFalse(king.equals(new King(new Location(0, 1))));
        assertFalse(king.equals(new Rook(new Location(0, 0))));
        
        Location validKingMove;
        Location invalidKingMove;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; i < 9; i++)
            {
                if (i == 0 && j == 0)
                {
                    invalidKingMove = new Location(i, j);
                    assertFalse(king.canMove(invalidKingMove));
                }
                else if(i < 2 && j < 2)
                {
                    validKingMove = new Location(i, j);
                    assertTrue(king.canMove(validKingMove));
                }
                else
                {
                    invalidKingMove = new Location(i, j);
                    assertFalse(king.canMove(invalidKingMove));
                }
            }
        }
    }

    @Test
    public void testBishopTests()
    {
        assertTrue(bishop.equals(new Bishop(new Location(0, 0))));
        assertFalse(bishop.equals(new Knight(new Location(0, 0))));
    }

}
