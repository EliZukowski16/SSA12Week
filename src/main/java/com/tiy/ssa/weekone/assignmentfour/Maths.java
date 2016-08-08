package com.tiy.ssa.weekone.assignmentfour;

public class Maths
{
    public static int squareRoot(int number)
    {
        int squareValue = 0;

        for (int i = 1; (i * i) <= number; i++)
        {
            squareValue = i;
        }

        return squareValue;
    }

    public static int cubeRoot(int number)
    {
        int cubeValue;

        if (number < 0)
        {
            cubeValue = -1;
            while ((cubeValue * cubeValue * cubeValue) >= number)
            {
                cubeValue--;
            }

            return (cubeValue + 1);
        }
        else
        {
            cubeValue = 1;
            while ((cubeValue * cubeValue * cubeValue) <= number)
            {
                cubeValue++;
            }

            return (cubeValue - 1);
        }
    }

    public static int logBaseTwo(int number)
    {
        int returnValue = 0;

        for (int i = 1, testValue = number; testValue >= 1; i++)
        {
            testValue /= 2;
            returnValue = i;
        }

        return returnValue - 1;
    }

    public static int logBaseThree(int number)
    {
        int returnValue = 0;
        int testValue = number;

        while (testValue >= 1)
        {
            testValue /= 3;
            returnValue++;
        }

        return returnValue - 1;
    }
}
