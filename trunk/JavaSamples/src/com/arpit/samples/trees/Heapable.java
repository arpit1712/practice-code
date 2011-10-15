package com.arpit.samples.trees;

public interface Heapable<T>
{
	int getPriority();
	void setPriority(int priority);
	
	int getIndexInHeap();
	void setIndexInHeap(int index);
}
