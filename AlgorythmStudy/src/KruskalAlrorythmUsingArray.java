import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class KruskalAlrorythmUsingArray {

	static int graph[][] = { { 0, 1, 6, 0, 2 }, { 1, 0, 3, 7, 0 },
			{ 0, 3, 0, 4, 0 }, { 0, 7, 4, 0, 5 }, { 2, 0, 6, 5, 0 } };

	static int tree[][] = new int[5][5];

	static ArrayList<NodeForSort> sortNodes = new ArrayList<NodeForSort>();

	static ArrayList<Integer> visitedNodeList = new ArrayList<Integer>();

	public static void main(String[] args) {

		int edgeNum = 0;
		int vertextNum = graph.length;

		// #step 0 : setting for sorting
		for (int i = 0; i < graph.length; i++) {
			int nodeIndex = i + 1;
			// #from node를 추가한다.
			// 사슬을 만든다.
			for (int j = i + 1; j < graph[i].length; j++) {

				int nodeIndex1 = j + 1;
				int weight = graph[i][j];

				if (weight != 0) {

					sortNodes.add(new NodeForSort(nodeIndex, nodeIndex1, weight));
				}
			}
		}

		// #step 1 : sorting
		Collections.sort(sortNodes);
		int index = 0;
		
		while (edgeNum != vertextNum - 1) {

			int to = sortNodes.get(index).to;
			int from = sortNodes.get(index).from;
			int cost = sortNodes.get(index).cost;

			// #step 2 : 가장 적은 비용이 드는 간선부터 차례로 추가 & 선택시 사이클이 되는 경우는 제외
			// step0에서 세팅한 값으로 순회한다.
			// # acyclic인 경우
			if (!visitedNodeList.contains(to)) {

				visitedNodeList.add(from);
				visitedNodeList.add(to);

				tree[to - 1][from - 1] = cost;
				tree[from - 1][to - 1] = cost;
				edgeNum++;
				System.out.println("edgeNum : " + edgeNum);
				// System.out.println(index);
			}

			index++;
		}

		//#print 한다.

	}

}

class NodeForSort implements Comparable<NodeForSort> {

	int from;
	int to;
	Integer cost;

	public NodeForSort(int from, int to, Integer cost) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	public int compareTo(NodeForSort arg0) {
		// TODO Auto-generated method stub
		return cost.compareTo(arg0.cost);
	}
}
