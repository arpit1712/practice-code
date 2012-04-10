package com.arpit.samples.ctci.ch3;

public class Ans1
{
	private static final int STACK_SIZE = 300;
	private int[] tops = {-1,-1,-1};
	private class StackNode
	{
		int data;
		int next;
	}
	private StackNode[] arr = new StackNode[STACK_SIZE];

	private LinkedList<Integer> freeList = new LinkedList<Integer>();
	
	public Ans1()
	{
		for(int i = 0; i < arr.length; i++)
		{
			freeList.append(i);
		}
	}

	public static void main(String[] args)
	{
		Ans1 obj = new Ans1();
		int[] arr = {1,2,3,4,5};
		for(int element : arr)
		{
			obj.push(0,element);
			obj.push(1,element);
			obj.push(2, element);
		}
		obj.print(0);
		obj.print(1);
		obj.print(2);
		
		obj.pop(0);
		obj.pop(0);
		obj.print(0);
		obj.print(1);
		obj.print(2);

		obj.push(0,10); obj.push(0,20);
		obj.print(0);
	}

	public void push(int stackId, int value)
	{
		StackNode newNode = new StackNode();
		newNode.data = value;
		newNode.next = tops[stackId];
		int newTop = freeList.removeHead();
		arr[newTop] = newNode;
		tops[stackId] = newTop;
	}

	public int pop(int stackId)
	{
		StackNode top = arr[tops[stackId]];
		freeList.append(tops[stackId]);
		tops[stackId] = top.next;
		return top.data;
	}
	
	public void print(int stackId)
	{
		System.out.println("Stack - " + stackId);
		StackNode top = arr[tops[stackId]];
		while(true)
		{
			System.out.println(top.data);
			if(top.next == -1)	break;
			top = arr[top.next];
		}
		System.out.println();
	}
	
	private void printArray()
	{
		for(StackNode node : arr)
		{
			if(node == null) break;
			System.out.print(" " + node.data + "," + node.next + " ");
		}
		System.out.println();
	}

	private void printTops()
	{
		for(int top : tops)
			System.out.println(" " + top + " ");
		System.out.println();
	}

	private void printFreeListHead()
	{
		System.out.println(freeList.removeHead());
	}
}
