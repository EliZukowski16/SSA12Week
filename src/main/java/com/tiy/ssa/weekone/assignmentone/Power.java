package com.tiy.ssa.weekone.assignmentone;

public class Power
{
	public int powerOfOne(int root)
	{
		return root;
	}
	
	public int powerOfTwo(int root)
	{
		return (root * powerOfOne(root));
	}
	
	public int powerOfThree(int root)
	{
		return (root * powerOfTwo(root));
	}
}
