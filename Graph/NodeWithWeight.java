package graph;

import java.util.Comparator;

public class NodeWithWeight implements Comparator<NodeWithWeight>{

	private int v;
	private int weight;
	NodeWithWeight(int v,int weight)
	{
		this.v=v;
		this.weight=weight;
	}
	public NodeWithWeight() {
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
	public int compare(NodeWithWeight node1, NodeWithWeight node2) {
		if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0;
	}

}
