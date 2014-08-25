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
		s = s.replaceAll("ä", "ae");
		s = s.replaceAll("ü", "ue");
		s = s.replaceAll("ö", "oe");
		s = s.replaceAll("ß", "ss");
		return s;
	}

	private static String removeAccents(String s)
	{
		s = s.replaceAll("á", "a");
		s = s.replaceAll("à", "a");
		s = s.replaceAll("â", "a");
		s = s.replaceAll("é", "e");
		s = s.replaceAll("è", "e");
		s = s.replaceAll("ê", "e");
		s = s.replaceAll("ó", "o");
		s = s.replaceAll("ò", "o");
		s = s.replaceAll("ô", "o");
		s = s.replaceAll("ú", "u");
		s = s.replaceAll("ù", "u");
		s = s.replaceAll("û", "u");
		s = s.replaceAll("í", "i");
		s = s.replaceAll("ì", "i");
		s = s.replaceAll("î", "i");
		s = s.replaceAll("ø", "oe");
		return s;
	}
}
