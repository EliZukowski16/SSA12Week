package com.tiy.ssa.weekone.assignmenttwo;

public class Battery
{

	final float maxKWH;
	float currentKWH;
	
	public Battery(float maxKWH) throws Exception
	{
		this(maxKWH, maxKWH);
	}
	
	public Battery(float maxKWH, float currentKWH) throws Exception
	{
		if(maxKWH >= 0 && currentKWH >= 0 && (currentKWH <= maxKWH))
		{
			this.maxKWH = maxKWH;
			this.currentKWH = currentKWH;
		}
		else
		{
			throw new Exception();
		}
	}
	
	public float charge(float energy)
	{
		if(energy >= 0)
		{
			if((currentKWH + energy) > maxKWH)
			{
				currentKWH = maxKWH;
			}
			else
			{
				currentKWH += energy;
			}
		}

		return currentKWH;
	}
	
	public float discharge(float energy)
	{
		if(energy >= 0) 
		{
			if(currentKWH - energy < 0)
			{
				currentKWH = 0;
			}
			else
			{
				currentKWH -= energy;
			}
		}
	
		return currentKWH;
	}
	
	public int howLong(float powerKW) throws Exception
	{
		if(powerKW > 0)
		{
			return (int) (60 * ((currentKWH / powerKW)));
		}
		else
		{
			throw new Exception();
		}
		
	}
	
	public float getCapacity()
	{
		return maxKWH;
	}
	
	public float getRemaining()
	{
		return currentKWH;
	}
	
}
