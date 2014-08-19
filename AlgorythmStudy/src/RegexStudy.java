
public class RegexStudy {
	public static void main(String[] args) {
		String test = "test1";
		System.out.println(test.matches("tes" + "t" + "[1-9]"));
		
		String test1 = "12";
		System.out.println(test1.matches("^[0-9]$"));
		
		String test3 = "02-537";
		System.out.println(test3.matches("^02.*"));
	}
}
