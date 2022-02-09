package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;



public class MinimumSpaningTree {

private static ArrayList<ArrayList<NodeWithWeight>> adj=new ArrayList<ArrayList<NodeWithWeight>>();
	
	void addEdge(int u,NodeWithWeight pr)
	{
		adj.get(u).add(pr);
	}
	public MinimumSpaningTree(int n) {
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<NodeWithWeight>());
		}
	}

	public static void main(String[] args) {
		MinimumSpaningTree g=new MinimumSpaningTree(5);

		
		
		/*
		g.addEdge(0, new NodeWithWeight(1, 4));
		g.addEdge(0, new NodeWithWeight(7, 8));
		g.addEdge(1, new NodeWithWeight(2, 8));
		g.addEdge(1, new NodeWithWeight(7, 11));
		g.addEdge(2, new NodeWithWeight(3, 7));
		g.addEdge(2, new NodeWithWeight(8, 2));
		g.addEdge(2, new NodeWithWeight(5, 4));
		g.addEdge(3, new NodeWithWeight(4, 9));
		g.addEdge(3, new NodeWithWeight(5, 14));
		g.addEdge(4, new NodeWithWeight(5, 10));
		g.addEdge(5, new NodeWithWeight(6, 2));
		g.addEdge(6, new NodeWithWeight(7, 1));
		g.addEdge(6, new NodeWithWeight(8, 6));
		g.addEdge(7, new NodeWithWeight(8, 7));
		*/
		
		g.addEdge(0, new NodeWithWeight(1, 2));
		g.addEdge(1, new NodeWithWeight(0, 2));
		g.addEdge(1, new NodeWithWeight(2, 3));
		g.addEdge(2, new NodeWithWeight(1, 3));
		g.addEdge(0, new NodeWithWeight(3, 6));
		g.addEdge(3, new NodeWithWeight(0, 6));
		g.addEdge(1, new NodeWithWeight(3, 8));
		g.addEdge(3, new NodeWithWeight(1, 8));
		g.addEdge(1, new NodeWithWeight(4, 5));
		g.addEdge(4, new NodeWithWeight(1, 5));
		g.addEdge(2, new NodeWithWeight(4, 7));
		g.addEdge(4, new NodeWithWeight(2, 7));

		System.out.println("************Prim's Algorithm**************");
		minimumSpanningTreeUsingPrimsAlgorithmOptimized(5,adj);

	}
	
	//bruteforce approach 
	//Time COmplexity : N^2
	private static void minimumSpanningTreeUsingPrimsAlgorithmBruteForce(int numberOfNodes,
			ArrayList<ArrayList<NodeWithWeight>> adj) {
		int[] key=new int[numberOfNodes];
		boolean[] mst=new boolean[numberOfNodes];
		int[] parent=new int[numberOfNodes];
		Arrays.fill(mst, false);
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		key[0]=0;
		//spanning tree will have n-1 edges and n nodes
		for(int i=0;i<numberOfNodes-1;i++)
		{
			int mini=Integer.MAX_VALUE;
			int u=0;
			for(int j=0;j<numberOfNodes;j++)
			{
				if(mst[j]==false && key[j]<mini)
				{
					mini=key[j];
					u=j;
				}
			}
			mst[u]=true;
			for(NodeWithWeight it:adj.get(u))
			{
				if(mst[it.getV()]==false && it.getWeight()<key[it.getV()]) {
					parent[it.getV()]=u;
					key[it.getV()]=it.getWeight();
					
				}
			}
				
		}
		for(int i=1;i<numberOfNodes;i++)
		{
			System.out.println(parent[i]+" - "+i);
		}
		
	}
	
	@SuppressWarnings("unused")
	//N*log(N)
	private static void minimumSpanningTreeUsingPrimsAlgorithmOptimized(int numberOfNodes,
			ArrayList<ArrayList<NodeWithWeight>> adj) {
		int[] key=new int[numberOfNodes];
		boolean[] mst=new boolean[numberOfNodes];
		int[] parent=new int[numberOfNodes];
		Arrays.fill(mst, false);
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		PriorityQueue<NodeWithWeight> pq=new PriorityQueue<NodeWithWeight>(numberOfNodes, new NodeWithWeight());
		key[0]=0;
		pq.add(new NodeWithWeight(key[0],0));
		
		//spanning tree will have n-1 edges and n nodes
		for(int i=0;i<numberOfNodes-1;i++)
		{
			int u=pq.poll().getV();
			mst[u]=true;
			for(NodeWithWeight it:adj.get(u))
			{
				if(mst[it.getV()]==false && it.getWeight()<key[it.getV()]) {
					parent[it.getV()]=u;
					key[it.getV()]=it.getWeight();
					pq.add(new NodeWithWeight(it.getV(),key[it.getV()]));
					
				}
			}
				
		}
		for(int i=1;i<numberOfNodes;i++)
		{
			System.out.println(parent[i]+" - "+i);
		}
		
	}

}
