package com.arpit.samples.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arpit.samples.graphs.Graph.Edge;
import com.arpit.samples.graphs.Graph.Node;
import com.arpit.samples.trees.Heapable;
import com.arpit.samples.trees.MinBinaryHeap;

public class GraphUtils
{
	class PriorityNode implements Heapable<PriorityNode>
	{
		int nodeId;
		Integer nodePriority;
		int indexInHeap;
		PriorityNode parent = null;
		
		public PriorityNode(int nodeId, int nodePriority)
		{
			this.nodeId = nodeId;
			this.nodePriority = nodePriority;
			this.indexInHeap = 0;	//default
		}

		@Override
		public int getIndexInHeap()
		{
			return indexInHeap;
		}

		@Override
		public void setIndexInHeap(int index) 
		{
			indexInHeap = index;
		}

		@Override
		public int getPriority() 
		{
			return this.nodePriority;
		}

		@Override
		public void setPriority(int priority) 
		{
			this.nodePriority = priority;
		}		
	}
	
	public void findPrimsMinSpanningTree(Graph g, int sourceNodeId)
	{
		//insert all nodes' distance in a priority queue
		MinBinaryHeap<PriorityNode> pq = new MinBinaryHeap<PriorityNode>();
		List<PriorityNode> priorityNodeRef = new ArrayList<PriorityNode>(g.mainList.size());

		for(int i = 0; i < g.mainList.size(); i++)
		{
			PriorityNode aNode = null;
			if(sourceNodeId == g.mainList.get(i).id)
			{
				aNode = new PriorityNode(g.mainList.get(i).id, 0);
			}
			else
			{
				aNode = new PriorityNode(g.mainList.get(i).id, Integer.MAX_VALUE);
			}
			pq.add(aNode);
//			priorityNodeRef.set(i, aNode);
			priorityNodeRef.add(aNode);
		}
		
		while(!pq.isEmpty())
		{
			PriorityNode minNode = pq.removeMin();
			priorityNodeRef.set(minNode.nodeId, null);
			
			//print this node
			printNodeStatus(minNode, minNode.parent);
			
			for(Edge anEdge : g.mainList.get(minNode.nodeId).adjacencyList)
			{
				PriorityNode destNode = priorityNodeRef.get(anEdge.destNode.id);
				if(destNode != null && destNode.nodePriority > anEdge.weight)
				{
					pq.decreaseKey(destNode.indexInHeap, anEdge.weight);
					priorityNodeRef.get(anEdge.destNode.id).parent = minNode;
				}
			}
		}
	}
	
	public void traverseBreadthFirst(Graph g, int sourceNodeId)
	{
		if(g.totalNodes == 0)
			return;
		
		LinkedList<Node> q = new LinkedList<Node>();
		Color[] nodesColor = new Color[g.totalNodes];
		int[] parentNodeList = new int[g.totalNodes];
		for(Node aNode : g.mainList)
		{
			nodesColor[aNode.id] = Color.WHITE;
			parentNodeList[aNode.id] = -1;	//no parent 
		}
		q.add(g.mainList.get(sourceNodeId));
		while(!q.isEmpty())
		{
			Node currentNode = q.removeFirst();
			nodesColor[currentNode.id] = Color.GRAY;
			printNodeStatus(currentNode, nodesColor[currentNode.id], parentNodeList[currentNode.id]);
			for(Edge anEdge : currentNode.adjacencyList)
			{
				if(nodesColor[anEdge.destNode.id] == Color.WHITE && !q.contains(anEdge.destNode))
				{
					parentNodeList[anEdge.destNode.id] = currentNode.id;
					q.add(anEdge.destNode);					
				}
			}
			nodesColor[currentNode.id] = Color.BLACK;
			printNodeStatus(currentNode, nodesColor[currentNode.id], parentNodeList[currentNode.id]);
		}
		
	}
	
	public void traverseDepthFirst(Graph g)
	{
		if(g.totalNodes == 0)
			return;
		Color[] nodesColor = new Color[g.totalNodes];
		int[] parentNodeList = new int[g.totalNodes];
		for(Node aNode : g.mainList)
		{
			nodesColor[aNode.id] = Color.WHITE;
			parentNodeList[aNode.id] = -1;	//no parent 
		}
		int time = 0;
		for(Node aNode : g.mainList)
		{
			if(nodesColor[aNode.id] == Color.WHITE)
			{
				time = doTraversal(aNode, nodesColor, parentNodeList, time);
			}
		}
	}
	
	private int doTraversal(Node node, Color[] nodesColor, int[] parentNodeList, int time)
	{
		time++;
		//turn the node gray - discovered
		nodesColor[node.id] = Color.GRAY;
		
		printNodeStatus(node.id, nodesColor[node.id], parentNodeList[node.id], time);
		
		//for all it's adjacent nodes, change parent and recurse
		for(Edge anEdge : node.adjacencyList)
		{
			if(nodesColor[anEdge.destNode.id] == Color.WHITE)
			{
				parentNodeList[anEdge.destNode.id] = node.id;
				time = doTraversal(anEdge.destNode, nodesColor, parentNodeList, time);
			}
		}
		
		//done with this node, turn it black, increase the time
		nodesColor[node.id] = Color.BLACK;
		time++;
		printNodeStatus(node.id, nodesColor[node.id], parentNodeList[node.id], time);
		return time;
	}

	private enum Color
	{
		WHITE,
		GRAY,
		BLACK;
	}

	private void printNodeStatus(Node currentNode, Color color, int parentNodeId)
	{
		System.out.println("Node=" + currentNode.id + " Color=" + color.toString() + " Parent=" + parentNodeId);
	}
	
	private void printNodeStatus(int id, Color color, int parentNodeId, int time)
	{
		System.out.println("Time = " + time);
		System.out.println("Node=" + id + " Color=" + color.toString() + " parent=" + parentNodeId);
		System.out.println();
	}
	
	private void printNodeStatus(PriorityNode currentNode, PriorityNode parentNode)
	{
		System.out.print("Node = " + currentNode.nodeId);
		if(parentNode != null)
			System.out.print(", Parent = " + parentNode.nodeId);
		System.out.println();
	}
}
