package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/9012

public class Exam9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		sc.nextLine(); //개행문자 날리기 용
		
		for(int i=0; i<T; i++) {
			StringBuffer tempBuffer = new StringBuffer(sc.nextLine()); // 라인 읽어오기.
			boolean flag = true;
			int index = 0;
			int size = tempBuffer.length();
			
			if(size%2 == 1) {
				flag = false;
			}
			
			while(flag == true) {
				
				if(size == 0) {
					break;
				}
				
				if(index+1 < size) {
					if(tempBuffer.charAt(index) == '(' && tempBuffer.charAt(index+1) == ')') {
						tempBuffer.delete(index, index+2);
						size -= 2;
						if(index != 0) {
							index--;
						}else {
							index = 0;
						}
					}else {
						index++;
					}
				}else {
					flag = false;
				}
			}
			
			if(flag == true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}

	}

}
