package com.arpit.samples.graphs;

public class DirectedGraph extends Graph
{
	@Override
	public void addEdge(int sourceNodeId, int destNodeId, int weight)
	{
		Node sourceNode = this.mainList.get(sourceNodeId);
		Node destNode = this.mainList.get(destNodeId);
		
		sourceNode.adjacencyList.add(new Edge(weight, destNode));
	}
}
