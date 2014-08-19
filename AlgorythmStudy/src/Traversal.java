import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.tree.TreeNode;


public class Traversal {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("traversal_case.txt"));
		String testCaseNumStr = br.readLine();
		int testCaseNum = Integer.parseInt(testCaseNumStr);
		
		for(int i = 0; i < testCaseNum; i++) {
			//# step 1 : ignore first line
			br.readLine();
			
			//# step 2 : read 중위 순회
			String postOrderLine = br.readLine();
			
			//# step 3 : make tree using data
			TreeNode root=makeTree(postOrderLine);
			
			//# step 4 : ignore second line
			br.readLine();
			
			//# step 5 : traverse
//			traverse(root);
			traverse1(root);
			
		}
		
		br.close();
	}
	
	private static void traverse(TreeNode root) {
		if(root != null) {
			traverse(root.left);
			System.out.print(root.data + " ");
			traverse(root.right);
		}
	}
	
	private static void traverse1(TreeNode root) {
		if(root != null) {
			traverse1(root.left);
			traverse1(root.right);	
			System.out.print(root.data + " ");
			
		}
	}
	
	private static TreeNode makeTree(String data) {
		//# step 1 : init
		String arr[] = data.split(" ");
		TreeNode root = new TreeNode(null, null, Integer.parseInt(arr[0]));
		
		for(int i = 1; i < arr.length; i++) {
			//# get current node
			int curNodeData = Integer.parseInt(arr[i]);
			TreeNode point = root;
			//# traverse for the location which i want
			while(true) {
				if(curNodeData > point.data) {
					if(point.right != null) point = point.right;
					else {
						point.right = new TreeNode(null, null, curNodeData);
						break;
					}
				} else {
					if(point.left != null) point = point.left;
					else {
						point.left = new TreeNode(null, null, curNodeData);
						break;
					}
				}
			}
		}
		return root;
	}
	
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;
		
		public TreeNode(TreeNode left, TreeNode right, int data) {
			// TODO Auto-generated constructor stub
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
}
