package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1100

public class Exam1100 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			String str = sc.nextLine();
			int compare;
			if(i%2 == 0) {
				compare = 0;
			}else {
				compare = 1;
			}
			
			for(int j=0; j<8;j++) {
				if(str.charAt(j) == 'F') {
					if(j%2 == compare) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

}
