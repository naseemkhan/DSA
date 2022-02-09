package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.bouncycastle.util.Arrays;


//ShortestPath in undirected graph with unit weight
public class ShortestPathUndirectedGraph {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public ShortestPathUndirectedGraph(int v) {

		for(int i=0;i<v;i++)
		{adj.add(new ArrayList<Integer>());}
		
	
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public static void main(String[] args) {
		ShortestPathUndirectedGraph g = new ShortestPathUndirectedGraph(8);
		
		g.addEdge(0, 1);
		g.addEdge( 0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 5);
		g.addEdge( 4, 6);
		g.addEdge( 4, 7);
		g.addEdge( 5, 6);
		g.addEdge( 6, 7);
        shortestDistanceFromSourceToEachNode(8,0,adj);

	}
	private static void shortestDistanceFromSourceToEachNode(int v, int source, ArrayList<ArrayList<Integer>> adj2) {
		int[] distance=new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Queue<Integer> qu=new LinkedList<Integer>();
		distance[source]=0;
		qu.add(source);
		while(!qu.isEmpty())
		{
			int node=qu.poll();
			for(int it:adj.get(node))
			{
				if(distance[node]+1<distance[it])
				{
					distance[it]=distance[node]+1;
					qu.add(it);
				}
				
			}
		}
		for(int i=0;i<v;i++)
		System.out.println("source: "+source+" to destination: "+i+" shortest distance is "+distance[i]);
		
	}

}
