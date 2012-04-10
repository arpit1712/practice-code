package com.arpit.samples.ctci.ch4;

public class Ans5<T extends Comparable<T>> extends BST<T>
{

	class NodeWithParent 
	{
		T data;
		NodeWithParent left = null;
		NodeWithParent right = null;
		NodeWithParent parent = null;
		public NodeWithParent(T data)
		{
			this.data = data;
		}
	}
		
	private NodeWithParent root = null;

	public static void main(String[] args)
	{
		Ans5<Integer> sol = new Ans5<Integer>();
		int[] arr = {5,2,7,3,1,6,8};
		for(int val : arr)
		{
			sol.insertNode(val);
		}

		System.out.println("Inorder Successor of " + sol.root.left.left.data + " is : " + sol.findInorderSuccessor(sol.root.left.left).data);
		System.out.println("Inorder Successor of " + sol.root.data + " is : " + sol.findInorderSuccessor(sol.root).data);
                System.out.println("Inorder Successor of " + sol.root.right.right.data + " is : " + sol.findInorderSuccessor(sol.root.right.right));

	}

	public NodeWithParent findInorderSuccessor(NodeWithParent aNode)
	{
		//Algo : 
		//1. if aNode.right != null, aNode.right is successor
		//2. else, if aNode is rightChild of it's parent, null is the successor
		//3. 	   else call findInorderSuccessor on aNode.parent
		
		if(aNode.right != null)
			return aNode.right;
		else
		{
			if(aNode.parent.right == aNode)
				return null;
			else
			{
				return findInorderSuccessor(aNode.parent);
			}
		}
	}

	public void insertNode(T val)
	{
		NodeWithParent newNode = new NodeWithParent(val);
		this.insert(newNode);
	}

	public void insert(NodeWithParent newNode)
	{
		if(this.root == null)
		{
			this.root = newNode;
		}
		else
		{
			NodeWithParent temp = this.root;
			while(true)
			{
				if(temp.data.compareTo(newNode.data) == 1)
				{
					//go left
					if(temp.left == null)
					{
						temp.left = newNode;
						break;
					}
					temp = temp.left;
				}
				else
				{
					//go right
					if(temp.right == null)
					{
						temp.right = newNode;
						break;
					}
					temp = temp.right;
				}
			}
			newNode.parent = temp;
		}
	}
}
