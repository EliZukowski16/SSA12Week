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
    public void kingBasicFunctionalityTests()
    {
        assertTrue(king.equals(new King(new Location(0, 0))));
        assertFalse(king.equals(new King(new Location(0, 1))));
        assertFalse(king.equals(new Rook(new Location(0, 0))));
        assertFalse(king.canMove(king.where()));

        ChessPiece king2 = new King(new Location(1, 1));
        ChessPiece king3 = new King(new Location(0, 0));

        assertEquals(-1, king.compareTo(king2));
        assertEquals(0, king.compareTo(king3));
        assertEquals(1, king2.compareTo(king));

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
                else if (i < 2 && j < 2)
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

        Location negativeOffBoard = new Location(-1, 0);
        Location positiveOffBoard = new Location(8, 7);

        assertFalse(king.canMove(negativeOffBoard));
        assertFalse(new King(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void bishopBasicFuntionalityTests()
    {
        assertTrue(bishop.equals(new Bishop(new Location(0, 0))));
        assertFalse(bishop.equals(new Bishop(new Location(1, 0))));
        assertFalse(bishop.equals(new Knight(new Location(0, 0))));
        assertEquals(0, bishop.compareTo(new Knight(new Location(0, 0))));
        assertFalse(bishop.canMove(bishop.where()));

        ChessPiece bishop2 = new Bishop(new Location(1, 1));
        ChessPiece bishop3 = new Bishop(new Location(0, 0));

        assertEquals(-1, bishop.compareTo(bishop2));
        assertEquals(0, bishop.compareTo(bishop3));
        assertEquals(1, bishop2.compareTo(bishop));

        Location validBishopMove;
        Location invalidBishopMove;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 0 && j == 0)
                {
                    invalidBishopMove = new Location(i, j);
                    assertFalse(bishop.canMove(invalidBishopMove));
                }
                else if (i == j)
                {
                    validBishopMove = new Location(i, j);
                    assertTrue(bishop.canMove(validBishopMove));
                }
                else
                {
                    invalidBishopMove = new Location(i, j);
                    assertFalse(bishop.canMove(invalidBishopMove));
                }
            }
        }

        Location negativeOffBoard = new Location(-1, 0);
        Location positiveOffBoard = new Location(8, 7);

        assertFalse(bishop.canMove(negativeOffBoard));
        assertFalse(new Bishop(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void rookBasicFunctionalityTests()
    {
        assertTrue(rook.equals(new Rook(new Location(0, 0))));
        assertFalse(rook.equals(new Rook(new Location(1, 0))));
        assertFalse(rook.equals(new Pawn(new Location(0, 0))));
        assertFalse(rook.canMove(rook.where()));

        ChessPiece rook2 = new Rook(new Location(1, 1));
        ChessPiece rook3 = new Rook(new Location(0, 0));

        assertEquals(-1, rook.compareTo(rook2));
        assertEquals(0, rook.compareTo(rook3));
        assertEquals(1, rook2.compareTo(rook));

        Location validRookMove;
        Location invalidRookMove;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 0 && j == 0)
                {
                    invalidRookMove = new Location(i, j);
                    assertFalse(rook.canMove(invalidRookMove));
                }
                else if (i == 0 || j == 0)
                {
                    validRookMove = new Location(i, j);
                    assertTrue(rook.canMove(validRookMove));
                }
                else
                {
                    invalidRookMove = new Location(i, j);
                    assertFalse(rook.canMove(invalidRookMove));
                }
            }
        }

        Location negativeOffBoard = new Location(-1, 0);
        Location positiveOffBoard = new Location(8, 7);

        assertFalse(rook.canMove(negativeOffBoard));
        assertFalse(new Rook(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void pawnBasicFunctionalityTests()
    {
        assertTrue(pawn.equals(new Pawn(new Location(0, 0))));
        assertFalse(pawn.equals(new Pawn(new Location(1, 0))));
        assertFalse(pawn.equals(new Queen(new Location(0, 0))));
        assertFalse(pawn.canMove(pawn.where()));

        ChessPiece pawn2 = new Pawn(new Location(1, 1));
        ChessPiece pawn3 = new Pawn(new Location(0, 0));

        assertEquals(-1, pawn.compareTo(pawn2));
        assertEquals(0, pawn.compareTo(pawn3));
        assertEquals(1, pawn2.compareTo(pawn));

        Location validRookMove;
        Location invalidRookMove;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 0 && j == 0)
                {
                    invalidRookMove = new Location(i, j);
                    assertFalse(pawn.canMove(invalidRookMove));
                }
                else if (i == 0 && j == 1)
                {
                    validRookMove = new Location(i, j);
                    assertTrue(pawn.canMove(validRookMove));
                }
                else
                {
                    invalidRookMove = new Location(i, j);
                    assertFalse(pawn.canMove(invalidRookMove));
                }
            }
        }

        Location negativeOffBoard = new Location(0, -1);
        Location positiveOffBoard = new Location(7, 8);

        assertFalse(pawn.canMove(negativeOffBoard));
        assertFalse(new Pawn(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void queenBasicFunctionalityTests()
    {
        assertTrue(queen.equals(new Queen(new Location(0, 0))));
        assertFalse(queen.equals(new Queen(new Location(1, 0))));
        assertFalse(queen.equals(new Bishop(new Location(0, 0))));
        assertFalse(queen.canMove(queen.where()));

        ChessPiece queen2 = new Queen(new Location(1, 1));
        ChessPiece queen3 = new Queen(new Location(0, 0));

        assertEquals(-1, queen.compareTo(queen2));
        assertEquals(0, queen.compareTo(queen3));
        assertEquals(1, queen2.compareTo(queen));

        Location validQueenMove;
        Location invalidQueenMove;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 0 && j == 0)
                {
                    invalidQueenMove = new Location(i, j);
                    assertFalse(queen.canMove(invalidQueenMove));
                }
                else if (i == j)
                {
                    validQueenMove = new Location(i, j);
                    assertTrue(queen.canMove(validQueenMove));
                }
                else if (i == 0 || j == 0)
                {
                    validQueenMove = new Location(i, j);
                    assertTrue(queen.canMove(validQueenMove));
                }
                else
                {
                    invalidQueenMove = new Location(i, j);
                    assertFalse(queen.canMove(invalidQueenMove));
                }
            }
        }

        Location negativeOffBoard = new Location(0, -1);
        Location positiveOffBoard = new Location(7, 8);

        assertFalse(queen.canMove(negativeOffBoard));
        assertFalse(new Queen(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void knightBasicFunctionalityTests()
    {
        assertTrue(knight.equals(new Knight(new Location(0, 0))));
        assertFalse(knight.equals(new Knight(new Location(1, 0))));
        assertFalse(knight.equals(new King(new Location(0, 0))));
        assertFalse(knight.canMove(knight.where()));

        ChessPiece knight2 = new Knight(new Location(1, 1));
        ChessPiece knight3 = new Knight(new Location(0, 0));

        assertEquals(-1, knight.compareTo(knight2));
        assertEquals(0, knight.compareTo(knight3));
        assertEquals(1, knight2.compareTo(knight));

        Location validKnightMove;
        Location invalidKnightMove;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 0 && j == 0)
                {
                    invalidKnightMove = new Location(i, j);
                    assertFalse(knight.canMove(invalidKnightMove));
                }
                else if (i == 1 && j == 2)
                {
                    validKnightMove = new Location(i, j);
                    assertTrue(knight.canMove(validKnightMove));
                }
                else if (i == 2 && j == 1)
                {
                    validKnightMove = new Location(i, j);
                    assertTrue(knight.canMove(validKnightMove));
                }
                else
                {
                    invalidKnightMove = new Location(i, j);
                    assertFalse(knight.canMove(invalidKnightMove));
                }
            }
        }

        Location negativeOffBoard = new Location(-2, -1);
        Location positiveOffBoard = new Location(8, 9);

        assertFalse(knight.canMove(negativeOffBoard));
        assertFalse(new Knight(new Location(7, 7)).canMove(positiveOffBoard));
    }

    @Test
    public void pieceComparisonTests()
    {
        assertEquals(1, king.compareTo(queen));
        assertEquals(1, queen.compareTo(rook));
        assertEquals(1, rook.compareTo(bishop));
        assertEquals(0, bishop.compareTo(knight));
        assertEquals(1, knight.compareTo(pawn));
        assertEquals(-1, pawn.compareTo(king));

        assertFalse(king.equals(queen));
        assertFalse(queen.equals(rook));
        assertFalse(rook.equals(bishop));
        assertFalse(bishop.equals(knight));
        assertFalse(knight.equals(pawn));
    }
}
