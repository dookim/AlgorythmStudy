import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimAlgorythm {

	private static final int GRAPH_SIZE = 5;

	public static void main(String[] args) {

		// #step 0 : make graph
		int graph[][] = { { 0, 1, 6, 0, 2 }, { 1, 0, 3, 7, 0 },
				{ 0, 3, 0, 4, 0 }, { 0, 7, 4, 0, 5 }, { 2, 0, 6, 5, 0 } };

		// #step 1 : init
		int initPoint = 0;
		ArrayList<Integer> vertexs = new ArrayList<Integer>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		vertexs.add(initPoint);

		// #step 1-0 : sorting all data
		List<SortEdge> sortEdges=getSortEdge(graph);
		Collections.sort(sortEdges);
		
		// #step 2 : select edge and vertext
		for(int index = 0; !hasAllVertexes(vertexs);) {
			SortEdge edge = sortEdges.get(index);
			if(vertexs.contains(edge.from) && !vertexs.contains(edge.to)) {
				vertexs.add(edge.to);
				edges.add(edge.getEdge());
			}
		}

	}

	private static List<SortEdge> getSortEdge(int graph[][]) {

		List<SortEdge> sortEdges = new ArrayList<SortEdge>();

		for (int from = 0; from < graph.length; from++) {
			for (int to = from + 1; to < graph[from].length; to++) {
				SortEdge edge = new SortEdge(from, to, graph[from][to]);
				sortEdges.add(edge);
			}
		}

		return sortEdges;

	}

	private static boolean hasAllVertexes(List<Integer> list) {
		for (int i = 0; i < GRAPH_SIZE; i++) {
			if (!list.contains(i)) {
				return false;
			}
		}
		return true;
	}
}

class SortEdge implements Comparable<SortEdge> {

	int from;
	int to;
	int weight;

	public SortEdge(int from, int to, int weight) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int compareTo(SortEdge arg0) {
		// TODO Auto-generated method stub
		if(weight > arg0.weight)  return 1;
		else if(weight == arg0.weight) return 0;
		else return -1;
	}
	
	
	public Edge getEdge() {
		return new Edge(from, to);
	}
	
	
}

class Edge {
	
	int from;
	int to;
	
	public Edge(int from, int to) {
		// TODO Auto-generated constructor stub
	}
}
