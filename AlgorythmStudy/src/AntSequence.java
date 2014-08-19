import java.util.Scanner;

public class AntSequence {

	public static void main(String[] args) {
		// InputStream in = new InputStream(System.in);
		Scanner scanner = new Scanner(System.in);
		int inputNum = scanner.nextInt();
		String output = "1";
		for (int i = 0; i < inputNum; i++) {
			if (i == 0)
				System.out.println(output);
			else {
				int counter = 0;
				char curChar = (char) -1;
				char exChar = (char) -1;
				StringBuilder nextSb = new StringBuilder();
				// counting machine
				for (int j = 0; j < output.length(); j++) {
					curChar = output.charAt(j);
					if(j == 0) {
						exChar = curChar;
						counter++;
						continue;
					}
					if (exChar == curChar) {
						counter++;
					} else {
						nextSb.append( (""+counter) + exChar);
					}
					exChar = curChar;
				}
				nextSb.append((counter + "") + exChar);
				output = nextSb.toString();
				System.out.println(output);
				nextSb.setLength(0);
			}
		}
	}

}
