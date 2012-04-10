import java.util.*;

public class LinkedList<T extends Comparable<T>>
{
    class Node
    {
        T data;
        Node next = null;

        public int CompareTo(Node dataNode)
        {
             return data.compareTo(dataNode.data);
        }
    }

    protected Node head = null;
	private int size = 0;

    public void append(T data)
    {
        Node copy = head;
        Node newNode = new Node();
        newNode.data = data;

	size++;
        if (copy == null)
        {
            head = newNode;
            return;
        }

        while (copy.next != null)
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
        size++;
	head = newNode;
    }

    public void print()
    {
        Node copy = head;
        int count = 0;
        while (copy != null && count < size)
        {
            System.out.print(copy.data + " ");
            copy = copy.next;
            count++;
        }
        System.out.println();
    }

	public boolean findLoop()
	{
		Node slow = head;
		if(head.next == null)
			return false;
		Node fast = head.next;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}

	public void makeLoop()
	{
		if(findLoop())	return;		//return if there is a loop already;
		Random rand = new Random();
		int num = rand.nextInt(size);
		Node temp = head;
		for(int i = 0; i < num; i++)
		{
			temp = temp.next;
		}

		Node tail = head;
		while(tail.next != null)
		{
			tail = tail.next;
		}

		tail.next = temp;
	}
}
