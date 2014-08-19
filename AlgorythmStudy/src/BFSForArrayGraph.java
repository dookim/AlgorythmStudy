import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BFSForArrayGraph {
	
	private static final int GRAPH_SIZE = 5;
	
	public static void main(String[] args) {
		//# step 1 : make graph
		int graph[][] = { 
				{0,1,1,0,0}, 
				{1,0,1,0,0}, 
				{1,1,0,1,0}, 
				{0,0,1,0,1}, 
				{0,0,0,1,0}, 
				};
		ArrayList<Integer> visitedList = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//# step 2 : add data into queue
		queue.add(0);
		
		while(!queue.isEmpty()) {
			
			//# step 3 : pop the queue and visit
			int curPosition=queue.remove();
			visitedList.add(curPosition);
			
			//# step 4 : add nodes which is near curnode
			for(int i = 0; i < GRAPH_SIZE; i++) {
				if(hasVertext(curPosition, i, graph) && !isVisit(i, visitedList)) {
					queue.add(i);
				}
			}
		}
		
		for(Iterator<Integer> i=visitedList.iterator(); i.hasNext();) {
			int data=i.next();
			System.out.println(data);
		}
	}
	
	private static boolean hasVertext(int from, int to, int graph[][]) {
		return graph[from][to] == 1;
	}
	
	private static boolean isVisit(int curPosition, ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) 
			if(list.get(i) == curPosition) return true;
		return false;
	}
}
