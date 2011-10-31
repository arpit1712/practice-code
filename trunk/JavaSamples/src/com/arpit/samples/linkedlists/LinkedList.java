package com.arpit.samples.linkedlists;

public class LinkedList<T extends Comparable>
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

    private static final int MAX_COUNT = 50;

    protected Node head = null;

    public void append(T data)
    {
        Node copy = head;
        Node newNode = new Node();
        newNode.data = data;

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
        head = newNode;
    }

    public void reverse()
    {
        Node current = head;
        Node prvs = null;
        Node next = head.next;
        while (current != null)
        {
            next = current.next;
            current.next = prvs;
            prvs = current;
            current = next;
        }
        this.head = prvs;
    }

    public void reverseRecursive()
    {
        this.head = actualReverseRec(head);
    }

    private Node actualReverseRec(Node headNode)
    {
        if (headNode.next == null)
        {
            return headNode;
        }
        Node first = headNode;
        Node revListHead = actualReverseRec(headNode.next);
        Node headCopy = revListHead;
        while (headCopy.next != null)
        {
            headCopy = headCopy.next;
        }
        headCopy.next = first;
        first.next = null;
        return revListHead;
    }

    public void deleteLast()
    {
        if (this.head == null)
            return;

        Node copy = head;
        while (copy.next != null && copy.next.next != null)
        {
            copy = copy.next;
        }

        copy.next = null;
    }

    public void print()
    {
        Node copy = head;
        int count = 0;
        while (copy != null && count < MAX_COUNT)
        {
            System.out.print(copy.data + " ");
            copy = copy.next;
            count++;
        }
        System.out.println();
    }

    public boolean detectLoop()
    {
        if (head == null)
        {
            return false;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && slow != null)
        {
            if (fast == slow)
            {
                return true;
            }
            slow = slow.next;
            if (fast.next != null)
            {
                fast = fast.next.next;
            } else
            {
                fast = null;
            }
        }
        return false;
    }

    public void removeLoopIfExists()
    {
        if (head == null)
        {
            return;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && slow != null)
        {
            if (fast == slow)
            {
                break;
            }
            slow = slow.next;
            if (fast.next != null)
            {
                fast = fast.next.next;
            } else
            {
                fast = null;
            }
        }

        if (fast != null)
        {
            // count num nodes in loop
            Node copyFast = fast;
            int nodesInLoop = 0;
            while (copyFast.next != fast)
            {
                nodesInLoop++;
                copyFast = copyFast.next;
            }
            fast = head;
            while (nodesInLoop > 0)
            {
                fast = fast.next;
                nodesInLoop--;
            }

            slow = head;
            while (slow.next != fast.next)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            fast.next = null;
        }
    }

    public void printLoopStartNode()
    {
        if (head == null)
        {
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && slow != null)
        {
            if (fast == slow)
            {
                break;
            }
            slow = slow.next;
            if (fast.next != null)
            {
                fast = fast.next.next;
            } else
            {
                fast = null;
            }
        }

        if (fast != null)
        {
            // count num nodes in loop
            Node copyFast = fast;
            int nodesInLoop = 0;
            while (copyFast.next != fast)
            {
                // System.out.print("fast = " + fast.data + ", copyFast = " +
                // copyFast.data + "\n");
                nodesInLoop++;
                copyFast = copyFast.next;
            }
            fast = head;
            while (nodesInLoop > 1)
            {
                fast = fast.next;
                nodesInLoop--;
            }

            slow = head;
            while (slow != fast)
            {
                // System.out.print("fast = " + fast.data + ", slow = " +
                // slow.data + "\n");
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println(slow.data);
        }
    }

    public void reverseAltK(int k)
    {
        this.head = actualReverseAltK(k, this.head);
    }

    private Node actualReverseAltK(int k, Node startNode)
    {
        // work on 2K nodes and recurse on same function until end of list

        if (startNode == null)
        {
            return null;
        }

        Node first = startNode;
        Node current = startNode;
        Node prvs = null;
        Node next = current.next;
        for (int count = 0; count < k && current != null; count++)
        {
            next = current.next;
            current.next = prvs;
            prvs = current;
            current = next;
        }
        first.next = current;
        Node lastNode = prvs;
        for (int count = 0; count < k && current != null; count++)
        {
            lastNode = current;
            current = current.next;
        }
        if (lastNode != prvs)
        {
            lastNode.next = actualReverseAltK(k, current);
        }
        return prvs;
    }

    private Node sortedInsert(Node headNode, Node dataNode)
    {
        if (headNode == null)
        {
            headNode = dataNode;
            headNode.next = null;
            return headNode;
        }

        Node copy = headNode;
        while (copy.next != null && copy.CompareTo(dataNode) == -1)
        {
            copy = copy.next;
        }
        if (copy == headNode && copy.CompareTo(dataNode) >= 0)
        {
            dataNode.next = headNode;
            headNode = dataNode;
        }
        else
        {
            dataNode.next = copy.next;
            copy.next = dataNode;
        }
        return headNode;
    }

    public void insertSort()
    {
        if(this.head == null || this.head.next == null)
        {
            return;
        }
        Node headNode = null;
        Node copy = null, nextNode = null;
        for (copy = head, nextNode = this.head.next; copy != null && nextNode != null; copy = nextNode, nextNode = nextNode.next)
        {
            headNode = this.sortedInsert(headNode, copy);
        }
        this.head = this.sortedInsert(headNode, copy);
    }
}
