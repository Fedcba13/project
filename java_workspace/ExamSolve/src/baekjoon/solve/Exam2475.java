package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2475

public class Exam2475 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] strArr = sc.nextLine().split("\\s");

		int num = 0;

		for (int i = 0; i < strArr.length; i++) {
			int temp = Integer.parseInt(strArr[i]);
			num += temp * temp;
		}

		num %= 10;

		System.out.println(num);

	}

}
