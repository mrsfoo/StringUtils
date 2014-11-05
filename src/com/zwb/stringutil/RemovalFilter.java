package com.zwb.stringutil;

public class RemovalFilter extends ReplacementFilter implements ISatiniseFilter
{
    public RemovalFilter(String targetRegext, Location location)
    {
	super(targetRegext, "", location);
    }
    
    @Override
    public String toString()
    {
	return "RemovalFilter@"+this.location+": <"+this.targetRegext+">";
    }
}
