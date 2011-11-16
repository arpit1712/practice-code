package com.arpit.samples.trees;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Stack;
import java.util.*;
public class BST<T extends Comparable<T>>
{
  private BST<T>.Node root = null;

  public BST<T>.Node findMin(BST<T>.Node paramBST)
  {
    BST<T>.Node localBST = null;
    while (paramBST != null)
    {
      localBST = paramBST;
      paramBST = paramBST.left;
    }
    return localBST;
  }

  public BST<T>.Node findInorderSuccessor(BST<T>.Node paramBST)
  {
    if (paramBST == null)
    {
      return null;
    }

    if (paramBST.right != null)
    {
      return findMin(paramBST.right);
    }

    Object localObject = paramBST;
    while (localObject != this.root)
    {
      if (localObject == ((Node)localObject).parent.left)
      {
        return ((BST<T>.Node)localObject).parent;
      }
      localObject = ((Node)localObject).parent;
    }
    return null;
  }

  public void deleteNode(T paramT)
  {
    if (this.root == null)
      return;
    BST<T>.Node localNode1 = this.root;
    BST<T>.Node localNode2 = null;
    while (localNode1 != null)
    {
      localNode2 = localNode1;
      if (localNode1.data.compareTo(paramT) == 0)
      {
        break;
      }
      if (localNode1.data.compareTo(paramT) == 1)
      {
        localNode1 = localNode1.left; continue;
      }

      localNode1 = localNode1.right;
    }

    if (localNode1 == null)
      return;
    Node localNode3;
    if ((localNode1.left == null) || (localNode1.right == null))
    {
      localNode3 = null;
      if (localNode1.left == null)
      {
        localNode3 = localNode1.right;
      }
      else
      {
        localNode3 = localNode1.left;
      }
      if (localNode1 == this.root)
      {
        this.root = localNode3;
      }
      else if (localNode1 == localNode1.parent.left)
      {
        localNode1.parent.left = localNode3;
      }
      else
      {
        localNode1.parent.right = localNode3;
      }
    }
    else
    {
      localNode3 = findInorderSuccessor(localNode1);
      localNode1.data = localNode3.data;

      if (localNode3.parent.right == localNode3)
      {
        localNode3.parent.right = localNode3.right;
      }
      else
      {
        localNode3.parent.left = localNode3.right;
      }
    }
  }

  public void insert(T paramT)
  {
    Node localNode1 = new Node(paramT);
    if (this.root == null)
    {
      this.root = localNode1;
      return;
    }
    Node localNode2 = this.root;
    Node localNode3 = null;
    while (localNode2 != null)
    {
      localNode3 = localNode2;
      if (localNode2.data.compareTo(paramT) == 1)
      {
        localNode2 = localNode2.left; continue;
      }

      localNode2 = localNode2.right;
    }

    if (localNode3.data.compareTo(paramT) == 1)
    {
      localNode3.left = localNode1;
    }
    else
    {
      localNode3.right = localNode1;
    }
    localNode1.parent = localNode3;
  }

  public void traverseInorder()
  {
    actualTraverseInorder(this.root);
  }

  private void actualTraverseInorder(BST<T>.Node paramBST)
  {
    if (paramBST == null)
      return;
    actualTraverseInorder(paramBST.left);
    paramBST.print();
    actualTraverseInorder(paramBST.right);
  }

  public void traverseInorderIterative()
  {
    Stack localStack = new Stack();

    Node localNode1 = this.root;
    while (true)
    {
      if (localNode1 != null)
      {
        localStack.push(localNode1);
        localNode1 = localNode1.left;
        continue;
      }
      if (localStack.empty())
        break;
      Node localNode2 = (Node)localStack.pop();
      localNode2.print();
      localNode1 = localNode2.right;
    }
    System.out.println();
  }

  public int nodeCount()
  {
    return actualCount(this.root);
  }

  public int actualCount(BST<T>.Node paramBST)
  {
    if (paramBST == null)
      return 0;
    return actualCount(paramBST.left) + actualCount(paramBST.right) + 1;
  }

  public boolean isIdentical(BST<T> paramBST)
  {
    if (paramBST == null)
      return false;
    if ((this.root == null) && (paramBST.root == null))
      return true;
    if ((this.root == null) || (paramBST.root == null))
      return false;
    return findIsIdentical(this.root, paramBST.root);
  }

  private boolean findIsIdentical(BST<T>.Node paramBST1, BST<T>.Node paramBST2)
  {
    if ((paramBST1 == null) && (paramBST2 == null))
      return true;
    if ((paramBST1 == null) || (paramBST2 == null))
      return false;
    if (paramBST1.data.compareTo(paramBST2.data) != 0) {
      return false;
    }
    return (findIsIdentical(paramBST1.left, paramBST2.left)) && (findIsIdentical(paramBST1.right, paramBST2.right));
  }

