package com.arpit.samples.ctci.ch4;

public class Ans4
{
	public static void main(String[] args)
	{
		BST<Integer> tree = new BST<Integer>();
		int[] vals = {3,2,1,4,5,6,7,8,9};
		for(int val : vals)
		{
			tree.insert(val);
		}
		System.out.println(tree.traverseInorder());
		System.out.println("Min Depth - " + tree.findMinDepth());
		System.out.println("MaxDepth - " + tree.findMaxDepth());
		System.out.println("IsBalanced - " + tree.isBalanced());
		System.out.println("Level wise traversal---------------\n" + tree.traversePerLevel());
	}
}
