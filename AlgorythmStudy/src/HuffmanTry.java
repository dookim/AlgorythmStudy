import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class HuffmanTry {
	static StringBuilder encodedData = new StringBuilder();
	public static void main(String[] args) {
		String data = "abbcccdddd";

		PriorityQueue<HuffNode> pq = new PriorityQueue<HuffNode>();

		// # step 1 : ��� �����͸� �󵵼� ���� �ִ´�.
		loops: for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			HuffNode cf = new HuffNode(c, 1);
			// # step 1 - 1 : �����Ѵٸ� frequency ����,.
			for (HuffNode ccf : pq)
				if(ccf.equals(cf)) {
					ccf.frequency++;
					pq.remove(ccf);
					pq.add(ccf);
					continue loops;
				}
			// # step 1 - 2: ���� ���� �ʴ´ٸ� �߰��Ѵ�.
			pq.add(cf);
		}
		
		System.out.println(pq.poll().c);

		// //# step 2 : tree�� �����
		while (pq.size() != 1) {
			// step 3 -0 : �ΰ��� �����Ѵ�.(����)
			HuffNode left = pq.poll();
			HuffNode right = pq.poll();
			
			// step 3- 1 �ϳ��� ��ģ��.
			HuffNode parent = new HuffNode(null, left.frequency + right.frequency, left, right);

			// step 3-2 �ִ´�.
			pq.add(parent);
		}
		
		//# step 3 : table�� �����.
		HuffNode root = pq.poll();
		Stack<HuffNode> huffStack = new Stack<HuffNode>();
		ArrayList<HuffNode> visistedList = new ArrayList<HuffNode>();
		
		Stack<Integer> intStack = new Stack<Integer>();
		HashMap<String,String> table = new HashMap<String,String>();
		
		huffStack.add(root);
		visistedList.add(root);
		
		while(!huffStack.isEmpty()) {
			//#step 3 -1 ������ ��尡 �ִٸ� ��� �湮�Ѵ�.
			while(true) {
				//���� ���� �湮�Ѵ�.
				if(huffStack.peek().left != null && !isVisit(huffStack.peek().left, visistedList)) {
					huffStack.add(huffStack.peek().left);
					intStack.push(0);
					continue;
				}
				if(huffStack.peek().right != null && !isVisit(huffStack.peek().right, visistedList)) {
					huffStack.add(huffStack.peek().right);
					intStack.push(1);
					continue;
				}
				break;
			}
			//#step 3-2 �湮�� ��尡 ���°��
			//���� ����� ��� table�� �����.
			if(huffStack.peek().left == null && huffStack.peek().right == null) {
				StringBuilder key = new StringBuilder();
				for(int i = 0; i < intStack.size(); i++) {
					key.append(intStack.get(i));
				}
				String value = huffStack.peek().c.toString();
				table.put(key.toString(), value);
			}
			huffStack.pop();
		}
		//#step 4 : encoding �Ѵ�.
		StringBuilder encodedData = new StringBuilder();
		for(int i = 0; i < data.length(); i++) {
			String key = Character.toString(data.charAt(i));
			encodedData.append(table.get(key));
		}
		
		
		//#step 5:  decode�Ѵ�.
		String encodedString = encodedData.toString();
		StringBuilder decodedData = new StringBuilder();
		HuffNode pointer = root;
		
		for(int i = 0; i < encodedString.length(); i++) {
			char curC = encodedString.charAt(i);
			
			//# step 5 - 1 ������ ��尡 ������ �̵��Ѵ�.
			if(pointer.c != null) {
				if(curC == '0') pointer = pointer.left;
				 else pointer = pointer.right;
			} 
			//# step 5-2 ������ ��尡 ���ٸ� �ش� ���ڰ� �������̴�.
			else decodedData.append(pointer.c.toString());
			
			
		}
	}
	
	private static boolean isVisit(HuffNode node, ArrayList<HuffNode> visitedList) {
		return visitedList.contains(node);
	}
	
	private static void traverse(HuffNode node) {
		if(node != null) {
			if(node.left != null) {
				encodedData.append("0");
				traverse(node.left);
			}
			if(node.c != null) System.out.println(node.c);
			if(node.right != null) {
				encodedData.append("1");
				traverse(node.right);
			}
			
		}
	}

}




class HuffNode implements Comparable<HuffNode> {

	Character c;
	Integer frequency;
	HuffNode left;
	HuffNode right;

	public HuffNode(Character c, int frequency, HuffNode left, HuffNode right) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public HuffNode(char c, int frequency) {
		// TODO Auto-generated constructor stub
		this.c = c;
		this.frequency = frequency;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (!(arg0 instanceof HuffNode))
			return false;
		HuffNode tNode = (HuffNode) arg0;
		return c.charValue() == tNode.c.charValue();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return c.hashCode();
	}

	public int compareTo(HuffNode paramT) {
		// TODO Auto-generated method stub
		// return paramT.frequency > frequency ? 1 : paramT.frequency <
		// frequency ? -1:0;
		 return frequency.compareTo(paramT.frequency);
//		return paramT.frequency.compareTo(frequency);
	}
}
