package graph;

/*
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
 * such that for every directed edge u v, vertex u comes before v in the ordering. 
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologySort {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public TopologySort(int v) {
		for(int i=0;i<v;i++)
		{adj.add(new ArrayList<Integer>());}
		
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
	}

	public static void main(String[] args) {
		TopologySort g = new TopologySort(6);
		
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        int[] topologySort=TopologySortUsingDFS(6,adj);
        for(int sort:topologySort)
        	System.out.print(" "+sort);

	}
	private static int[] TopologySortUsingDFS(int n, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st=new Stack<Integer>();
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				dfsGraph(i,st,visited,adj);
			}
		}
		int[] toposort=new int[st.size()];
		int ind=0;
		while(!st.isEmpty())
			toposort[ind++]=st.pop();
		return toposort;
	}
	private static void dfsGraph(int node, Stack<Integer> st, boolean[] visited, ArrayList<ArrayList<Integer>> adj2) {
		visited[node]=true;
		for(int nd:adj.get(node))
		{
			if(!visited[nd])
				dfsGraph(nd,st,visited,adj);
		}
		st.push(node);
		
	}
	
	private static int[] TopologySortUsingBFS(int n, ArrayList<ArrayList<Integer>> adj)
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
		return toposort;
		
	}
	

}
