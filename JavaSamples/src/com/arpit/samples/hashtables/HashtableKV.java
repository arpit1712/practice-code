package com.arpit.samples.hashtables;

import java.util.ArrayList;

/**
 * A hashtable implementation which uses separate chaining mechanism
 * @author Arpit
 */
public class HashtableKV<K, V>
{    
    class LinkedList<T>
    {
        class Node
        {
            protected K key = null;
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
        
        public void insert(K key, T value)
        {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            
            //insert at head            
            newNode.next = head;
            head = newNode;           
        }
        
        public T find(K key)
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
    
    public HashtableKV(int size)
    {
        this.baseTable = new ArrayList<LinkedList<V>>(size);
        for(int i = 0; i < size; i++)
        {
            baseTable.add(new LinkedList<V>());
        }
        //Initially 0 entries
        numEntries = 0;
    }
    
    public HashtableKV()
    {
        this(DEFAULT_SIZE);
    }
    
    public void put(K key, V value)
    {
        //TODO: check for loadFactor before inserting, if required, rehash
        
        int hash = findHash(key);
        LinkedList<V> aList = baseTable.get(hash);
        aList.insert(key, value);
        
        //increment numEntries count
        numEntries++;
    }
    
    public V get(K key)
    {
        int hash = findHash(key);
        LinkedList<V> aList = baseTable.get(hash);
        return aList.find(key);        
    }
    
    private int findHash(K key)
    {
        return hash(key.hashCode()) % this.baseTable.size();
    }
    
    /**
     * this function removes the minus sign (MSB - 1) of the default hashCode generated
     * @param hashCode any integer (usually generated through Object class's method hashCode()
     * @return a positive integer for given hashCode by shifting 1 bit to right
     */
    private int hash(int hashCode)
    {
        return hashCode >>> 1;
    }

    public void printTable()
    {
        for(LinkedList<V> aList : baseTable)
        {
            aList.printList();
        }
    }
}