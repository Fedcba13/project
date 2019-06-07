package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2522

public class Exam2522 {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < (a-1) - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i < a; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < a - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
