package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bouncycastle.util.Arrays;

public class BFSUndirectedGraph {

	private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	public BFSUndirectedGraph(int v) {
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
		
	}
	
	void addEdge(int i, int j) {
		adj.get(i).add(j);
		//for undirected graph
		adj.get(j).add(i);
		
	}
	public static void main(String[] args) {
		BFSUndirectedGraph g = new BFSUndirectedGraph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println(bfsOfGraph(4,adj));
		
	}
	

	public static List<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
	{
		List<Integer> bfs=new ArrayList<Integer>();
		boolean[] visited=new boolean[V];
		Arrays.fill(visited, false);
		for(int i=0;i<visited.length;i++)
		{
			
			if(!visited[i])
			{
				Queue<Integer> queue=new LinkedList<>();
				queue.add(i);
				visited[i]=true;
				while(!queue.isEmpty())
				{
					int lst=queue.poll();
					bfs.add(lst);
					for(Integer j:adj.get(lst))
					{
						if(!visited[j])
						{
							visited[j]=true;
							queue.add(j);
						}
					}
					
					
				}
			}
		}
		
		return bfs;
		
	}
}
