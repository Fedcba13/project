package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2455

public class Exam2455 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int result = 0;
		int max = 0;

		for (int i = 0; i < 4; i++) {
			String[] tmp = sc.nextLine().split("\\s");

			result -= Integer.parseInt(tmp[0]);

			result += Integer.parseInt(tmp[1]);

			if (max < result) {
				max = result;
			}

		}

		System.out.println(max);

	}

}
