package com.arpit.samples.random;

public class Fibo
{
	int[] values = new int[100];
	
	public Fibo()
	{
		for(int i = 0; i < values.length; i++)
			values[i] = -1;
	}
	
	public int findFib(int n)
	{
		if(n >= 100)
			return -2;	//unsupported
		if(n <= 0)
			return 0;
		if(values[n] != -1)
			return values[n];
		
		values[n] = n <= 1 ? 1 : findFib(n-1) + findFib(n-2);
		return values[n];
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
			return;
		Fibo f = new Fibo();
		System.out.println("Fibonacci value = " + f.findFib(Integer.parseInt(args[0])));
	}
}
