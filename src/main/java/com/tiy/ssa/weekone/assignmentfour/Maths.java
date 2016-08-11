package com.tiy.ssa.weekone.assignmentfour;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Maths
{
    private static final Map<Integer, BigInteger> FACTORIALMAP = new HashMap<>();
    
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
    
    private static BigInteger calculateFactorial(int number)
    {
        BigInteger factorial = BigInteger.ONE;
        
        for(int i = 1; i <= number; i++)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            FACTORIALMAP.putIfAbsent(i, factorial);
        }
        
        return factorial;
    }
    
    public static BigInteger factorial(int number)
    {
        FACTORIALMAP.computeIfAbsent(number, f -> calculateFactorial(f));
        
        return FACTORIALMAP.get(number);
    }
    
    public static void clearFactorialMap()
    {
        FACTORIALMAP.clear();
    }
}
