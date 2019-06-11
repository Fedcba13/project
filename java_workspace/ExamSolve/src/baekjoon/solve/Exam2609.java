package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2609

public class Exam2609 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int su = 1;
		int divide = 1;

		while (num1 != divide && num2 != divide) {
			divide++;
			if (num1 % divide == 0 && num2 % divide == 0) {
				num1 /= divide;
				num2 /= divide;
				su *= divide;
				divide = 1;
			}
		}

		System.out.println(su);
		System.out.println(num1 * num2 * su);

	}

}
