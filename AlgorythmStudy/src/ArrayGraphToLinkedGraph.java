
public class ArrayGraphToLinkedGraph {
	public static void main(String[] args) {
		
	}
}

class GraphToTree {
	
	public static<T> MNode<T> makeTree(T[] graph) {
		
		if (graph == null) throw new IllegalArgumentException();
		MNode<T> root = null;
		MNode<T>[] nodes = new MNode[1000];
		
		for(int i = 1; i < graph.length; i++) {
			if(i == 1) {
				root = new MNode<T>(null, null, graph[i]);
				nodes[i] = root;
			} else {
				MNode<T> node = new MNode<T>(null, null, graph[i]);
				nodes[i] = node;
				MNode<T> parent = nodes[i/2];
				if(i%2 == 0) parent.left = node;
				else if(i%2 == 1) parent.right = node;
			}
		}
		return root;
	}
}
