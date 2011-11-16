package com.arpit.samples.pie;

import java.util.*;

public class Strings
{
	public static char findFirstNonRepeating(String str)
	{
		char[] origStr = str.toCharArray();
		int[] countArr = new int[256];
		for(char ch : origStr)
		{
			countArr[(int)ch] += 1;
		}
		for(char ch : origStr)
		{
			if(countArr[(int)ch] == 1)
			{
				return ch;
			}
		}
		return 0;
	}

	public static String removeChars(String orig, String remove)
	{
		StringBuilder sb = new StringBuilder();
		char[] removeChars = remove.toCharArray();
		boolean[] lookup = new boolean[128];
		for(char ch : removeChars)
		{
			lookup[ch] = true;
		}
		int len = orig.length();
		for(int i = 0; i < len; i++)
		{
			if(!lookup[orig.charAt(i)])
			{
				sb.append(orig.charAt(i));
			}
		}
		return sb.toString();
	}

	public static String reverseWords(String str)
	{
		String reversed = Strings.reverseStr(str, 0, str.length() - 1);
		StringBuilder buffer = new StringBuilder();
		int start = 0;
		for(int i = 0; i < reversed.length(); i++)
		{
			if(reversed.charAt(i) == ' ')
			{
				buffer.append(Strings.reverseStr(reversed, start, i));
				buffer.append(' ');
				start = i+1;
			}
		}
		buffer.append(Strings.reverseStr(reversed, start, reversed.length() -1));	//last one
		return buffer.toString();
	}

	public static String reverseStr(String str, int start, int end)
	{
		char[] charArr = str.toCharArray();
		//int start = 0;
		//int end = str.length() - 1;
		while(start < end)
		{
			char temp = charArr[start];
			charArr[start++] = charArr[end];
			charArr[end--] = temp;
		}
		return new String(charArr);
	}

	public static String reverseStr(String str)
	{
		return Strings.reverseStr(str, 0, str.length() - 1);
	}

	public static java.util.List<String> permute(String str)
	{
		if(str.length() == 1)
		{
			List<String> list = new ArrayList<String>();
			list.add(str);
			return list;
		}
		String firstChar = str.substring(0,1);
		String rest = str.substring(1);
		return place(firstChar, permute(rest));
	}
	
	private static java.util.List<String> place(String first, List<String> bunch)
	{
		java.util.List<String> allPerms = new java.util.ArrayList<String>();
		for(String str : bunch)
		{
			int i = 0;
			while(i < str.length())
			{
				allPerms.add(str.substring(0,i) + first + str.substring(i));
				i++;
			}
			allPerms.add(str + first);
		}
		return allPerms;
	}
	
	public static List<String> getCombinations(String str)
	{
                List<String> allCombis = new ArrayList<String>();
		getActualCombis(allCombis, str);
		return allCombis;
	}

	private static void getActualCombis(List<String> allCombis, String str)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    private static void getAllCombis(List<String> allCombis, String str)
	{
		int origSize = allCombis.size();
		//duplicate existing elements
		for(String aStr : allCombis)
		{
			allCombis.add(aStr);
		}
		if(str.length() == 1)
                {
                        join(str, allCombis, origSize);
			allCombis.add(str);
                        return;
                }
                String firstChar = str.substring(0,1);
                String rest = str.substring(1);
		getAllCombis(allCombis, rest);
		join(firstChar, allCombis, allCombis.size()/2);
		allCombis.add(firstChar);
	}

    private static void join(String str, List<String> allCombis, int origSize)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

}
