package com.arpit.samples.linkedlists;

public class LinkedList<T>
{
	class Node
	{
		T data;
		Node next = null;
	}

	Node head = null;

	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++)
		list.insert(i);
		list.deleteLast();
		list.print();
	}
	
	private void insert(T data)
	{
		Node copy = head;
		Node newNode = new Node();
		newNode.data = data;
		
		if(copy == null)
		{
			head = newNode;
			return;
		}

		while(copy.next != null)
		{
			copy = copy.next;
		}
		
		copy.next = newNode;
	}

	private void deleteLast()
	{
		Node copy = head;
		if(copy == null)
			return;

		while(copy.next != null)
		{
			copy = copy.next;
		}

		copy = null;
	}
	
	private void print()
	{
		Node copy = head;
		while(copy != null)
		{
			System.out.println(copy.data);
			copy = copy.next;
		}
	}
}
