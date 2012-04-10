package com.arpit.samples.ctci.ch4;

public class Ans1
{
	public static void main(String[] args)
	{
		BST<Integer> tree = new BST<Integer>();
		int[] vals = {3,2,1,4,5};
		for(int val : vals)
		{
			tree.insert(val);
		}
		System.out.println(tree.traverseInorder());
		System.out.println("Min Depth - " + tree.findMinDepth());
		System.out.println("MaxDepth - " + tree.findMaxDepth());
		System.out.println("IsBalanced - " + tree.isBalanced());
	}
}
