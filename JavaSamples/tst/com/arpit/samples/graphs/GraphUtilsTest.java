package com.arpit.samples.graphs;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphUtilsTest
{
	static Graph myUndirectedGraph;
	static DirectedGraph myDirectedGraph;
	static GraphUtils graphUtils;
	
	@BeforeClass
	public static void setUp()
	{
		graphUtils = new GraphUtils();
		
		myUndirectedGraph = new Graph();
		myDirectedGraph = new DirectedGraph();
		
		//add nodes to graph
		for(int i = 0; i < 5; i++)
		{
			myUndirectedGraph.addNode();
			myDirectedGraph.addNode();
		}
		
		//add edges to graph
		Random rand = new Random();
		for(int i = 0; i < 6; i++)
		{
			myUndirectedGraph.addEdge(rand.nextInt(5), rand.nextInt(5), rand.nextInt(10));
		}
		
		for(int i = 0; i < 10; i++)
		{
			myDirectedGraph.addEdge(rand.nextInt(5), rand.nextInt(5), rand.nextInt(10) + 1);
		}
		
		System.out.println("Undirected Graph");
		myUndirectedGraph.print();
		
		System.out.println("Directed Graph");
		myDirectedGraph.print();
	}
	

	@Test
	public void testFindMinSpanningTree()
	{
		System.out.println("-----------------Find Min Spanning Tree-------------");
		graphUtils.findPrimsMinSpanningTree(myDirectedGraph, 0);
	}
	
	@Test
	public void testBFS()
	{
		System.out.println("-------------testBFS-----------------------");
		graphUtils.traverseBreadthFirst(myUndirectedGraph, 0);
	}
	
	@Test
	public void testDFS()
	{
		System.out.println("----------------testDFS--------------------");
		graphUtils.traverseDepthFirst(myUndirectedGraph);
	}
	
	@Test
	public void testDirectedBFS()
	{
		System.out.println("------------------testDirectedBFS------------------");
		graphUtils.traverseBreadthFirst(myDirectedGraph, 0);
	}
	
	@Test
	public void testDirectedDFS()
	{
		System.out.println("-------------------testDirectedDFS-----------------");
		graphUtils.traverseDepthFirst(myDirectedGraph);
	}

}
