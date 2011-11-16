package com.arpit.samples.pie;

public class ConvertTest
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage : java ConvertTest <value>");
			return;
		}
		int value = Convert.ToInteger(args[0]);
		System.out.println("int value = " + value);
		System.out.println("string conversion = " + Convert.toString(value));
	}
}
