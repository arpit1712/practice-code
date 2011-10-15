package com.arpit.samples.hashtables;

import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;


public class HashtableTest
{
    private static final int MAX = 50;
    @Test
    public void insertAndRetrieveTest()
    {
        
        //first insert MAX entries into a hashtable
        //store 10 random keys in an array and 10 corresponding values
        int[] randomKeys = new int[MAX];
        String[] randomVals = new String[MAX];
        Random rand = new Random();
        
        Hashtable<String> myHashTable = new Hashtable<String>();
        for(int i = 0; i < MAX; i++)
        {
            randomKeys[i] = rand.nextInt((int)Math.pow(2, 20));
            randomVals[i] = UUID.randomUUID().toString();
            myHashTable.put(randomKeys[i], randomVals[i]);
        }
        //then retrieve all of them
        for(int i = 0; i < MAX; i++)
        {
            if(!myHashTable.get(randomKeys[i]).equals(randomVals[i]))
                Assert.fail();
        }
        
        //print list just to view
        myHashTable.printTable();
    }
}
