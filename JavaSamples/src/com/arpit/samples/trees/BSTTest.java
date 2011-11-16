package com.arpit.samples.trees;

import java.io.PrintStream;

public class BSTTest
{
  private BST bst = null;

	public static void main(String[] paramArrayOfString)
	{
		BSTTest test = new BSTTest();
		test.testPrintAllPaths();
		//test.testHasPathWithGivenSum();
	}

	public void testPrintAllPaths()
	{
		setup();
		bst.printAllPaths();
	}

	public void testHasPathWithGivenSum()
	{
		setup();
		System.out.println(bst.hasPathWithGivenSum(12));
		System.out.println(bst.hasPathWithGivenSum(13));
		System.out.println(bst.hasPathWithGivenSum(1));
	}

  public void testTraversePostorderIterative()
  {
    setup();
    this.bst.traversePostorderIterative();
  }

  public void testGetLeavesCount()
  {
    setup();
    System.out.println("Leaves Count in BST = " + this.bst.getLeavesCount());
    this.bst.insert(Integer.valueOf(100));
    this.bst.insert(Integer.valueOf(7));
    System.out.println("Leaves Count in BST = " + this.bst.getLeavesCount());
    this.bst.traverseInorderIterative();
    System.out.println(this.bst.levelOrderTraversal());
  }

  public void testLevelOrderTraversal() {
    setup();
    System.out.println(this.bst.levelOrderTraversal());
  }

  public void testIsBST()
  {
    setup();
    BST localBST = this.bst.getMirror();
    System.out.println("bst is BST = " + this.bst.isBST());
    System.out.println("mirror is BST = " + localBST.isBST());
  }

  public void testGetMirror()
  {
    setup();
    BST localBST = this.bst.getMirror();
    localBST.traverseInorderIterative();
  }

  private void setup()
  {
    int[] arrayOfInt = { 5, 3, 1, 4, 7, 6, 8 };
    this.bst = new BST();
    for (int i = 0; i < arrayOfInt.length; i++)
    {
      this.bst.insert(Integer.valueOf(arrayOfInt[i]));
    }
    this.bst.traverseInorder();
    System.out.println();
  }

  public void inorderTest()
  {
    setup();
    System.out.println("node count = " + this.bst.nodeCount());
    this.bst.traverseInorderIterative();
    this.bst.deleteNode(Integer.valueOf(1));
    this.bst.traverseInorder();
    System.out.println();
    System.out.println("node count = " + this.bst.nodeCount());
    System.out.println();
    this.bst.deleteNode(Integer.valueOf(8));
    this.bst.traverseInorder();
    System.out.println();
    System.out.println("node count = " + this.bst.nodeCount());
  }

  public void testIsIdentical()
  {
    setup();
    int[] arrayOfInt = { 5, 3, 1, 4, 7, 6, 8 };
    BST localBST1 = new BST();
    for (int i = 0; i < arrayOfInt.length; i++)
    {
      localBST1.insert(Integer.valueOf(arrayOfInt[i]));
    }
    System.out.println(this.bst.isIdentical(localBST1));
    localBST1.insert(Integer.valueOf(100));
    System.out.println(this.bst.isIdentical(localBST1));
    localBST1 = null;
    System.out.println(this.bst.isIdentical(localBST1));
    BST localBST2 = new BST();
    System.out.println(this.bst.isIdentical(localBST2));
  }
}
