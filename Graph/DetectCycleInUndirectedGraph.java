package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.bouncycastle.util.Arrays;

class Node
{
	int front;
	int previous;
	Node(int front,int previous)
	{
		this.front=front;
		this.previous=previous;
	}
}

public class DetectCycleInUndirectedGraph {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public DetectCycleInUndirectedGraph(int v) {
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
		
	}
	
	void addEdge(int i, int j) {
		adj.get(i).add(j);
		//for undirected graph
		adj.get(j).add(i);
	}
	public static void main(String[] args) {
		DetectCycleInUndirectedGraph g = new DetectCycleInUndirectedGraph(6);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		System.out.println(checkCycleInGraphBFS(6,adj));
		
	}

	
	public static boolean checkCycleInGraphBFS(int V, ArrayList<ArrayList<Integer>> adj)
	{
		
		boolean[] visited=new boolean[V+1];
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				Queue<Node> queue=new LinkedList<Node>();
				queue.add(new Node(i,-1));
				visited[i]=true;
				for(int j:adj.get(i))
				{
					Node lst=queue.poll();
					if(!visited[j])
					{
						queue.add(new Node(j,lst.front));
						visited[j]=true;
					}
					else if(lst.previous != j)
						return true;
				}
			}
		}
		
		
		return false;
		
	}
	
	
	public static boolean checkCycleInGraphDFS(int V,ArrayList<ArrayList<Integer>> adj)
	{
		boolean[] visited=new boolean[V];
		Arrays.fill(visited, false);
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
				if(isCycleDFS(i,-1,visited,adj))
					return true;
		}
		
		
		return false;
		
	}

	private static boolean isCycleDFS(int i, int prev, boolean[] visited, ArrayList<ArrayList<Integer>> adj2) {
		visited[i]=true;
		for(int it:adj.get(i))
		{
			if(!visited[it])
			{
				if(isCycleDFS(it,i,visited,adj)==true)
					return true;
			}
			else if(it!=prev)
			{
				return true;
			}
			
		}
		return false;
	}
	

}
