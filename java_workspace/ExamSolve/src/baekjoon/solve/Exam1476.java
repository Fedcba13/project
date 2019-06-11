package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1476

public class Exam1476 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		for (int i = E;; i += 15) {
			int tempS =i;
			int tempM = i;
			if(tempS % 28 == 0) {
				tempS = 28;
			}else {
				tempS %= 28;
			}
			
			if(tempM % 19 == 0) {
				tempM = 19;
			}else {
				tempM %= 19;
			}
			
			if( S == tempS && M == tempM) {
				System.out.println(i);
				break;
			}
			
		}
	}

}
