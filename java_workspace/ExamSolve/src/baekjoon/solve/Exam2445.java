package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2445

public class Exam2445 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cnt = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= cnt; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			for (int j = 0; j < 2 * (cnt - i); j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

		for (int i = cnt - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			for (int j = 0; j < 2 * (cnt - i); j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
