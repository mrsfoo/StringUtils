package com.zwb.stringutil;

public class StringReformat
{
    public static double compare(String string0, String string1, ComparisonAlgorithm comparisonAlgorithm)
    {
	if((string0==null) && (string1==null))
	{
	    return 1;
	}
	else if(string0==null)
	{
	    return 0;
	}
	else if(string1==null)
	{
	    return 0;
	}
	
	if(string0.isEmpty() && string1.isEmpty())
	{
	    return 1;
	}
	else if(string0.isEmpty())
	{
	    return 0;
	}
	else if(string1.isEmpty())
	{
	    return 0;
	}
	
	if(comparisonAlgorithm==ComparisonAlgorithm.DICE_COEFFICIENT)
	{
	    return compareDice(string0, string1);
	}
	else if(comparisonAlgorithm==ComparisonAlgorithm.LEVENSHTEIN)
	{
	    return compareLevenshtein(string0, string1);
	}
	else
	{
	    throw new RuntimeException("WTF?! this should never happen!");
	}
    }
    
    public static boolean equals(String string0, String string1)
    {
	String s0 = reformat(string0);
	String s1 = reformat(string1);
	return s0.equals(s1);
    }
    
    private static double compareDice(String string0, String string1)
    {
	String s0 = reformat(string0);
	String s1 = reformat(string1);
	return DiceCoefficient.compare(s0, s1);
    }
    
    private static double compareLevenshtein(String string0, String string1)
    {
	String s0 = reformat(string0);
	String s1 = reformat(string1);
	return LevenshteinsAlgorithm.compare(s0, s1);
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
