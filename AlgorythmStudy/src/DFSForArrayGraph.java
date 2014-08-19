import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DFSForArrayGraph {
	
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
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		
		//# step 2 : visit root
		stack.push(0);
		list.add(0);
		
		while(!stack.isEmpty()) {
			
			boolean visitFlag = false;
			
			//# step 3 : visit near node
			for(int i = 0; i < GRAPH_SIZE; i++) {
				if(hasVertext(stack.peek(), i, graph) &&!isVisit(i, list)) {
					stack.push(i);
					list.add(i);
					visitFlag = true;
					break;
				}
			}
			//# step 4 : if dont visit, then move backward 
			if(visitFlag == false) stack.pop();
		}
		
		for(Iterator<Integer> i = list.iterator(); i.hasNext();) {
			Integer data= i.next();
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
