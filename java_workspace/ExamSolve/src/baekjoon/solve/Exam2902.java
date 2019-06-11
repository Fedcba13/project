package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2902

public class Exam2902 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name[] = sc.next().split("-");

		String result = "";

		for (int i = 0; i < name.length; i++) {
			result += name[i].toUpperCase().charAt(0);
		}

		System.out.println(result);
	}

}
