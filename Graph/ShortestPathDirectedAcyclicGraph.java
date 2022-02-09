package graph;

import java.util.ArrayList;
import java.util.Stack;

import org.bouncycastle.util.Arrays;

class Pair
{
	private int v;
	private int weight;
	Pair(int v,int weight)
	{
		this.v=v;
		this.weight=weight;
	}
	int getV()
	{
		return v;
	}
	int getWeight()
	{
		return weight;
	}
}

public class ShortestPathDirectedAcyclicGraph {
	private static ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
	
	void addEdge(int u,Pair pr)
	{
		adj.get(u).add(pr);
	}
	public ShortestPathDirectedAcyclicGraph(int n) {
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<Pair>());
		}
		
	}

	public static void main(String[] args) {
		ShortestPathDirectedAcyclicGraph g=new ShortestPathDirectedAcyclicGraph(6);

		
		
		
		g.addEdge(0, new Pair(1, 2));
		g.addEdge(0, new Pair(4, 1));
		g.addEdge(1, new Pair(2, 3));
		g.addEdge(2, new Pair(3, 6));
		g.addEdge(4, new Pair(2, 2));
		g.addEdge(4, new Pair(5, 4));
		g.addEdge(5, new Pair(3, 1));
		shortestDistanceFromSourceToEachNode(0,6,adj);
		

	}
	private static void shortestDistanceFromSourceToEachNode(int source, int numberOfVertices, ArrayList<ArrayList<Pair>> adj2) {
		int[] distance=new int[numberOfVertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Stack<Integer> stack=new Stack<Integer>();
		boolean[] visited=new boolean[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++)
		{
			if(!visited[i])
			{
				topologySort(i,stack,visited,adj);
			}
		}
		distance[source]=0;
		while(!stack.isEmpty())
		{
			int top=stack.pop();
			if(top!=Integer.MAX_VALUE)
			{
				for(Pair itr:adj.get(top))
				{
					if(distance[top]+itr.getWeight()<distance[itr.getV()])
					{
						distance[itr.getV()]=distance[top]+itr.getWeight();
					}
				}
			}
			
		}
		for (int i = 0; i < numberOfVertices; i++)
        {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( distance[i] + " ");
        }
	}
	
		
		
	private static void topologySort(int node,Stack<Integer> stack,  boolean[] visited,
			ArrayList<ArrayList<Pair>> adj) {		
		visited[node]=true;
		for(Pair it:adj.get(node))
		{
			if(!visited[it.getV()])
				topologySort(it.getV(),stack,visited,adj);
		}
		stack.add(node);
	}

		
		

}
