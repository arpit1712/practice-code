package com.arpit.samples.pie;

public class SearchTest
{
	public static void main(String[] args)
	{
		if(args.length == 0)
			return;

		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10, 10, 20, 30, 40, 50, 60, 70, 80};
		System.out.println("Recursive = " + Search.binarySearch(arr, 0, arr.length - 1, Integer.parseInt(args[0])));
		System.out.println("Iterative = " + Search.binarySearchIterative(arr, 0, arr.length - 1, Integer.parseInt(args[0])));
	}
}
