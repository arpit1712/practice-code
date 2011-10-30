package com.arpit.samples.linkedlists;

public class LinkedList<T>
{
	class Node
	{
		T data;
		Node next = null;
	}

    private static final int MAX_COUNT = 11;

	protected Node head = null;
	
	public void append(T data)
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

	public void insertAtHead(T data)
	{
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}

	public void deleteLast()
	{
		if(this.head == null)
			return;
		
		Node copy = head;
		while(copy.next != null && copy.next.next != null)
		{
			copy = copy.next;
		}

		copy.next = null;
	}
	
	public void print()
	{
		Node copy = head;
		int count = 0;
		while(copy != null && count < MAX_COUNT)
		{
			System.out.print(copy.data + " ");
			copy = copy.next;
			count++;
		}
	    System.out.println();
	}

	public boolean detectLoop()
	{
	    if(head == null)
	    {
	        return false;
	    }
		Node slow = head;
		Node fast = head.next;

		while(fast != null && slow != null)
        {
            if(fast == slow)
            {
                return true;
            }
            slow = slow.next;
            if(fast.next != null)
            {
                fast = fast.next.next;
            }
            else
            {
                fast = null;
            }
        }
        return false;
	}
		
	public void removeLoopIfExists()
	{
	    if(head == null)
        {
            return;
        }
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && slow != null)
        {
            if(fast == slow)
            {
                break;
            }
            slow = slow.next;
            if(fast.next != null)
            {
                fast = fast.next.next;
            }
            else
            {
                fast = null;
            }
        }
        
        if(fast != null)
        {
            //count num nodes in loop
            Node copyFast = fast;
            int nodesInLoop = 0;
            while(copyFast.next != fast)
            {
                nodesInLoop++;
                copyFast = copyFast.next;
            }
            fast = head;
            while(nodesInLoop > 0)
            {
                fast = fast.next;
                nodesInLoop--;
            }
            
            slow = head;
            while(slow.next != fast.next)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            fast.next = null;
        }
	}
	
	public void printLoopStartNode()
	{
	    if(head == null)
        {
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && slow != null)
        {
            if(fast == slow)
            {
                break;
            }
            slow = slow.next;
            if(fast.next != null)
            {
                fast = fast.next.next;
            }
            else
            {
                fast = null;
            }
        }
        
        if(fast != null)
        {
          //count num nodes in loop
            Node copyFast = fast;
            int nodesInLoop = 0;
            while(copyFast.next != fast)
            {
//                System.out.print("fast = " + fast.data + ", copyFast = " + copyFast.data + "\n");
                nodesInLoop++;
                copyFast = copyFast.next;
            }
            fast = head;
            while(nodesInLoop > 1)
            {
                fast = fast.next;
                nodesInLoop--;
            }
            
            slow = head;
            while(slow != fast)
            {
//                System.out.print("fast = " + fast.data + ", slow = " + slow.data + "\n");
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println(slow.data);
        }
	}

}
