package com.arpit.samples.ctci.ch4;

public class Ans3 extends BST<Integer>
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5};
		Ans3 sol = new Ans3();
		Node root = sol.createTreeFromArray(arr, 0, arr.length - 1);
		System.out.println("Min Depth - " + sol.findMinDepth(root));
		System.out.println("Max Depth - " + sol.findMaxDepth(root));
		System.out.println("Inorder - " + sol.actualTraverseInorder(root));
	}

	public Node createTreeFromArray(int[] arr, int start, int end)
	{
		//find the mid point of the array, make mid element as root,
		//recurse over same function for left and right subarrays
		//make them as left and right nodes respectively.
		if(end < start)
			return null;
		int mid = (start + end)/2;
		Node root = new Node(arr[mid]);
		//System.out.println("Debug -- Start = " + start + ", end = " + end + ", arr[mid] = " + arr[mid]);
		root.left = createTreeFromArray(arr, start, mid-1);
		root.right = createTreeFromArray(arr, mid+1, end);
		return root;
	}
}
