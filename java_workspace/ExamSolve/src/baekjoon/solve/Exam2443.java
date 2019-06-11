package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2443

public class Exam2443 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < 2 * (num - i) - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

	}

}
