package com.tiy.ssa.weekone.assignmenttwo;

public class Battery
{

	final float maxCapacity;
	float currentCharge;
	
	
	public Battery(float maxCapacity, float currentCharge)
	{
		this.maxCapacity = maxCapacity;
		this.currentCharge = currentCharge;
	}
	
	public float charge(float charge)
	{
		if((currentCharge + charge) > maxCapacity)
		{
			currentCharge = maxCapacity;
		}
		else
		{
			currentCharge += charge;
		}
		
		return currentCharge;
	}

	public float discharge(float charge)
	{
		if(currentCharge - charge < 0)
		{
			currentCharge = 0;
		}
		else
		{
			currentCharge -= charge;
		}
		return currentCharge;
	}

	public float getCharge()
	{
		return currentCharge;
	}
	
	
}
