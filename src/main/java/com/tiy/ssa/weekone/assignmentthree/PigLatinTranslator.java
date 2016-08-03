package com.tiy.ssa.weekone.assignmentthree;

import java.util.ArrayList;

public class PigLatinTranslator
{
	final String normalText;
	
	public PigLatinTranslator(String normalText) throws Exception
	{
		if(!normalText.isEmpty())
		{
			this.normalText = normalText;
		}
		else
		{
			throw new Exception();
		}
	}
	
	public String translate()
	{
		ArrayList<String> translatedWords = new ArrayList<>();
		String translatedText = "";
		int numberOfWords;
		
		for(String s : normalText.split(" "))
		{
			translatedWords.add((s.length() < 2) ? ((s.matches("[aeiouAEIOU]")) ? (s + "way") : (s + "ay")): (translateWord(s)));			
		}
		
		numberOfWords = translatedWords.size();
		
		for(String s: translatedWords)
		{
			
			translatedText += s;
			if(numberOfWords > 1)
			{
				translatedText += " ";
				numberOfWords--;
			}
		}
		
		return translatedText;
	}

	private String translateWord(String s)
	{
		if(s.matches("^[aeiouAEIOU].*"))
		{
			String firstLetter = (s.substring(0,1).matches("[A-Z]")) ? s.substring(0,1).toUpperCase() : s.substring(0,1);
			String restOfString = s.substring(1) + "way";

			return (firstLetter + restOfString);
		}
		else if(s.matches("^.[aeiouAEIOU].*"))
		{
			String firstLetter = s.substring(0,1).toLowerCase() + "ay";
			String secondLetter = (s.matches("^[A-Z].*")) ? s.substring(1,2).toUpperCase() : s.substring(1,2);
			String restOfWord = (s.length() > 2) ? s.substring(2) : "";

			return (secondLetter + restOfWord + firstLetter);
		}
		else
		{
			String firstTwoLetters = (s.length() == 2) ? s.substring(0,2) + "ay" : s.substring(0,2).toLowerCase() + "ay";
			String thirdLetter = (s.length() > 2) ? (s.matches("^[A-Z].*") ? s.substring(2,3).toUpperCase() : s.substring(2,3)) : "";
			String restOfWord = (s.length() > 2) ? s.substring(3) : "";

			return (thirdLetter + restOfWord + firstTwoLetters);
		}

	}
	
	
	

}
