import java.util.HashSet;
import java.util.Random;

public class LinkedList<T extends Comparable>
{
	private class Node
	{
		T data;
		Node next = null;
		
		public Node(T value)
		{
			this.data = value;
		}
		
		public void print()
		{
			System.out.print(" " + data + " ");
		}
	}
	
	private Node head = null;
	private int count = 0;

	public void append(T value)
	{
		Node newNode = new Node(value);
		
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			Node copy = head;
			while(copy.next != null)
			{
				copy = copy.next;
			}
			copy.next = newNode;
		}
		count++;
	}
	
	public void deleteNode(Node aNode)
	{
		if(aNode == head)
		{
			head = head.next;
		}
		else
		{
			//if aNode is not the last node,
			//copy the value from next node, delete next node
			/*if(aNode.next != null)
			{
				aNode.data = aNode.next.data;
				aNode.next = aNode.next.next;
			}
			else*/
			{
				Node copy = head;
				while(copy.next != aNode)
				{
					copy = copy.next;
				}
				copy.next = aNode.next;
			}
		}
	}

	public void print()
	{
		Node copy = head;
		int i = 0;
		while(copy != null && i < 3*count)
		{
			i++;
			copy.print();
			copy = copy.next;
		}
		System.out.println();
	}

	public void removeDups()
	{
		Node copy = head;
		HashSet<T> set = new HashSet<T>();
		while(copy != null)
		{
			if(set.contains(copy.data))
			{
				Node toDelete = copy;
				copy = copy.next;
				deleteNode(toDelete);
			}
			else
			{
				set.add(copy.data);
				copy = copy.next;
			}
		}
	}
	
	public T findNthToLast(int n)
	{
		Node copy = head;
		for(int i = 0; i < n+1; i++)
		{
			if(copy == null)
				return null;
			copy = copy.next;
		}
		Node newCopy = head;
		while(copy != null)
		{
			newCopy = newCopy.next;
			copy = copy.next;
		}
		return newCopy.data;
	}

	public T makeLoop()
	{
		if(head == null)
		{
			return null;
		}
		Node copy = head;
		int i = 0;
		Random rand = new Random();
		int randomNumber = rand.nextInt(count);
		Node randomNode = null;
		Node prvs = null;
		while(copy != null)
		{
			if(i == randomNumber)
			{
				randomNode = copy;
			}
			i++;
			prvs = copy;
			copy = copy.next;
		}

		prvs.next = randomNode;
		return randomNode.data;
	}
	
	public T findStartOfLoop()
	{
		Node slow = head;
		Node fast = head;
		do
		{
			if(fast == null || fast.next == null)
			{
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			//System.out.println("DEBUG: slow.data = " + slow.data + ", fast.data = " + fast.data);
		}while(slow != fast); 
		//System.out.println("DEBUG : out of first loop");
		//System.out.println("DEBUG : slow.data = " + slow.data + " , fast.data = " + fast.data);

		slow = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}

		return fast.data;
	}
}
