package com.arpit.samples.random;

import java.util.*;

public class Iview
{
	public static int findMaxConsecutiveSum(int[] arr)
	{
		int localSum = 0;
		int globalSum = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			localSum += arr[i];
			if(localSum <=0)
			{
				localSum = 0;
			}
			if(localSum > globalSum)
			{
				globalSum = localSum;
			}
		}
		return globalSum;
	}

	public static void towerOfHanoi(int n, char t1, char t2, char t3)
	{
		if(n == 1)
		{
			System.out.println("Moving disk " + n + " from " + t1 + " to " + t3); 
			return;
		}
		towerOfHanoi(n-1, t1, t3, t2);
		System.out.println("Moving disk " + n + " from " + t1 + " to " + t3); 
		towerOfHanoi(n-1, t2, t1, t3);
	}
	
	public static int gcd(int a, int b)
	{
		if(a % b == 0)
			return b;
		return gcd(b, a % b);
	}

	public static void main(String[] args)
	{
		//if(args.length == 0)
		//	return ;
		System.out.println("max Sum = " + findMaxConsecutiveSum(new int[] {5,4,-3,-7,-2,2}));
		Iview.towerOfHanoi(3,'A', 'B', 'C');
		int a = 425, b = 850;
		System.out.println("GCD of " + a + " and " + b + " is " + gcd(a,b));
	}
}
