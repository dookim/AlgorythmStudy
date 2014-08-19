import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class EnSorter {
	public static void main(String[] args) {
		Scanner scanner= new  Scanner(System.in);
		String input = scanner.nextLine();
		List<String> list = new ArrayList<String>();
		
		
		//if it doesn't match our condition it throws exception.
		if(input.length() > 500) throw new IllegalArgumentException();
		
		//# step 1 :cut the datas by 2n
		for(int i = 0; i < input.length(); i=i+2) {
			//if in case of out of index
			String subString = "";
			//if odd number
			if(i+2 > input.length()) subString=input.substring(i, i+1);
			else subString=input.substring(i, i+2);
			list.add(subString);
		}
		
		//# step 2 : sort
		Collections.sort(list);
		
		
		//# step 3:  print
		StringBuilder sb = new StringBuilder();
		for(Iterator<String> i = list.iterator(); i.hasNext();) {
			String data = i.next();
			sb.append(data);
		}
		System.out.println(sb.toString());
	}
}
