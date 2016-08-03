package com.tiy.ssa.weekone.assignmenttwo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisionBattery
{
	final BigDecimal maxKWH;
	BigDecimal currentKWH;
	
	public PrecisionBattery(BigDecimal maxKWH) throws Exception
	{
		this(maxKWH, maxKWH);
	}
	
	public PrecisionBattery(BigDecimal maxKWH, BigDecimal currentKWH) throws Exception
	{
		if(maxKWH.compareTo(BigDecimal.ZERO) >= 0 && currentKWH.compareTo(BigDecimal.ZERO) >= 0 && ((maxKWH.compareTo(currentKWH) >= 0)))
		{
			this.maxKWH = maxKWH;
			this.currentKWH = currentKWH;
		}
		else
		{
			throw new Exception();
		}
	}
	
	public BigDecimal charge(BigDecimal energy)
	{
		if(energy.compareTo(BigDecimal.ZERO) >= 0)
		{
			if((currentKWH.add(energy)).compareTo(maxKWH) > 0)
			{
				currentKWH = maxKWH;
			}
			else
			{
				currentKWH = currentKWH.add(energy);
			}
		}

		return currentKWH;
	}
	
	public BigDecimal discharge(BigDecimal energy)
	{
		if(energy.compareTo(BigDecimal.ZERO) >= 0) 
		{
			if((currentKWH.subtract(energy)).compareTo(BigDecimal.ZERO) < 0)
			{
				currentKWH = BigDecimal.ZERO;
			}
			else
			{
				currentKWH = currentKWH.subtract(energy);
			}
		}
	
		return currentKWH;
	}
	
	public int howLong(BigDecimal powerKW) throws Exception
	{
		if(powerKW.compareTo(BigDecimal.ZERO) > 0)
		{
			BigDecimal hours = currentKWH.divide(powerKW,20,RoundingMode.DOWN);
			BigDecimal minutes = hours.multiply(BigDecimal.valueOf(60));
			return minutes.intValue();
			
//			return (((currentKWH.divide(powerKW)).multiply(BigDecimal.valueOf(60))).intValue());
		}
		else
		{
			throw new Exception();
		}
		
	}
	
	public BigDecimal getCapacity()
	{
		return maxKWH;
	}
	
	public BigDecimal getRemaining()
	{
		return currentKWH;
	}

}
