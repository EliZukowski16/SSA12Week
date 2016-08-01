package com.tiy.ssa.weekone.assignmentone;

public class Thermometer
{
	int thermometerTemperature;
	boolean thermometerFahrenheit;
	
	public Thermometer(int userTemperature)
	{
		this(userTemperature, true);
	}
	
	public Thermometer(int userTemperature, boolean userIsFahrenheit)
	{	
		thermometerTemperature = userTemperature;
		thermometerFahrenheit = userIsFahrenheit;
	}
	
	public int display(boolean doWeWantFahrenheit)
	{	
		if(doWeWantFahrenheit == thermometerFahrenheit)
		{
			return thermometerTemperature;
		}
		else if(doWeWantFahrenheit == true && thermometerFahrenheit == false)
		{
			thermometerTemperature = (int) Math.round(((9.0 * thermometerTemperature)/5.0 + 32.0));
		}
		else if(doWeWantFahrenheit == false && thermometerFahrenheit == true)
		{
			thermometerTemperature = (int) Math.round((((thermometerTemperature - 32.0) * 5.0) / 9.0));
		}
		
		return thermometerTemperature;
	
	}
	

}
