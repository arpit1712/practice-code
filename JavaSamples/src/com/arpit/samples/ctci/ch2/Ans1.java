package com.arpit.samples.ctci.ch2;

public class Ans1
{
        public static void main(String[] args)
        {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = new int[]{2,3,1,4,2,1,4,1,0,5,-20,40};
		for(int element : arr)
		{
			ll.append(element);
		}
		ll.print();
		ll.removeDups();
		ll.print();
        }
}

