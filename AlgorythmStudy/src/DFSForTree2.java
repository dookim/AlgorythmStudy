import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class DFSForTree2 {
	public static void main(String[] args) {
		
		//# step 1 : tree를 만든다.
		String graph[] = {null,"a","b","c","d","e","f"};
		MNode<String> tree = GraphToTree.makeTree(graph);
		Stack<MNode<String>> stack = new Stack();
		ArrayList<MNode> visitedList = new ArrayList<MNode>();
		
		//# if it is null, throw null pointer exception
		if(tree == null) throw new NullPointerException();
		
		//# step 2 : visit first node
		stack.push(tree);
		visitedList.add(tree);
		
		while(!stack.isEmpty()) {
			// step 3 : if this node has near node and unvisited node, visit the node
			while(true) {
				
				if(stack.peek().left != null && !isVisit(visitedList, stack.peek().left)) {
					stack.push(stack.peek().left);
					visitedList.add(stack.peek());
					continue;
				}
				
				if(stack.peek().right != null && !isVisit(visitedList, stack.peek().right)) {
					stack.push(stack.peek().right);
					visitedList.add(stack.peek());
					continue;
				}
				
				// step 4 : 인접한 노드가 없다면 stack에서 pop하여 현재 이동노드를 밖ㄴ다.
				stack.pop();
				break;
			}
		}
		for(Iterator<MNode> i = visitedList.iterator(); i.hasNext();) {
			MNode<String> node=i.next();
			System.out.println(node.data);
		}
	}
	private static boolean isVisit(ArrayList<MNode> nodes, MNode curNode) {
		
		for(Iterator<MNode> i = nodes.iterator(); i.hasNext();) {
			MNode node=i.next();
			if(node.equals(curNode)) return true;
		}
		return false;
	}
}
