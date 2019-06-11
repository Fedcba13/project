package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11022

public class Exam11022 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cnt = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < cnt; i++) {
			String[] tmp = sc.nextLine().split("\\s");

			int num1 = Integer.parseInt(tmp[0]);
			int num2 = Integer.parseInt(tmp[1]);

			System.out.println("Case #" + (i + 1) + ": " + num1 + " + " + num2 + " = " + (num1 + num2));

		}

	}

}
