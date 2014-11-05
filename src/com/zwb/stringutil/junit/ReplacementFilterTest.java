package com.zwb.stringutil.junit;

import com.zwb.stringutil.ISatiniseFilter.Location;
import com.zwb.stringutil.ReplacementFilter;

import junit.framework.TestCase;

public class ReplacementFilterTest extends TestCase
{
    public void testReplaceFirst()
    {
	String s0 = "1abc2de2fg44";
	String s1 = "12abc234de234f2g";
	String s2 = "000abcd324efg324";
	String s3 = "foo";
	String s4 = "";
	ReplacementFilter f = new ReplacementFilter("[0-9]", "***", Location.START);
	
	assertEquals("***abc2de2fg44", f.filter(s0, true));
	assertEquals("***2abc234de234f2g", f.filter(s1, true));
	assertEquals("***00abcd324efg324", f.filter(s2, true));
	assertEquals("foo", f.filter(s3, true));
	assertEquals("", f.filter(s4, true));

	assertEquals("***abc2de2fg44", f.filter(s0, false));
	assertEquals("***2abc234de234f2g", f.filter(s1, false));
	assertEquals("***00abcd324efg324", f.filter(s2, false));
	assertEquals("foo", f.filter(s3, false));
	assertEquals("", f.filter(s4, false));
    }
    
    public void testReplaceLast()
    {
	String s0 = "1abc2de2fg44";
	String s1 = "12abc234de234f2g";
	String s2 = "000abcd324efg324";
	String s3 = "foo";
	String s4 = "";
	ReplacementFilter f = new ReplacementFilter("[0-9]", "***", Location.END);
	
	assertEquals("1abc2de2fg4***", f.filter(s0, true));
	assertEquals("12abc234de234f2g", f.filter(s1, true));
	assertEquals("000abcd324efg32***", f.filter(s2, true));
	assertEquals("foo", f.filter(s3, true));
	assertEquals("", f.filter(s4, true));

	assertEquals("1abc2de2fg4***", f.filter(s0, false));
	assertEquals("12abc234de234f2g", f.filter(s1, false));
	assertEquals("000abcd324efg32***", f.filter(s2, false));
	assertEquals("foo", f.filter(s3, false));
	assertEquals("", f.filter(s4, false));
    }

    public void testReplaceAll()
    {
	String s0 = "1abc2de2fg44";
	String s1 = "12abc234de234f2g";
	String s2 = "000abcd324efg324";
	String s3 = "foo";
	String s4 = "";
	ReplacementFilter f = new ReplacementFilter("[0-2]", "***", Location.ALL);
	
	assertEquals("***abc***de***fg44", f.filter(s0, true));
	assertEquals("******abc***34de***34f***g", f.filter(s1, true));
	assertEquals("*********abcd3***4efg3***4", f.filter(s2, true));
	assertEquals("foo", f.filter(s3, true));
	assertEquals("", f.filter(s4, true));
	
	assertEquals("***abc***de***fg44", f.filter(s0, false));
	assertEquals("******abc***34de***34f***g", f.filter(s1, false));
	assertEquals("*********abcd3***4efg3***4", f.filter(s2, false));
	assertEquals("foo", f.filter(s3, false));
	assertEquals("", f.filter(s4, false));
    }

}
