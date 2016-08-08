package com.tiy.ssa.weekone.assignmentfour;

import java.util.ArrayList;
import java.util.Vector;

public class Knight
{
    final Location startingLocation;
    Location currentLocation;

    ArrayList<Location> moves = new ArrayList<>();

    public Knight()
    {
        startingLocation = new Location(0, 0);
        currentLocation = startingLocation;

        moves.add(startingLocation);
    }

    public Knight(int x, int y)
    {
        startingLocation = new Location(x, y);
        currentLocation = startingLocation;

        moves.add(startingLocation);
    }

    void move()
    {
        boolean firstMove;
        double sumScale;
        double scaledWeight;
        double nextRandomDecision;
        int nextRandomMove;
        int[] xPossibleOffset = new int[]
        { -2, -1, 1, 2 };
        int[] yPossibleOffset = new int[]
        { -2, -1, 1, 2 };

        ArrayList<int[]> possibleMoves = new ArrayList<>();
        // Vector<Float> nextMoveDistance = new Vector<>();
        Vector<Double> nextMoveWeight = new Vector<>();
        Vector<Double> nextMoveScaled = new Vector<>();

        if (moves.size() == 1)
        {
            firstMove = true;
        }
        else
        {
            firstMove = false;
        }

        for (int x : xPossibleOffset)
        {
            for (int y : yPossibleOffset)
            {
                if (Math.abs(x) != Math.abs(y))
                {
                    possibleMoves.add(new int[]
                    { x, y });
                }
            }
        }

        for (int[] i : possibleMoves)
        {
            Location testLocation = currentLocation.offset(i[0], i[1]);
            double distance = 0;
            int distanceX = 0;
            int distanceY = 0;

            distanceX = currentLocation.x + startingLocation.x + i[0];
            distanceY = currentLocation.y + startingLocation.y + i[1];

            distance = (float) Math.sqrt((Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
            // nextMoveDistance.add(distance);
            // System.out.println(distance);
            // System.out.println(1/distance);
            if (!firstMove)
            {
                Location previousLocation = moves.get(moves.size() - 2);
                if ((testLocation.getLocation().equals(previousLocation.getLocation())))
                {
                    nextMoveWeight.add(0.0);
                }
                else if (distance == 1)
                {
                    nextMoveWeight.add(0.0);
                }
                else
                {
                    nextMoveWeight.add((1 / distance));
                }
            }
            else
            {
                nextMoveWeight.add((1 / distance));
            }
        }

        for (int j = 0; j < 5; j++)
        {
            if (!firstMove)
            {
                double lowestWeight = 1;
                int lowestWeightIndex = 0;
                for (int i = 0; i < nextMoveWeight.size(); i++)
                {
                    if ((nextMoveWeight.get(i) < lowestWeight) && (nextMoveWeight.get(i) != 0))
                    {
                        lowestWeightIndex = i;
                        lowestWeight = nextMoveWeight.get(i);
                    }
                }

                nextMoveWeight.setElementAt(0.0, lowestWeightIndex);
            }
        }

        for (double i : nextMoveWeight)
        {
            // System.out.println(i);
        }

        sumScale = 0;
        for (int i = 0; i < nextMoveWeight.size(); i++)
        {
            sumScale += nextMoveWeight.get(i);
        }

        scaledWeight = 0;
        for (int i = 0; i < nextMoveWeight.size(); i++)
        {
            if (nextMoveWeight.get(i) > 0)
            {
                scaledWeight += nextMoveWeight.get(i) / sumScale;
                nextMoveScaled.add(scaledWeight);
            }
            else
            {
                nextMoveScaled.add(0.0);
            }

            // System.out.println(nextMoveScaled.get(i));
        }

        nextRandomDecision = (float) Math.random();
        nextRandomMove = 0;

        for (int i = 0; i < nextMoveScaled.size(); i++)
        {
            if (nextMoveScaled.get(i) != 0)
            {
                if ((nextRandomDecision < nextMoveScaled.get(i))
                        && (nextRandomDecision > nextMoveScaled.get(nextRandomMove)))
                {
                    nextRandomMove = i;
                }
            }

        }

        Location nextLocation;
        int[] nextMove = possibleMoves.get(nextRandomMove);
        nextLocation = currentLocation.offset(nextMove[0], nextMove[1]);
        moves.add(nextLocation);
        currentLocation = nextLocation;
        // System.out.println(currentLocation.getLocation());

        // System.out.println(nextRandomDecision + " , " + nextRandomMove + " ,
        // " + nextMoveScaled.get(nextRandomMove));

        // if(moves.size() == 1)
        // {
        // Location nextLocation;
        // int[] nextMove = possibleMoves.get(((int)(Math.random() * 8)));
        // nextLocation = currentLocation.offset(nextMove[0], nextMove[1]);
        // moves.add(nextLocation);
        // currentLocation = nextLocation;
        // System.out.println(currentLocation.getLocation());
        // }
        // else
        // {
        //
        // }
        //

        // for(int[] move : possibleMoves)
        // {
        // System.out.println(move[0] + " " + move[1]);
        // }

        // System.out.println(testPosition[0]);
    }

    public void lazyMove()
    {
        Location nextLocation;

        switch ((moves.size() - 1) % 4)
        {
        case 0:
            nextLocation = currentLocation.offset(1, 2);
            moves.add(nextLocation);
            currentLocation = nextLocation;
            break;
        case 1:
            nextLocation = currentLocation.offset(2, -1);
            moves.add(nextLocation);
            currentLocation = nextLocation;
            break;
        case 2:
            nextLocation = currentLocation.offset(-1, -2);
            moves.add(nextLocation);
            currentLocation = nextLocation;
            break;
        case 3:
            nextLocation = currentLocation.offset(-2, 1);
            moves.add(nextLocation);
            currentLocation = nextLocation;
            break;
        }
    }

    public String getCurrentPosition()
    {
        return currentLocation.getLocation();
    }
    
    public String getHomePosition()
    {
        return startingLocation.getLocation();
    }

}
