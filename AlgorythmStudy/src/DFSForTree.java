import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class DFSForTree {
	public static void main(String[] args) {
		MNode tree = null;
		if(tree == null) throw new IllegalArgumentException();
		
		MNode pointer = tree;
		Queue<MNode> queue = new LinkedList<MNode>();
		queue.add(pointer);
		ArrayList<MNode> visistedList = new ArrayList<MNode>();
		
		while(!queue.isEmpty()) {
			
			//������ �༮���� �ִ´�.
			if(pointer.left != null) queue.add(pointer.left);
			if(pointer.right != null) queue.add(pointer.right);
			//�湮�Ѵ�.
			visistedList.add(pointer);
			System.out.println(pointer.data);
			pointer = queue.poll();
		}
		
	}
}


