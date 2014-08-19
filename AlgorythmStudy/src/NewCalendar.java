import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class NewCalendar {
	
	
	public static void main(String[] args) throws IOException {
		//setting
		BufferedReader fr = new BufferedReader(new FileReader("input.txt"));
		FileWriter fw = new FileWriter("output.txt");
		
		StringBuilder sb = new StringBuilder();
		String temp = null;
	
		int maximumInputNum = 0;
		int inputCounter = 0;
		int caze = 0;
		int calendarLineCount = 0;
		
		while((temp=fr.readLine()) != null) {
			if(inputCounter == 0) {
				System.out.println(temp);
				maximumInputNum = Integer.parseInt(temp);
			} else {
				String[] strs = temp.split(" ");
				//step 1 : 나눈값과 나머지를 가져온다.
				int months = Integer.parseInt(strs[0]);
				int daysPerMonth = Integer.parseInt(strs[2]);
				int daysPerWeek = Integer.parseInt(strs[1]);
				int offset = 0;
				calendarLineCount = 0;
				
				for(int i = 0; i < months; i++) {
					//#값을 밀고 한출 추가.(한주 - 미는값)
					int addedDaysPerMonth = daysPerMonth + offset;
					//기존 로직이랑 똑같음.
					calendarLineCount += addedDaysPerMonth/daysPerWeek + 1;
					offset = daysPerMonth%4;		
					
				}
				sb.append("Case #" + ++caze + ": " + calendarLineCount + "\n");
//				System.out.println(caze + " " + maximumInputNum);
				if(caze == maximumInputNum) break;
				
			}
			inputCounter++;
		}
		System.out.println(sb.toString());
		fw.write(sb.toString());
		fw.flush();

		
	}
}
/*
70
17 7 67
8 5 35
5 4 21
17 9 45
16 5 65
9 1 89
4 1 93
5 1 84
5 7 67
15 1 61
7 6 23
11 8 100
20 5 59
5 7 21
17 1 17
11 8 39
17 1 8
1 1 73
18 3 61
13 5 15
6 5 12
7 7 41
19 10 97
11 1 1
1 8 4
13 7 79
5 1 85
19 1 69
11 6 52
9 3 51
1 4 33
6 5 45
5 1 42
1 9 78
9 2 23
12 3 28
11 5 45
6 7 65
5 1 36
13 9 85
1 6 25
8 1 70
15 2 61
10 5 53
1 1 24
6 10 61
17 3 65
8 7 7
6 1 67
13 1 61
13 1 27
15 4 61
9 5 69
11 4 97
1 3 89
11 7 15
16 2 34
5 7 15
4 1 83
13 8 53
9 7 35
3 7 1
1 10 41
17 9 29
13 1 80
1 3 76
4 5 48
6 6 71
1 6 1
16 1 93
*/