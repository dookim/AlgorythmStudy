import java.util.ArrayList;
import java.util.List;


public class Prim {
	private static final int NODE_NUM = 5;
	
	
	public static void main(String[] args) {
		//# step 1 : init
		int graph[][] = new int[NODE_NUM][NODE_NUM];
		int tree[][] = new int[NODE_NUM][NODE_NUM];
//		List<Edge> visitedEdges = new ArrayList<Prim.Edge>();
		List<Integer> visitedNodes = new ArrayList<Integer>();
		int start = 0;
		visitedNodes.add(start);
//		PrimMNode tree = new PrimMNode(start);
		
		while(NODE_NUM  != visitedNodes.size()) {
			//#step 2 : get shortest path near this tree
			int shortestPathNearTree = Integer.MAX_VALUE;
			int fixedToGoNode = -1;
			int fixedFromNode = -1;
			for(int i = 0; i < visitedNodes.size(); i++) {
				int fromNode = visitedNodes.get(i);
				for(int j = 0; j < NODE_NUM; j++) {
					int toNode = j;
					int weight = graph[fromNode][toNode];
					//#step 2-0 if node doesn't exist, continue;
					if(weight == 0 || weight == Integer.MAX_VALUE) continue;
					//#step 2-1 : check it is cycle or not
					if(visitedNodes.contains(toNode)) continue;
					//#step 2-2 : get shortest path near this tree
					if(shortestPathNearTree > weight) {
						fixedToGoNode = toNode;
						fixedFromNode = fromNode;
					}	
				}
			}
			
			//#step 3 : add node and edge
			visitedNodes.add(fixedToGoNode);
			tree[fixedFromNode][fixedToGoNode] = shortestPathNearTree;

		}		
	}
	
	class Edge {
		
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to,int weight) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class PrimMNode {
		int nodeId;
		List<PrimMNode> childs = new ArrayList<PrimMNode>();
		
		public PrimMNode(int nodeId) {
			// TODO Auto-generated constructor stub
			this.nodeId = nodeId;
		}
		
		public PrimMNode() {
			// TODO Auto-generated constructor stub
		}
		
		public void addChild(PrimMNode node) {
			childs.add(node);
		}
		
		public void addNode(PrimMNode child,PrimMNode node,int weight) {
			//traverse and find parent
			
			//add child to parent
		}
	}
	
	
}
