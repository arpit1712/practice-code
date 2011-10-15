package com.arpit.samples.trees;

import java.util.ArrayList;
import java.util.List;

public class MinBinaryHeapOld
{
	private List<Integer> base;
	private int heapSize;
	
	public MinBinaryHeapOld()
	{
		base = new ArrayList<Integer>();
		base.add(Integer.MIN_VALUE);	//dummy node at location 0
		
		heapSize = 0;
	}
	
	public void add(int value)
	{
		base.add(Integer.MAX_VALUE);
		heapSize++;
		this.decreaseKey(heapSize, value);
	}

	public int removeMin()
	{
		int min = base.get(1);
		//insert last element of heap onto first place
		base.set(1, base.get(this.heapSize));
		this.heapSize--;
		this.minHeapify();
		return min;
	}
	
	public void decreaseKey(int index, int newVal)
	{
		if(newVal > base.get(index))
		{
			//error
			return;
		}
		base.set(index, newVal);
		while(index > 1)
		{
			int parentIndex = getParentIndex(index);
			if(base.get(parentIndex) > base.get(index))
			{
				//exchange child and parent
				Integer temp = base.get(parentIndex);
				base.set(parentIndex, base.get(index));
				base.set(index, temp);
				
				//set index to parentIndex
				index = parentIndex;
			}
			else
			{
				break;	//already in place
			}
			
		}
	}
	
	private void minHeapify() 
	{
		for(int i = 1; i < this.heapSize/2 + 1;)
		{
			int smallest = base.get(i) < base.get(getLeftIndex(i)) ? i : getLeftIndex(i);
			smallest = base.get(smallest) < base.get(getRightIndex(i)) ? smallest : getRightIndex(i);
			
			if(smallest == i)
			{
				break;	//done
			}
			//exchange smallest and parent
			int temp = base.get(i);
			base.set(i, base.get(smallest));
			base.set(smallest, temp);
			
			i = smallest;
		}
	}
	
	private int getParentIndex(int index)
	{
		return index/2;
	}
	
	private int getLeftIndex(int index)
	{
		return 2*index;
	}
	
	private int getRightIndex(int index)
	{
		return 2*index + 1;
	}
}
