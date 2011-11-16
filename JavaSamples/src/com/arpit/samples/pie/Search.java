package com.arpit.samples.pie;

public class Search
{
	public static int binarySearch(int[] arr, int start, int end, int target)
	{
		if(start > end)
		{
			return -1;
		}
	
		int mid = (start + end)/2;
		if(arr[mid] == target)
		{
			return mid;
		}
		else if(arr[mid] < target)
		{
			return binarySearch(arr, mid + 1, end, target);
		}
		else
		{
			return binarySearch(arr, start, mid - 1, target);
		}
	}

	public static int binarySearchIterative(int[] arr, int start, int end, int target)
	{
		while(start <= end)
		{
			int mid = (start + end)/2;
			if(arr[mid] == target)
			{
				return mid;
			}
			else if(arr[mid] < target)
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}
		return -1;
	}
}
