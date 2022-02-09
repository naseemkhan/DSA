package graph;

import java.util.Scanner;

public class DisjointSet {

	public DisjointSet() {
		// TODO Auto-generated constructor stub
	}
	
	static int[] parent=new int[100];
	static int[] rank=new int[100];
	
	public static void main(String[] args) {
		makeSet(100);
		int itr=5;
		Scanner obj = new Scanner(System.in);
		while(itr>0)
		{
			int u,v;
			u=obj.nextInt();
			v=obj.nextInt();
			union(u,v);		
		}
		if(findParent(3)!=findParent(5))
		{
			System.out.print("Different component");
		}
		else
			System.out.println("Same Component");
		
		

	}
	static int findParent(int node)
	{
		if(node==parent[node])
			return node;
		//path compression
		return parent[node]=findParent(parent[node]);
	}
	static void union(int node1,int node2)
	{
		int u=findParent(node1);
		int v=findParent(node2);
		if(rank[u] < rank[v])
		{
			parent[u]=v;
			
		}
		else if(rank[u]<rank[v])
		{
			parent[v]=u;
			
		}
		else 
		{
			parent[v]=u;
			rank[u]++;
		}
	}
	static void makeSet(int n)
	{
		for(int i=1;i<n;i++)
		{
			parent[i]=i;
			rank[i]=0;
		}
	}

}
