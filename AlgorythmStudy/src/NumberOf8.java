
public class NumberOf8 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < 10000; i++) {
			String a =i + "";
			for(int j = 0; j < a.length(); j ++) {
				if(a.charAt(j) == '8')  {
					count++;
				}
			}
 		}
		System.out.println("count is " + count);
	}

}
