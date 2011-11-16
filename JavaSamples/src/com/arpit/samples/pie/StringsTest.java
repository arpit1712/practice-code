package com.arpit.samples.pie;

import java.util.*;

public class StringsTest
{
	public static void main(String[] args)
	{
		if(args.length < 2)
		{
			System.out.println("pass string as an argument");
			return;
		}
		System.out.println(Strings.findFirstNonRepeating(args[0]));

		System.out.println(Strings.removeChars(args[0], args[1]));

		System.out.println(Strings.reverseStr(args[0], 0, args[0].length() - 1));
		System.out.println(Strings.reverseWords(args[0]));
		
		//permutations
		List<String> perms = Strings.permute(args[0]);
		for(String str : perms)
		{
			System.out.print(str + " " );
		}
		System.out.println();
	}
}
