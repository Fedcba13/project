package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10797

public class Exam10797 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int day = Integer.parseInt(sc.nextLine());
		String carStr[] = sc.nextLine().split("\\s");

		int car[] = new int[carStr.length];

		int cnt = 0;

		for (int i = 0; i < car.length; i++) {
			car[i] = Integer.parseInt(carStr[i]);
			if (car[i] == day) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}
