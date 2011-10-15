package com.arpit.samples.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph
{
	protected class Node
	{
		public int id;
		public List<Edge> adjacencyList;
		
		public Node(int id)
		{
			this.id = id;
			this.adjacencyList = new LinkedList<Edge>();
		}

		public void print() 
		{
			//print the node's ID, value and then it's adjacency list
			System.out.print("Node=" + id + " -> ");
			for(Edge anEdge : adjacencyList)
			{
				System.out.print(anEdge.destNode.id + "(" + anEdge.weight + ")" + " -> ");
			}
		}
	}
	
	protected class Edge
	{
		public int weight;
		public Node destNode;
		
		public Edge(int weight, Node destNode)
		{
			this.weight = weight;
			this.destNode = destNode;
		}
	}
	
	protected List<Node> mainList;
	protected int totalNodes;
	
	public Graph()
	{
		mainList = new ArrayList<Node>();
		totalNodes = 0;
	}
	
	public void addNode()
	{
		Node aNode = new Node(totalNodes++);
		this.mainList.add(aNode);
	}
	
	public void addEdge(int sourceNodeId, int destinationNodeId, int weight)
	{
		//add a link
		Node sourceNode = mainList.get(sourceNodeId);
		Node destNode = mainList.get(destinationNodeId);
		sourceNode.adjacencyList.add(new Edge(weight, destNode));
		if(sourceNodeId != destinationNodeId)
			destNode.adjacencyList.add(new Edge(weight, sourceNode));	//this should be done only in case of undirected graph
	}
	
	public void print()
	{
		for(Node aNode : mainList)
		{
			aNode.print();
			System.out.println();
		}
		System.out.println();
	}
}
