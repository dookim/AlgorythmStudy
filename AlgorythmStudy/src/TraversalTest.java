import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TraversalTest {
	
	private static int NODE_SIZE = 50;
	
	public static void main(String[] args) {
//		int arr[] = new int[NODE_SIZE];
//		for(int i = 0; i < NODE_SIZE; i++) arr[i]= randomRange(0, 10);
//		
//		//#step 1 - 2 : tree�� �����.
//		Node tree = makeTree(arr);
//		
//		//#step 3 : second test case  
//		//#step 3 - 1 : tree -> ������ȸ.
//		StringBuilder sb2 = new StringBuilder();
//		preOrder(tree, sb2);
//		
//		//#step 3 - 2 : ���� ��ȸ -> ���� ��ȸ
//		String str = sb2.toString();
//		String[] strArr=str.split(" ");
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i = 0; i < strArr.length; i++) list.add(Integer.parseInt(strArr[i]));
//		
//		StringBuilder sb3 = new StringBuilder();
//		preOrder2postOrder(list, sb3);
//		System.out.println(sb3.toString());
		
		
		
	}
	@Test
	public void testTree() {
		for(int j = 0; j < 100000; j++) {
			//# step 1 : tree�� �����.
			//#step 1 - 1 : random ���� generate(50��)
			int arr[] = new int[NODE_SIZE];
			for(int i = 0; i < NODE_SIZE; i++) arr[i]= randomRange(-10000, 10000);
			
			//#step 1 - 2 : tree�� �����.
			Node tree = makeTree(arr);
			
			//# step 2 : first test case ���� ��ȸ�Ѵ�.
			StringBuilder sb1 = new StringBuilder();
			postOrder(tree,sb1);
			
			//#step 3 : second test case  
			//#step 3 - 1 : tree -> ������ȸ.
			StringBuilder sb2 = new StringBuilder();
			preOrder(tree, sb2);
			
			//#step 3 - 2 : ���� ��ȸ -> ���� ��ȸ
			String str = sb2.toString();
			String[] strArr=str.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < strArr.length; i++) list.add(Integer.parseInt(strArr[i]));
			
			StringBuilder sb3 = new StringBuilder();
			preOrder2postOrder(list, sb3);

			assertEquals(sb1.toString(),sb3.toString());
		}
	}
	
	private static void preOrder2postOrder(List<Integer> list, StringBuilder sb) {
		if(list.isEmpty()) return;
		int root = list.get(0);
		int slice = getSlice(list);
		List<Integer> left = getLeft(list, slice);
		List<Integer> right = getRight(list, slice);
		preOrder2postOrder(left, sb);
		preOrder2postOrder(right, sb);
		sb.append(root + " ");	
	}
	
	private static List<Integer> getLeft(List<Integer> list, int slice) {
		List<Integer> left = new ArrayList<Integer>();
		for(int i = 1; i < slice; i++) left.add(list.get(i));
		return left;
	}
	
	private static List<Integer> getRight(List<Integer> list, int slice) {
		List<Integer> right = new ArrayList<Integer>();
		for(int i = slice; i < list.size(); i++) right.add(list.get(i));
		return right;
	}
	
	private static int getSlice(List<Integer> list) {
		int root = list.get(0);
		for(int i = 0; i < list.size(); i++) {
			if(root < list.get(i)) return i;
		}
		return list.size();
	}
	
	//# tree -> ���� ��ȸ
	//=
	//# tree -> ������ȸ str -> ���� ��ȸ
	
	//���� ��ȸ
	private static void preOrder(Node node, StringBuilder sb) {
		if (node != null) {
			sb.append(node.data + " ");
			preOrder(node.left,sb);
			preOrder(node.right,sb);
		}
	}
	
	//���� ��ȸ
	private static void inOrder(Node node, StringBuilder sb) {
		if (node != null) {
			inOrder(node.left,sb);
			sb.append(node.data + " ");
			inOrder(node.right,sb);
		}
	}
	
	//���� ��ȸ
	private static void postOrder(Node node, StringBuilder sb) {
		if (node != null) {
			postOrder(node.left,sb);
			postOrder(node.right,sb);
			sb.append(node.data + " ");
		}
	}
	
	
//	private static void traverse(Node node) {
//		if(node != null) {
//			traverse(node.left);
//			System.out.print(node.data + " ");
//			traverse(node.right);
//		}
//	}
	
	//index�� length�� �ɶ����� tree�� �����.
	private static Node makeTree(int[] source) {
		if(source.length == 0) throw new IllegalStateException();
		Node root = new Node(source[0]);
		
		for(int i = 1; i < source.length; i++) {
			int curNode = source[i];
			//#step 1 : node�� ��ȸ�Ͽ� �����Ѵ�.(������ ��ġ�� ã�Ƽ� �����Ѵ�.)
			Node pointer = root;
			while(true) {
				if(pointer.data > curNode) {
					if(pointer.left == null) {
						pointer.left = new Node(curNode);
						break;
					} 
					pointer = pointer.left;
				} else if(pointer.data < curNode) {
					if(pointer.right == null) {
						pointer.right = new Node(curNode);
						break;
					} 
					pointer = pointer.right;
				//���� ���
				} else break;
			}
		}
		return root;
	}
	
	public static int randomRange(int n1, int n2) {
	    return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	  }
	
	private static class Node {
		Node right;
		Node left;
		int data;
		
		public Node(Node right, Node left, int data) {
			// TODO Auto-generated constructor stub
			this.right = right;
			this.left = left;
			this.data = data;
		}
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
	}

	
	//#step 1 -3 : root�� ��ȯ�Ѵ�.
	
}


