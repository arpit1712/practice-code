package com.arpit.samples.pie;

public class Convert
{
	public static int ToInteger(String str)
	{
		char[] charArr = str.toCharArray();
		int coeff = 1;
		int i = 0;
		if (charArr[0] == '-')
		{
			coeff = -1;
			i++;
		}
		int value = 0;
		for(; i < charArr.length; i++)
		{
			value = value*10 + charArr[i] - '0';
		}
		
		return value*coeff;
	}

	public static String toString(int num)
	{
		StringBuilder sb = new StringBuilder();
		boolean minus = false;
		if(num < 0)
		{
			num *= -1;
			minus = true;
		}
		do
		{
			int digit = num % 10;
			num /= 10;
			sb.append(digit);
		}
		while(num > 0);
		
		if(minus)
			sb.append('-');
		
		return Strings.reverseStr(sb.toString());
	}
}
