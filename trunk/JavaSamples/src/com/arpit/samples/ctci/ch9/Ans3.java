package com.arpit.samples.ctci.ch9;

public class Ans3
{
	public static void main(String[] args)
	{
		if(args.length < 1) return;
		Ans3 sol = new Ans3();
		int[] arr = {5,6,7,8,9,1,2,3,4};
		System.out.println("Position of element " + args[0] + " is : " + sol.rotatedBinarySearch(arr, 0, arr.length - 1, Integer.parseInt(args[0])));
	}

	public int rotatedBinarySearch(int[] arr, int low, int high, int key)
	{
		while(low <= high)
		{
			int mid = (low + high)/2;
			if(arr[mid] == key)	return mid;
			
			if(arr[low] <= arr[mid])
			{
				//left array is sorted
				if(key > arr[mid])
					low = mid + 1;
				else if(key >= arr[low])
					high = mid - 1;
				else 
					low = mid + 1;
			}
			else if(key < arr[mid])
				high = mid - 1;
			else if(key <= arr[high])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
