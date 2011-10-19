package com.arpit.samples.sorting;

public class Sorter
{
	public static void doBubbleSort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = 0; j < arr.length - i - 1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					//swap a[i] and a[j]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	public static void doSelectionSort(int[] arr)
	{
		int min = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j < arr.length; j++)
			{
				if(arr[min] > arr[j])
				{
					min = j;
				}
			}
			//swap arr[i] and min if they are not same
			if(min != i)
			{
				//swap
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}

	public static void doInsertionSort(int[] a)
	{
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(a[j] < a[j-1])
				{
					//swap a[j], a[j-1]
					swap(a, j, j-1);
				}
				else
				{
					break;
				}
			}
		}
	}

	public static void doQuickSort(int[] arr)
	{
		doActualQuickSort(arr, 0, arr.length - 1);
	}

	private static void doActualQuickSort(int[] arr, int start, int end)
	{
		if(start >= end)
			return;
		int pivot = partition(arr, start, end);
		doActualQuickSort(arr, start, pivot - 1);
		doActualQuickSort(arr, pivot + 1, end);
	}

	private static int partition(int[] arr, int start, int end)
	{
		int pivot = arr[start];
		int i = end + 1;
		for(int j = end; j > start; j--)
		{
			if(arr[j] >= pivot)
			{
				--i;
				swap(arr, j, i);
			}
		}
		swap(arr, start, i-1);
		return i-1;
	}

	public static int[] doMergeSort(int[] arr)
	{
		return doActualMergeSort(arr, 0, arr.length-1);
	}

	private static int[] doActualMergeSort(int[] arr, int start, int end)
	{
		if(start == end)
			return new int[]{arr[start]};
		
		int mid = (start + end)/2;
		
		int[] leftArr = doActualMergeSort(arr, start, mid);
		int[] rightArr = doActualMergeSort(arr, mid + 1, end);
		return merge(leftArr, rightArr);
	}

	private static int[] merge(int[] leftArr, int[] rightArr)
	{
		int leftInd = 0;
		int rightInd = 0;
		int i = 0;
		int[] sortedArr = new int[leftArr.length + rightArr.length];
		while(leftInd < leftArr.length && rightInd < rightArr.length)
		{
			if(leftArr[leftInd] > rightArr[rightInd])
			{
				sortedArr[i++] = rightArr[rightInd++];
			}
			else
			{
				sortedArr[i++] = leftArr[leftInd++];
			}
		}

		//copy arrays into final array
		while(leftInd < leftArr.length)
		{
			sortedArr[i++] = leftArr[leftInd++];
		}
		while(rightInd < rightArr.length)
		{
			sortedArr[i++] = rightArr[rightInd++];
		}
		
		return sortedArr;
	}

	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
	}

	public static void main(String[] args)
	{
		int[] arr = {3, 2, 6, 1, -5};
		int[] safe = arr.clone();
		Sorter.doBubbleSort(arr);
		Sorter.print(arr);
		arr = safe.clone();
		Sorter.doSelectionSort(arr);
		Sorter.print(arr);
		arr = safe.clone();
		Sorter.doInsertionSort(arr);
		Sorter.print(arr);
		arr = safe.clone();
		Sorter.doQuickSort(arr);
		Sorter.print(arr);
		arr = safe.clone();
		int[] sorted = Sorter.doMergeSort(arr);
		Sorter.print(sorted);
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}
}
