package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteUndirectedGraph {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public CheckBipartiteUndirectedGraph(int v) {
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
		
	}
	void addEdge(int i, int j) {
		adj.get(i).add(j);
		//for undirected graph
		adj.get(j).add(i);
	}
	public static void main(String[] args) {
		CheckBipartiteUndirectedGraph g = new CheckBipartiteUndirectedGraph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);

		g.addEdge(3, 0);
		g.addEdge(3, 2);
		System.out.println(checkBipartiteGraphDFS(4,adj));

	}
	private static boolean checkBipartiteGraphBFS(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] colored=new int[v];
		Arrays.fill(colored, -1);
		for(int i=0;i<v;i++)
		{
			if(colored[i]==-1)
			{
				if(!isBipartiteBFS(i,colored,adj))
					return false;
			}
		}
		return true;
	}
	private static boolean isBipartiteBFS(int i, int[] colored, ArrayList<ArrayList<Integer>> adj2) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(i);
		colored[i]=1;
		while(!queue.isEmpty())
		{
			Integer node=queue.poll();
			for(Integer j:adj.get(node))
			{
				if(colored[j]==-1)
				{
					queue.add(j);
					colored[j]=1-colored[node];
				}
				else if(colored[j]==colored[node])
					return false;
			}
		}
		
		return true;
	}
	
	private static boolean checkBipartiteGraphDFS(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] colored=new int[v];
		Arrays.fill(colored, -1);
		for(int i=0;i<v;i++)
		{
			if(colored[i]==-1)
			{
				if(!isBipartiteDFS(i,colored,adj))
					return false;
			}
		}
		return true;
	}
	private static boolean isBipartiteDFS(int i, int[] colored, ArrayList<ArrayList<Integer>> adj2) {
		
		if(colored[i]==-1)
			colored[i]=1;
		
		
		for(int it:adj.get(i))
		{
			if(colored[it]==-1)
			{			
				
				colored[it]=1-colored[i];
				if(!isBipartiteDFS(it,colored,adj))
					return false;
			}
			else if(colored[it]==colored[i])
				return false;
		}
		return true;
	}
	

}
