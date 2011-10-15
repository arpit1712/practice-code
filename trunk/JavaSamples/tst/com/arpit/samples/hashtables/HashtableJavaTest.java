package com.arpit.samples.hashtables;

import java.util.UUID;
import java.util.Hashtable;
import org.junit.Assert;
import org.junit.Test;


public class HashtableJavaTest
{
    private static final int MAX = 1000;
    @Test
    public void insertAndRetrieveTest()
    {
        //first insert MAX entries into a hashtable
        //store MAX random keys in an array and MAX corresponding values
        String[] randomKeys = new String[MAX];
        String[] randomVals = new String[MAX];
        
        Hashtable<String, String> myHashTable = new Hashtable<String, String>();
        for(int i = 0; i < MAX; i++)
        {
            randomKeys[i] = UUID.randomUUID().toString();
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
//        myHashTable.printTable();
    }
}
