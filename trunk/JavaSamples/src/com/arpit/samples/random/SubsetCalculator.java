package com.arpit.samples.random;

import java.util.*;

public class SubsetCalculator
{
	public static void main(String[] args)
	{
		SubsetCalculator sc = new SubsetCalculator();
		ArrayList<ArrayList<Integer>> allSubsets = sc.findSubsets(new int[]{1,2,3,4,5,});
		for(ArrayList<Integer> aSubset : allSubsets)
		{
			for(Integer anElement : aSubset)
			{
				System.out.print(anElement + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> findSubsets(int[] aSet)
	{
		ArrayList<ArrayList<Integer>> finalList = getSubset(aSet, 0, aSet.length-1);
		ArrayList<Integer> emptySet = new ArrayList<Integer>();
		finalList.add(emptySet);
		return finalList;
	}

	private ArrayList<ArrayList<Integer>> getSubset(int[] aSet, int start, int end)
	{
		//append first element to every subset found, also add this element as a set
		if(start == end)
		{
			ArrayList<ArrayList<Integer>> onlyMe = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(aSet[start]);
			onlyMe.add(temp);
			return onlyMe;
		}
		ArrayList<ArrayList<Integer>> allCombis = getSubset(aSet, start+1, end);
		int size = allCombis.size();
		for(int i = 0; i < size; i++)
		{
			ArrayList<Integer> copyList = new ArrayList<Integer>();
			copyList.addAll(allCombis.get(i));
			copyList.add(aSet[start]);
			allCombis.add(copyList);
		}
		ArrayList<Integer> meToo = new ArrayList<Integer>();
		meToo.add(aSet[start]);
		allCombis.add(meToo);
		return allCombis;
	}
}
