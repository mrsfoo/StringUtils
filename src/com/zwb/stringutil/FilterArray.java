package com.zwb.stringutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.awt.image.ImageRepresentation;

public class FilterArray implements ISatiniseFilterArray
{
    List<ISatiniseFilter> filters = new ArrayList<ISatiniseFilter>();
    
    public FilterArray(ISatiniseFilter... filters)
    {
	this(Arrays.asList(filters));
    }
    
    public FilterArray(List<ISatiniseFilter> filters)
    {
	this.filters = filters;
    }

    @Override
    public String filter(String input, boolean toLowerCase)
    {
	String s = new String(input);
	for(ISatiniseFilter f: this.filters)
	{
	    s = f.filter(s, toLowerCase);
	}
	return s;
    }

    @Override
    public ISatiniseFilterArray add(ISatiniseFilter filter)
    {
	this.filters.add(filter);
	return this;
    }
    
    @Override
    public String toString()
    {
	String s = "";
	for(ISatiniseFilter f: this.filters)
	{
	    s += "[" + f.toString() + "]";
	}
	return s;
    }
}
