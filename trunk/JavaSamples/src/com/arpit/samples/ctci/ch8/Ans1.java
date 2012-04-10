package com.arpit.samples.ctci.ch8;

public class Ans1
{
	private java.util.HashMap<Integer, Long> computationMap = new java.util.HashMap<Integer, Long>();
	public Ans1()
	{
		computationMap.put(0, 0L);
		computationMap.put(1, 1L);
	}
	
	public static void main(String[] args)
	{
		if(args.length < 1) return;
		Ans1 sol = new Ans1();
		System.out.println(args[0] + "th Fibonacci no. is : " + sol.computeFib(Integer.parseInt(args[0])));
	}
	
	public long computeFib(int n)
	{
		if(n < 0)	return -1;

		//cache the computation in hashmap
		Long result = computationMap.get(n);
		if(result == null)
		{
			result = computeFib(n-1) + computeFib(n-2);
			computationMap.put(n, result);
		}
		return result.longValue();
	}
}
