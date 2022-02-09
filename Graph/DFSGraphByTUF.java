package graph;

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class DFSGraphByTUF
{
	 private static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		public DFSGraphByTUF(int v) {
	        for (int i=0; i<v; ++i)
	            adj.add(new ArrayList<Integer>());
			
		}
		
		void addEdge(int i, int j) {
			adj.get(i).add(j);
			//for undirected graph
			
		}
		public static void main(String[] args) {
			DFSGraphByTUF g = new DFSGraphByTUF(4);
			
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);
			System.out.println(dfsOfGraph(4,adj));
			
		}
 
 public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
     storeDfs.add(node); 
     vis[node] = true; 
     for(Integer it: adj.get(node)) {
         if(vis[it] == false) {
             dfs(it, vis, adj, storeDfs); 
         }
     }
 }
 public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
 {
     ArrayList<Integer> storeDfs = new ArrayList<>(); 
     boolean vis[] = new boolean[V+1]; 
     for(int i = 0;i<V;i++) {
         if(!vis[i]) 
        	 dfs(i, vis, adj, storeDfs); 
     }
     
     return storeDfs;
 }
 
 
}
//} Driver Code Ends


