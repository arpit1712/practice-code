package com.arpit.samples.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class MinBinaryHeapTest
{
	protected class MyInteger implements Heapable<MyInteger>
	{
		private Integer value;
		private int index;
		
		public MyInteger(Integer value)
		{
			this.value = value;
		}
		
		@Override
		public int getIndexInHeap() {
			return index;
		}

		@Override
		public void setIndexInHeap(int index) 
		{
			this.index = index;
		}

		@Override
		public int getPriority() {
			return value;
		}

		@Override
		public void setPriority(int priority) {
			this.value = priority;
		}
		
	}
	static MinBinaryHeap<MyInteger> minHeap;
	static List<MyInteger> refList;
	
	@BeforeClass
	public static void setup()
	{
		minHeap = new MinBinaryHeap<MyInteger>();
		refList = new ArrayList<MyInteger>();
		insertInMinHeap();
	}
	
	private static void insertInMinHeap()
	{
		refList.clear();
		Random rand = new Random();
		MinBinaryHeapTest minHeapTest = new MinBinaryHeapTest();
		for(int i = 0; i < 10; i++)
		{
			MyInteger anInt = minHeapTest.new MyInteger(rand.nextInt(100));
			minHeap.add(anInt);
			refList.add(anInt);
		}
	}

	@Test
	public void getSortedListTest()
	{		
		MyInteger lastElement = minHeap.removeMin();
		while(!minHeap.isEmpty())
		{
			System.out.println(lastElement.value + ", ");
			MyInteger currentElement = minHeap.removeMin();
			if(lastElement.value > currentElement.value)
				Assert.fail();
			lastElement = currentElement;
		}
		System.out.println(lastElement.value);
		System.out.println("------------------------");
	}
	
	@Test
	public void decreaseKeyTest()
	{
		//randomly decrease any key and run getSortedListTest again
		for(int i = 0; i < 5; i++)
		{
			//restore heap to normal 
			insertInMinHeap();
			{
				MyInteger aRandomObj = refList.get((new Random()).nextInt(7) + 3);
				minHeap.decreaseKey(aRandomObj.index, aRandomObj.value - 20);
				getSortedListTest();
			}
		}
	}
}