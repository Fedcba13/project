package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2163

public class Exam2163 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int temp1 = (M-1) + (M*(N-1));
		int temp2 = (N-1) + (N*(M-1));
		
		int result = temp1 < temp2 ? temp1 : temp2;

		System.out.println(result);

	}

}
