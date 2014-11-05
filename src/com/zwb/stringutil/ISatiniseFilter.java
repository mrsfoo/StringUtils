package com.zwb.stringutil;

public interface ISatiniseFilter
{
    enum Location {START, END, ALL}
    
    public String filter(String input, boolean toLowerCase);    
}
