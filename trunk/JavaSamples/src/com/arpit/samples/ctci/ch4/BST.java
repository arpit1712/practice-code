package com.arpit.samples.ctci.ch4;

public class BST<T extends Comparable<T>>
{
	class Node
	{
		T data;
		Node left = null;
		Node right = null;
		public Node(T data, Node left, Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(T data)
		{
			this.data = data;
		}
	}

	protected Node root = null;
	
	public void insert(T data)
	{
		Node newNode = new Node(data);
		
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			Node temp = root;
			Node prvs = null;
			while(temp != null)
			{
				prvs = temp;
				if(data.compareTo(temp.data) == -1)
				{
					//goto left
					temp = temp.left;
				}
				else
				{
					//goto right
					temp = temp.right;
				}
			}
			if(data.compareTo(prvs.data) == -1)
			{
				prvs.left = newNode;
			}
			else
			{
				prvs.right = newNode;
			}
		}
	}

	public String traverseInorder()
	{
		return actualTraverseInorder(this.root);
	}

	public String actualTraverseInorder(Node rootNode)
	{
		if(rootNode == null)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(" " + actualTraverseInorder(rootNode.left) + " ");
		sb.append(" " + rootNode.data + " ");
		sb.append(" " + actualTraverseInorder(rootNode.right) + " ");
		return sb.toString();
	}

	public boolean isBalanced()
	{
		//find minDepth and find maxDepth and check if the absolute difference is >= 2
		int minDepth = findMinDepth(this.root);
		int maxDepth = findMaxDepth(this.root);
		return Math.abs(minDepth - maxDepth) <= 1;
	}

	public int findMinDepth()
	{
		return findMinDepth(this.root);
	}

	public int findMaxDepth()
	{
		return findMaxDepth(this.root);
	}

	protected int findMinDepth(Node rootNode)
	{
		if(rootNode != null)
		{
			return 1 + Math.min(findMinDepth(rootNode.left), findMinDepth(rootNode.right));
		}
		return 0;
	}
	
	protected int findMaxDepth(Node rootNode)
	{
		if(rootNode != null)
		{
			return 1 + Math.max(findMaxDepth(rootNode.left), findMaxDepth(rootNode.right));
		}
		return 0;
	}

	public String traversePerLevel()
	{
		if(root == null)
			return "";
		StringBuffer sb = new StringBuffer();
		LinkedList<Node> q = new LinkedList<Node>();
		q.append(this.root);
		q.append(null);
		traversePerLevel(q, sb);
		return sb.toString();
	}

	protected void traversePerLevel(LinkedList<Node> q, StringBuffer sb)
	{
		Node prvs = null;
		Node aNode = null;
		do
		{
			prvs = aNode;
			aNode = q.removeHead();
			if(aNode == null)
			{
				q.append(null);
				sb.append("\n");
			}
			else
			{
				sb.append(aNode.data + " ");
				if(aNode.left != null)
				{
					q.append(aNode.left);
				}
				if(aNode.right != null)
				{
					q.append(aNode.right);
				}
			}
		}while(aNode != null || prvs != null);
	}
}
