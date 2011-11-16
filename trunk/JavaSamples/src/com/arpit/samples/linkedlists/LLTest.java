package com.arpit.samples.linkedlists;
public class LLTest
{
	public static void main(String[] args)
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = new int[]{5,4,3,2,1,1,2,3,4,5};
		for(int val : arr)
		{
			ll.append(val);
		}
		ll.print();
		//ll.reverseRec2();
		//ll.print();
		ll.mergeSort();
		ll.print();
	}
}
