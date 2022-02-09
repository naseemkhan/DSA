package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {

	public KosarajusAlgorithm() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 int n = 5;
	        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
			
			for (int i = 0; i < n; i++) 
				adj.add(new ArrayList<Integer>());
				
			adj.get(0).add(1);
			adj.get(1).add(2);
			adj.get(2).add(0);
			adj.get(1).add(3);
			adj.get(3).add(4);
			kosaRaju(adj, n); 

	}

	private static void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n) {
		int vis[]=new int[n];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<n;i++)
		{
			if(vis[i]==0)
				topoDfs(i,st,adj,vis);	
		}
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>> ();
		for(int i=0;i<n;i++) 
		{
			transpose.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n;i++)
		{
			vis[i]=0;
			for(Integer it:adj.get(i))
			{
				transpose.get(it).add(i);
			}
		}
		
		
		while(!st.isEmpty())
		{
			int node=st.peek();
			st.pop();
			if(vis[node]==0)
			{
				System.out.print("SSC : ");
				revDfs(node,transpose,vis);
				System.out.println();
			}
			
		}
		
	}


	private static void topoDfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int[] vis) {
		vis[node]=1;
		
		for(Integer it:adj.get(node))
		{
			if(vis[it]==0)
			{
				topoDfs(it,st,adj, vis);
			}
		}
		st.push(node);
		
	}

	private static void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int[] vis) {
		vis[node]=1;
		System.out.print(node+" ");
		for(Integer it:transpose.get(node))
		{
			if(vis[it]==0)
				revDfs(it,transpose,vis);
		}
	}

}
