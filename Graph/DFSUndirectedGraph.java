package graph;

import java.util.ArrayList;
import java.util.Stack;

import org.bouncycastle.util.Arrays;

public class DFSUndirectedGraph {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public DFSUndirectedGraph(int v) {
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
		
	}
	
	void addEdge(int i, int j) {
		adj.get(i).add(j);
		//for undirected graph
		
	}
	public static void main(String[] args) {
		DFSUndirectedGraph g = new DFSUndirectedGraph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println(dfsOfGraphWithoutRecursion(4,adj));
		
	}
	
	public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList<Integer> bfsOutput=new ArrayList<Integer>();
		boolean[] visited=new boolean[V+1];
		Arrays.fill(visited, false);
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				dfs(i,visited,adj,bfsOutput);
			}
		}
 		return bfsOutput;
		
	}

	private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj,
			ArrayList<Integer> bfsOutput) {

		
		visited[node]=true;
		bfsOutput.add(node);
		for(Integer it:adj.get(node))
		{
			if(!visited[it])
				dfs(it,visited,adj,bfsOutput);
		}
		
	}
	
	static ArrayList<Integer> dfsOfGraphWithoutRecursion(int V, ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList<Integer> bfs=new ArrayList<Integer>();
		boolean[] visited=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(visited[i]==false)
			{
				Stack<Integer> st=new Stack<Integer>();
				st.push(i);
				
				visited[i]=true;
				while(!st.isEmpty())
				{
					
					int ele=st.pop();
					bfs.add(ele);
					for(int it:adj.get(i))
					{
						if(visited[it]==false)
						{
							visited[it]=true;
							st.push(it);
						}
							
					}
				}
			}
		}
		return bfs;
		
	}

}
