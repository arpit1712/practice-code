package com.arpit.samples.trees;

import java.util.Random;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;


public class MinBinaryHeapOldTest
{
	static MinBinaryHeapOld minHeap;
	
	@BeforeClass
	public static void setup()
	{
		minHeap = new MinBinaryHeapOld();
	}
	
	@Test
	public void getSortedList()
	{
		Random rand = new Random();
		for(int i = 0; i < 10; i++)
		{
			minHeap.add(rand.nextInt(100));
		}
		
		int lastElement = minHeap.removeMin();
		for(int i = 0; i < 10; i++)
		{
			System.out.println(lastElement + ", ");
			int currentElement = minHeap.removeMin();
			if(lastElement > currentElement)
				Assert.fail();
			lastElement = currentElement;
		}
		System.out.println(lastElement);
	}
}
