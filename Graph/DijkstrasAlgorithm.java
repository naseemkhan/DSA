package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.bouncycastle.util.Arrays;

class NodeSet implements Comparator<NodeSet>
{
	private int v;
	private int weight;
	NodeSet(int v,int weight)
	{
		this.v=v;
		this.weight=weight;
	}
	public NodeSet() {
		// TODO Auto-generated constructor stub
	}
	int getV()
	{
		return v;
	}
	int getWeight()
	{
		return weight;
	}
	@Override
	public int compare(NodeSet o1, NodeSet o2) {
		if(o1.weight<o2.weight)
			return -1;
		else if(o1.weight>o2.weight)
			return 1;
		return 0;
	}

}

public class DijkstrasAlgorithm {
	private static ArrayList<ArrayList<NodeSet>> adj=new ArrayList<ArrayList<NodeSet>>();
	public DijkstrasAlgorithm(int n) {

		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<NodeSet>());
		}
	}
	void addEdge(int u,NodeSet nd)
	{
		adj.get(u).add(nd);
		adj.get(nd.getV()).add(new NodeSet(u,nd.getWeight()));
	}
	public static void main(String[] args) {
		DijkstrasAlgorithm g=new DijkstrasAlgorithm(5);

		
		
		g.addEdge(0, new NodeSet(1, 9));
		g.addEdge(0, new NodeSet(2, 6));
		g.addEdge(0, new NodeSet(3, 5));
		g.addEdge(0, new NodeSet(4, 3));
		g.addEdge(2, new NodeSet(1, 2));
		g.addEdge(2, new NodeSet(3, 4));
		shortestDistanceFromSourceToEachNodeUndirectedGraphDijkstra(0,5,adj);

	}
	private static void shortestDistanceFromSourceToEachNodeUndirectedGraphDijkstra(int source, int n,
			ArrayList<ArrayList<NodeSet>> adj) {
		int[] dist=new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source]=0;
		PriorityQueue<NodeSet> pq=new PriorityQueue<NodeSet>(n,new NodeSet());
		pq.add(new NodeSet(source,0));
		while(!pq.isEmpty())
		{
			NodeSet node=pq.poll();
			for(NodeSet it:adj.get(node.getV()))
			{
				if(dist[node.getV()]+it.getWeight()<dist[it.getV()])
				{
					dist[it.getV()]=dist[node.getV()]+it.getWeight();
					pq.add(new NodeSet(it.getV(),dist[it.getV()]));
				}
			}
		}
		
		for (int i = 0; i < n; i++)
        {
                System.out.print( dist[i] + " ");
        }
		
	}

}


