package com.arpit.samples.trees;

import java.util.ArrayList;
import java.util.List;

public class MinBinaryHeap<T extends Heapable<T>>
{
	private List<T> base;
	private int heapSize;
	
	public MinBinaryHeap()
	{
		base = new ArrayList<T>(100);
		base.add(0,null);	//dummy node at location 0
		
		heapSize = 0;
	}
	
	public void add(T value)
	{
		heapSize++;
		base.add(heapSize, value);	//added but not at correct location
		this.decreaseKey(heapSize, value.getPriority());
	}

	public T removeMin()
	{
		if(heapSize > 0)
		{
			T min = base.get(1);
			//insert last element of heap onto first place
			base.set(1, base.get(this.heapSize));
			this.heapSize--;
			this.minHeapify();
			return min;
		}
		return null;
	}
	
	public void decreaseKey(int indexInHeap, int newPriority)
	{
		T item = base.get(indexInHeap);
		if(newPriority > item.getPriority())
		{
			//error
			return;
		}
		item.setPriority(newPriority);
		while(indexInHeap > 1)
		{
			int parentIndex = getParentIndex(indexInHeap);
			T parent = base.get(parentIndex);
			if(parent.getPriority() > item.getPriority())
			{
				//exchange child and parent
				T temp = base.get(parentIndex);
				base.set(parentIndex, item);
				base.set(indexInHeap, temp);
				//update parent's index too
				parent.setIndexInHeap(indexInHeap);
				
				//set index to parentIndex
				indexInHeap = parentIndex;
			}
			else
			{
				break;	//already in place
			}
		}
		//index has been set, update for this node
		item.setIndexInHeap(indexInHeap);
	}
	
	private void minHeapify() 
	{
		for(int i = 1; i < this.heapSize/2 + 1;)
		{
			int smallest = base.get(i).getPriority() < base.get(getLeftIndex(i)).getPriority() ? i : getLeftIndex(i);
			smallest = base.get(smallest).getPriority() < base.get(getRightIndex(i)).getPriority() ? smallest : getRightIndex(i);
			
			if(smallest == i)
			{
				break;	//done
			}
			//exchange smallest and parent
			T temp = base.get(i);
			base.set(i, base.get(smallest));
			base.set(smallest, temp);
			//set index for every element shuffled as well
			base.get(smallest).setIndexInHeap(i);
			temp.setIndexInHeap(smallest);
			
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

	public boolean isEmpty() 
	{
		return heapSize == 0 ? true : false;
	}
}
