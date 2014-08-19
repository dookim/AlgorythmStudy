package comjam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class P2 {
	public static void main(String[] args) throws IOException {
		
//		//# step 0 : init
//		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//		String temp = "";
//		while((temp = reader.readLine()) != null) {
//			
//		}
//		//# step 1 : make graph
//		
//		//# step 2 : A* algorythm
		
		int arr[] = new int[100];
		for(int i = 0; i < 100; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	
	class CoordinateMgr {
		Coordinate start;
		Coordinate end;
	}
	
	class Coordinate {
		int x;
		int y;
	}
	
	class MNode implements Iterable<MNode>{
		int x;
		int y;
		MNode next;
		public Iterator<MNode> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<MNode>() {
				
				public MNode next() {
					// TODO Auto-generated method stub
					return next;
				}
				
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return next != null;
				}
			};
		}

	}
}
