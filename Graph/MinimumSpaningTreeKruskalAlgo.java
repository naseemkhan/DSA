package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class NodeUVandWeight 
{
	private int u;
    private int v;
    private int weight;
    
    public NodeUVandWeight(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    NodeUVandWeight() {}
    
    public int getV() { return v; }
    public int getU() { return u; }
    public int getWeight() { return weight; }

}

class SortComparator implements Comparator<NodeUVandWeight> {
	@Override
    public int compare(NodeUVandWeight node1, NodeUVandWeight node2) 
    { 
        if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0; 
   

    } 
} 


public class MinimumSpaningTreeKruskalAlgo {

	public MinimumSpaningTreeKruskalAlgo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n = 5;
        ArrayList<NodeUVandWeight> adj = new ArrayList<NodeUVandWeight>();
		
			
		adj.add(new NodeUVandWeight(0, 1, 2));
		adj.add(new NodeUVandWeight(0, 3, 6));
		adj.add(new NodeUVandWeight(1, 3, 8));
		adj.add(new NodeUVandWeight(1, 2, 3));
		adj.add(new NodeUVandWeight(1, 4, 5));
		adj.add(new NodeUVandWeight(2, 4, 7));
		KruskalAlgo(adj, n);

	}
	static void KruskalAlgo(ArrayList<NodeUVandWeight> adj, int N)
    {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N]; 
        int rank[] = new int[N];

        for(int i = 0;i<N;i++) {
        	parent[i] = i; 
        	rank[i] = 0; 
        }

        int costMst = 0;
        ArrayList<NodeUVandWeight> mst = new ArrayList<NodeUVandWeight>();
        for(NodeUVandWeight it: adj) {
        	if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
        		costMst += it.getWeight(); 
        		mst.add(it); 
        		union(it.getU(), it.getV(), parent, rank); 
        	}
        } 
        System.out.println("Total minimum cost for MST = "+costMst);
        for(NodeUVandWeight it: mst) {
        	System.out.println(it.getU() + " " +it.getV()); 
        }
    }
	
	private static int findPar(int u, int parent[]) {
		if(u==parent[u]) return u;
		return parent[u] = findPar(parent[u], parent); 
	}
	private static void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent); 
		v = findPar(v, parent);
		if(rank[u] < rank[v]) {
        	parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
        	parent[v] = u; 
        }
        else {
        	parent[v] = u;
        	rank[u]++; 
        }
	}

}
