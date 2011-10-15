package com.arpit.samples.hashtables;

import java.util.ArrayList;

/**
 * A hashtable implementation which uses separate chaining mechanism
 * @author Arpit
 */
public class Hashtable<V>
{    
    class LinkedList<T>
    {
        class Node
        {
            protected Integer key = null;
            protected T value = null;
            protected Node next = null;
            
            public void printNode()
            {
                System.out.print(" <" + key + ", " + value + "> ");
            }
        }
        
        private Node head;
        
        public LinkedList()
        {
            this.head = null;
        }
        
        public void insert(Integer key, T value)
        {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            
            //insert at head            
            newNode.next = head;
            head = newNode;           
        }
        
        public T find(Integer key)
        {
            Node copy = head;
            while(copy != null)
            {
                if(copy.key.equals(key))
                {
                    return copy.value;
                }
                copy = copy.next;
            }
            return null;
        }
        
        public void printList()
        {
            Node copy = head;
            while(copy != null)
            {
                copy.printNode();
                copy = copy.next;
            }
            System.out.println("*");
        }
    }
    
    private ArrayList<LinkedList<V>> baseTable;
    private static final int DEFAULT_SIZE = 32;
    private static int numEntries;
    
    public Hashtable(int size)
    {
        this.baseTable = new ArrayList<LinkedList<V>>(size);
        for(int i = 0; i < size; i++)
        {
            baseTable.add(new LinkedList<V>());
        }
        //Initially 0 entries
        numEntries = 0;
    }
    
    public Hashtable()
    {
        this(DEFAULT_SIZE);
    }
    
    public void put(int key, V value)
    {
        //TODO: check for loadFactor before inserting, if required, rehash
        
        int hash = findHash(key);
        LinkedList<V> aList = baseTable.get(hash);
        aList.insert(key, value);
        
        //increment numEntries count
        numEntries++;
    }
    
    public V get(int key)
    {
        int hash = findHash(key);
        LinkedList<V> aList = baseTable.get(hash);
        return aList.find(key);        
    }

    private int findHash(int key)
    {
        return key % baseTable.size();
    }
    
    public void printTable()
    {
        for(LinkedList<V> aList : baseTable)
        {
            aList.printList();
        }
    }
}
