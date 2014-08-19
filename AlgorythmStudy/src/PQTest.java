import java.util.Iterator;
import java.util.PriorityQueue;


public class PQTest {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("c");
		pq.add("b");
		pq.add("a");
		
//		for(Iterator<String> i = pq.iterator();i.hasNext();) {
//			System.out.println(i.next());
//		}
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
