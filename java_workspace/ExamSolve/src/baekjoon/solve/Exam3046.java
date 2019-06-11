package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/3046

public class Exam3046 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int R1 = sc.nextInt();
		int S = sc.nextInt();

		int S2 = S * 2 - R1;

		System.out.println(S2);

	}

}
