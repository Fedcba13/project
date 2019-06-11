package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2446

public class Exam2446 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (N - i) + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = N - 1; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (N - i) + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
