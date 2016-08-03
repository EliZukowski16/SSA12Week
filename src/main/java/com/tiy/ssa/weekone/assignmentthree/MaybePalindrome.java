package com.tiy.ssa.weekone.assignmentthree;

public class MaybePalindrome
{
	
	final String value;
	
	public MaybePalindrome(String value) throws Exception
	{
		if(!value.isEmpty())
		{
			this.value = value;
		}
		else
		{
			throw new Exception();
		}
	}
	
	public boolean isPalindrome()
	{
		int decrementer = (value.length() - 1);
		int incrementer = 0;
		
		while(incrementer != decrementer)
		{
			if(value.toLowerCase().charAt(incrementer) != value.toLowerCase().charAt(decrementer))
			{
				return false;
			}
			
			incrementer++;
			decrementer--;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return this.value + (isPalindrome() ? " is": " isn't") + " a palindrome";
	}

}
