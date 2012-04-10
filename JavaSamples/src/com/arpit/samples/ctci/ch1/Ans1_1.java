package com.arpit.samples.ctci.ch1;

import java.util.HashMap;

public class Ans1_1
{
	public boolean allUnique(String str)
	{
		HashMap<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		char[] chars = str.toCharArray();
		for(char ch : chars)
		{
			if(charMap.containsKey(ch))
			{
				charMap.put(ch, false);
			}
			else
			{
				charMap.put(ch, true);
			}
		}
		
		for(Boolean isUnique : charMap.values())
		{
			if(!isUnique)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Usage : java Ans1_1 <string1> <string2> ...");
			return;
		}
		
		Ans1_1 obj = new Ans1_1();
		for(String str : args)
		{
			System.out.println(str + " : " + obj.allUnique(str));
		}
	}
}
