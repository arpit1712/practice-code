package com.arpit.samples.ctci.ch5;

public class Ans1
{
	public static void main(String[] args)
	{
		if(args.length < 4)	return;
		Ans1 sol = new Ans1();
		int result = sol.setBits(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		System.out.println(result);
	}

	public int setBits(int N, int M, int i, int j)
	{
		int max = ~0;
		
		int mask = max - ((1 << j) - 1);
		mask = mask | ((1 << i) - 1);
		
		mask &= N;
		mask |= M;
		return mask;
	}
}
