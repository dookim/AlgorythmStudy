import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class DFSForTree3 {
	public static void main(String[] args) {
		
		//# step 1 : tree를 만든다.
		String graph[] = {null,"a","b","c","d","e","f"};
		MNode<String> tree = GraphToTree.makeTree(graph);
		Stack<MNode<String>> stack = new Stack();
		ArrayList<MNode> visitedList = new ArrayList<MNode>();
		
		//# if null throw exception
		if(tree == null) throw new NullPointerException();
        
		//# step 2 : visit first node(root node)
		stack.push(tree);
		visitedList.add(tree);
		
		// stack이 현재 포인터
		while(!stack.isEmpty()) {
			// step 1 :
			while(stack.peek().left != null && !isVisit(visitedList, stack.peek().left)) {
				stack.push(stack.peek().left);
				visitedList.add(stack.peek());
				System.out.println(stack.peek());
			} if(stack.peek().right != null && !isVisit(visitedList, stack.peek().right)) {
				stack.push(stack.peek().right);
				visitedList.add(stack.peek());
				System.out.println(stack.peek());
			} else {
				//다방문했고 갈데도없을 경우
				if(stack.isEmpty()) {
					break;
				} else {
					stack.pop();
				}
			}
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
