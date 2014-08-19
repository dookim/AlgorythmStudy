import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSForTree {
	public static void main(String[] args) {
		
		//# step 1 : tree를 만든다.
		String graph[] = {null,"a","b","c","d","e","f"};
		MNode<String> tree = GraphToTree.makeTree(graph);
		Queue<MNode> queue = new LinkedList();
		ArrayList<MNode> visitedList = new ArrayList<MNode>();
		
		//# step 2 : if it is null, throw null pointer exception
		if(tree == null) throw new NullPointerException();
		
		//# step 3 : add data into queue
		queue.add(tree);
		
		while(!queue.isEmpty()) {
			//# step 4 : pop the queue and visit
			MNode<String> curNode=queue.poll();
			visitedList.add(curNode);
			
			//# step 5 : add nodes which is near curnode
			if(curNode.left != null) queue.add(curNode.left);
			if(curNode.right != null) queue.add(curNode.right);
		}
		
		for(Iterator<MNode> i = visitedList.iterator(); i.hasNext();) {
			MNode<String> node=i.next();
			System.out.println(node.data);
		}
		
	}
}