  public BST getMirror()
  {
    BST<T> localBST = new BST<T>();
    localBST.insert(this.root.data);
    createMirror(this.root, localBST.root);
    return localBST;
  }

  private void createMirror(BST<T>.Node paramBST1, BST<T>.Node paramBST2)
  {
    if (paramBST1 == null) {
      return;
    }
    BST<T>.Node localNode1 = null; BST<T>.Node localNode2 = null;
    if (paramBST1.right != null)
    {
      localNode1 = new Node(paramBST1.right.data);
      localNode1.parent = paramBST2;
    }
    if (paramBST1.left != null)
    {
      localNode2 = new Node(paramBST1.left.data);
      localNode2.parent = paramBST2;
    }
    paramBST2.left = localNode1;
    paramBST2.right = localNode2;

    createMirror(paramBST1.right, paramBST2.left);
    createMirror(paramBST1.left, paramBST2.right);
  }

  public boolean isBST()
  {
    return checkIsBST(this.root);
  }

  private boolean checkIsBST(BST<T>.Node paramBST)
  {
    if (paramBST == null)
      return true;
    if (((paramBST.left != null) && (paramBST.data.compareTo(paramBST.left.data) < 0)) || ((paramBST.right != null) && (paramBST.data.compareTo(paramBST.right.data) > 0)))
    {
      return false;
    }
    return (checkIsBST(paramBST.left)) && (checkIsBST(paramBST.right));
  }

  public String levelOrderTraversal()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(this.root);
    localLinkedList.add(null);
    while (!localLinkedList.isEmpty())
    {
      Node localNode = (Node)localLinkedList.removeFirst();
      if (localNode == null)
      {
        localStringBuilder.append("\n");
        if (localLinkedList.isEmpty()) {
          break;
        }
        localLinkedList.add(null);
      }
      else
      {
        localStringBuilder.append(new StringBuilder().append(" ").append(localNode.data).append(" ").toString());
        if (localNode.left != null)
          localLinkedList.add(localNode.left);
        if (localNode.right != null)
          localLinkedList.add(localNode.right);
      }
    }
    return localStringBuilder.toString();
  }

  public int getLeavesCount()
  {
    return getActualLeavesCount(this.root);
  }

  private int getActualLeavesCount(BST<T>.Node paramBST)
  {
    if (paramBST == null)
      return 0;
    if ((paramBST.left == null) && (paramBST.right == null))
      return 1;
    return getActualLeavesCount(paramBST.left) + getActualLeavesCount(paramBST.right);
  }

	public void printAllPaths()
	{
		ArrayList<Node> path = new ArrayList<Node>();
		actualPrintAllPaths(this.root, path);
	}

	private void actualPrintAllPaths(Node root, ArrayList<Node> path)
	{
		if(root == null)
		{
			printList(path);
			return;
		}
		path.add(root);
		actualPrintAllPaths(root.left, (ArrayList)path.clone());
		actualPrintAllPaths(root.right, (ArrayList)path.clone());
	}

	private void printList(List<Node> aList)
	{
		for(Node n : aList)
		{
			n.print();
		}
		System.out.println();
	}

	/**
	* This function explores only the paths from root to leaf.
	*/
	public boolean hasPathWithGivenSum(int sum)
	{
		return findPathWithGivenSum(this.root, sum);
	}

	private boolean findPathWithGivenSum(Node root, int sum)
	{
		if(root == null && sum == 0)
			return true;
		if(root == null || sum < 0)
		{
			return false;
		}
		else
		{
			return findPathWithGivenSum(root.left, sum - Integer.parseInt(root.data.toString()))
				|| findPathWithGivenSum(root.right, sum - Integer.parseInt(root.data.toString()));
		}
	}

  public void traversePostorderIterative()
  {
    Stack localStack = new Stack();
    Object localObject = this.root;
    while (true)
    {
      if (localObject != null)
      {
        if (((Node)localObject).right != null)
        {
          localStack.push(((Node)localObject).right);
        }
        localStack.push(localObject);
        localObject = ((Node)localObject).left;
        continue;
      }
      if (localStack.isEmpty())
      {
        break;
      }
      Node localNode1 = (Node)localStack.pop();
      if ((localNode1.right != null) && (!localStack.isEmpty()) && (localNode1.right == localStack.peek()))
      {
        Node localNode2 = (Node)localStack.pop();
        localStack.push(localNode1);
        localObject = localNode2;
        continue;
      }
      localNode1.print();
    }
    System.out.println();
  }

  class Node
  {
    T data;
    BST<T>.Node left = null;
    BST<T>.Node right = null;
    BST<T>.Node parent = null;

    public Node(T data)
    {
      this.data = data;
    }

    public void print()
    {
      System.out.print(" " + this.data + " ");
    }
  }
}
