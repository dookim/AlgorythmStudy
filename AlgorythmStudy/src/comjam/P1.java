package comjam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class P1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		StringBuilder builder = new StringBuilder();
		//# step 1 : file을 읽는다.
		String temp = "";
		while((temp=br.readLine()) != null) {
			//# step 2 : " " ->로 바꾼다.
			temp=temp.replace(" ", "-");
			//# step 3 : 앞에 패턴 매칭하고 매칭한 패턴대로 뒤를 잇는다.
			if(temp.matches("^02.*")) {
				String third = temp.substring(2,3);
				if(!third.matches("-|–")) temp = temp.substring(0,2) + "-" + temp.substring(2,temp.length()); 
			} else if(temp.matches("^01[0-9].*") || temp.matches("^0[3-6][0-9].*") || temp.matches("^07[0-9].*")) {
				String fourth = temp.substring(3,4);
				if(!fourth.matches("-|–")) temp = temp.substring(0,3) + "-" + temp.substring(3,temp.length());
			}
			//# step 2-0 : 패턴 매칭이없으면 숫자만 출력한다.
			else {
				builder.append(temp);
				continue;
			}
			//# step 4 : 뒤에 내자리 바로 앞에 -가  있는지 본다.
			String lastFive = temp.substring(temp.length()-5,temp.length()-4);
			if(!lastFive.matches("-|–")) {
				temp = temp.substring(0,temp.length()-4) + "-" + temp.substring(temp.length()-4,temp.length()); 
			}
			System.out.println(temp);

		}
		br.close();
	}
}
