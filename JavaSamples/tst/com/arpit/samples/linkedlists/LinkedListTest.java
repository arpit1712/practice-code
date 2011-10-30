package com.arpit.samples.linkedlists;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest
{
    private LinkedList<Integer> list = null;
    @Before
    public void setup()
    {
        list = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++)
        {
            list.append(i);
//            list.insertAtHead(i);
        }
        list.print();
    }
    
    @Test
    public void testLastDelete()
    {
        System.out.println("\nnow deleting last element");
        list.deleteLast();
        list.print();
    }
    
    @Test
    public void testListWithNoLoop()
    {
        Assert.assertEquals(false, list.detectLoop());
    }
    
    @Test
    public void testListWithLoop()
    {
        this.makeLoop();
        Assert.assertEquals(true, list.detectLoop());
    }
    
    private void makeLoop()
    {
      //make a loop, point last node's next to somewhere in the middle of list
        LinkedList<Integer>.Node copy = list.head;
        while(copy.next != null)
        {
            copy = copy.next;
        }
        copy.next = list.head.next.next.next.next.next.next;
    }
    
    @Test
    public void testRemoveLoop()
    {
        this.makeLoop();
        Assert.assertEquals(true, list.detectLoop());
        list.print();
        list.printLoopStartNode();
        list.removeLoopIfExists();
        Assert.assertEquals(false, list.detectLoop());
        list.print();
    }
}
