package com.tiy.ssa.weekone.assignmentfour;

import java.util.ArrayList;

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
	
//	public void move()
//	{
//		ArrayList<int[]> possibleMoves = new ArrayList<>();
//		
//		for(int i = 0; i < 4; i++)
//		{
//			switch(i)
//			{
//			case 0:
//				
//			}
//		}
//			
//		
////		System.out.println(testPosition[0]);
//	}
	
	public void lazyMove()
	{
		Location nextLocation;
		
		switch(moves.size())
		{
		case 1:
			nextLocation = currentLocation.offset(1, 2);
			moves.add(nextLocation);
			currentLocation = nextLocation;
			break;
		case 2:
			nextLocation = currentLocation.offset(2, -1);
			moves.add(nextLocation);
			currentLocation = nextLocation;
			break;
		case 3:
			nextLocation = currentLocation.offset(-1, -2);
			moves.add(nextLocation);
			currentLocation = nextLocation;
			break;
		case 4:
			nextLocation = currentLocation.offset(-2, 1);
			moves.add(nextLocation);
			currentLocation = nextLocation;
			break;
		}
	}
	
	public String getPosition()
	{
		return currentLocation.getLocation();
	}

}
