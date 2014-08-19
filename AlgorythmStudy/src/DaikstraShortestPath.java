import java.util.ArrayList;
import java.util.List;



public class DaikstraShortestPath {
	private static final int GRAPH_SIZE = 5;
	
	public static void main(String[] args) {
		
		//# init for graph
		int graph[][] = new int[GRAPH_SIZE][GRAPH_SIZE];
		int path[] = new int[GRAPH_SIZE];
		int firstPositon = 0;
		List<Integer> visitedList = new ArrayList<Integer>();
		
		//# step 1 : visit current position
		for(int i =0 ; i < graph.length; i++) path[i] = graph[firstPositon][i];
		visitedList.add(firstPositon);
		
		while(visitedList.size() != GRAPH_SIZE) {
			int curShotestNode = -1;
			int curShortestPath = Integer.MAX_VALUE;
			
			//step 2 : get shortest path 
			for(int i = 0; i < path.length; i++) 
				if(curShortestPath > path[i]) {
					curShortestPath = path[i];
					curShotestNode = i;
				}
			
			//step 3 : mark this shotest path is visited
			visitedList.add(curShotestNode);
			
			//step 4 : reorganize path;
			for(int i = 0 ; i < GRAPH_SIZE; i++) {
				if(visitedList.contains(i)) continue;
				if(path[i] > path[curShotestNode] + graph[curShotestNode][i]) path[i] = path[curShotestNode] + graph[curShotestNode][i];
			}
		}
	}
}
