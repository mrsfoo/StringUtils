package com.zwb.stringutil;

public class StringReformat
{
	public static boolean equals(String string0, String string1)
	{
		return equals(string0, string1, false);
	}
	
	public static boolean equals(String string0, String string1, boolean removeStuff)
	{
		String s0 = reformat(string0);
		String s1 = reformat(string1);
		if(removeStuff)
		{
			s0 = removeStartingThe(s0);
			s1 = removeStartingThe(s1);
		}
		return s0.equals(s1);
	}

	public static double compareDice(String string0, String string1)
	{
		return compareDice(string0, string1, false);
	}
	
	public static double compareDice(String string0, String string1, boolean removeStuff)
	{
		String s0 = reformat(string0);
		String s1 = reformat(string1);
		if(removeStuff)
		{
			s0 = removeStartingThe(s0);
			s1 = removeStartingThe(s1);
		}
		return DiceCoefficient.compare(s0, s1);
	}
	
	public static double compareLevenshtein(String string0, String string1)
	{
		return compareLevenshtein(string0, string1, false);
	}
	
	public static double compareLevenshtein(String string0, String string1, boolean removeStuff)
	{
		String s0 = reformat(string0);
		String s1 = reformat(string1);
		if(removeStuff)
		{
			s0 = removeStartingThe(s0);
			s1 = removeStartingThe(s1);
		}
		return LevenshteinsAlgorithm.compare(s0, s1);
	}
	
	private static String removeStartingThe(String string)
	{
		if(string.startsWith("the "))
		{
			string = string.substring(4);
		}
		return string;
	}
	
	private static String reformat(String string)
	{
		String s = string.trim();
		s = s.toLowerCase();
		s = replaceUmlauts(s);
		s = removeAccents(s);
		return s;
	}
	
	private static String replaceUmlauts(String s)
	{
		s = s.replaceAll("�", "ae");
		s = s.replaceAll("�", "ue");
		s = s.replaceAll("�", "oe");
		s = s.replaceAll("�", "ss");
		return s;
	}

	private static String removeAccents(String s)
	{
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "oe");
		return s;
	}
}
