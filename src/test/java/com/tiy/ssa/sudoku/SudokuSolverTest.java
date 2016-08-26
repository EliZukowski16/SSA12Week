package com.tiy.ssa.sudoku;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SudokuSolverTest
{

    String[][] initialBoard;
    String[][] solvedBoard;
    SudokuSolver solver;

    @Before
    public void setup()
    {
        initialBoard = new String[][]
        {
                { "3", "0", "6", "5", "0", "8", "4", "0", "0" },
                { "5", "2", "0", "0", "0", "0", "0", "0", "0" },
                { "0", "8", "7", "0", "0", "0", "0", "3", "1" },
                { "0", "0", "3", "0", "1", "0", "0", "8", "0" },
                { "9", "0", "0", "8", "6", "3", "0", "0", "5" },
                { "0", "5", "0", "0", "9", "0", "6", "0", "0" },
                { "1", "3", "0", "0", "0", "0", "2", "5", "0" },
                { "0", "0", "0", "0", "0", "0", "0", "7", "4" },
                { "0", "0", "5", "2", "0", "6", "3", "0", "0" } 
        };
        
        solver = new SudokuSolver(initialBoard);

    }

    @Test
    public void testThatOriginalBoardIsWhatIsReadIn()
    {
        assertArrayEquals(initialBoard, solver.initialBoard);
        
        System.err.println(solver.solveBoard());
        System.err.println((solver.toString()));
    }

}
