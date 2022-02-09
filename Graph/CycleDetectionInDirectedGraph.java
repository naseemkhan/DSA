package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInDirectedGraph {
	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	
	public CycleDetectionInDirectedGraph(int v) {
		
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
	}
	
	public void addEdge(int i,int j)
	{
		adj.get(i).add(j);
	}
	public static void main(String[] args) {
		
		CycleDetectionInDirectedGraph graph = new CycleDetectionInDirectedGraph(4);
		
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
		System.out.println(cycleDetectionInDirectedGraphDFS(4,adj));
	}

	private static boolean cycleDetectionInDirectedGraphDFS(int v, ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		boolean[] visited=new boolean[v];
		boolean[] dfsVisited=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				if(checkCycleInDFS(i,visited,dfsVisited,adj))
					return true;
			}
		}
		return false;
	}

	private static boolean checkCycleInDFS(int node, boolean[] visited, boolean[] dfsVisited,
			ArrayList<ArrayList<Integer>> adj) {
		visited[node]=true;
		dfsVisited[node]=true;
		for(int nd:adj.get(node))
		{
			if(!visited[nd])
			{
				if(checkCycleInDFS(nd,visited,dfsVisited,adj))
					return true;
				
			}
			else if(dfsVisited[nd])
			{
				return true;
			}
		}
		dfsVisited[node]=false;
		return false;
	}
	
	private static boolean isCycleInGraphUsingTopologySortBFS(int n, ArrayList<ArrayList<Integer>> adj)
	{
		int[] indegree=new int[n];
		int[] toposort=new int[n];
		for(int i=0;i<n;i++)
		{
			for(int it:adj.get(i))
				indegree[it]++;
		}
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
				queue.add(i);
		}
		int ind=0;
		while(!queue.isEmpty())
		{
			int node=queue.poll();
			toposort[ind++]=node;
			for(int it:adj.get(node))
			{
				indegree[it]--;
				if(indegree[it]==0)
					queue.add(it);
			}
		}
		if(ind==n)
			return false;
		return true;
		
	}

}
