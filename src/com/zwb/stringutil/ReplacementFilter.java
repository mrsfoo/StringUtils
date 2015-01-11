package com.zwb.stringutil;

public class ReplacementFilter implements ISatiniseFilter
{
    protected String targetRegext;
    protected String replacement;
    protected Location location;
    
    public ReplacementFilter(String targetRegext, String replacement, Location location)
    {
	this.replacement = replacement;
	this.targetRegext = targetRegext;
	this.location = location;
    }
    
    private String filterCaseSensitive(String input, String targetRegex, String replacement)
    {
	String s = new String(input);
	switch(this.location)
	{
	    case ALL:
		return s.replaceAll(targetRegext, replacement);
	    case END:
		if(s.matches(".*"+targetRegext))
		{
		    return replaceLast(s, targetRegext, replacement);
		}
		break;
	    case START:
		if(s.matches(targetRegext+".*"))
		{
		    return s.replaceFirst(targetRegext, replacement);
		}
		break;
	    case EXCLUSIVE:
		if(s.matches(targetRegext))
		{
		    return s.replaceAll(targetRegext, replacement);
		}		
		break;
	    default:
		throw new RuntimeException("unknown filter type: "+this.location);
	}
	return s.trim();
    }
    
    private String filterCaseInsensitive(String input, String targetRegex, String replacement)
    {
	return filterCaseSensitive(input.toLowerCase(), targetRegex.toLowerCase(), replacement.toLowerCase());
    }
    
    public static String replaceLast(String text, String regex, String replacement)
    {
	return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
    }

    @Override
    public String filter(String input, boolean toLowerCase)
    {
	if(toLowerCase)
	{
	    return filterCaseInsensitive(input, this.targetRegext, this.replacement);
	}
	else
	{
	    return filterCaseSensitive(input, this.targetRegext, this.replacement);
	}
    }
    
    @Override
    public String toString()
    {
	return "ReplacementFilter@"+this.location+": <"+this.targetRegext+"> -> <"+this.replacement+">";
    }
}
