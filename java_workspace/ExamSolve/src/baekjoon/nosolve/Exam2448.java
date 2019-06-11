package baekjoon.nosolve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2448

public class Exam2448 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int[][] arr = new int[num + 1][num * 2 + 1];

		arr[1][num] = 1;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < num; i++) {
			s.append(" ");
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= num; i++) {
			cnt = 0;
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					System.out.print(s.substring(0,cnt));
					cnt = 0;
					System.out.print("*");
					if (i % 3 == 1) {
						if (i + 3 < arr.length) {
							if (arr[i + 3][j - 3] == 1) {
								arr[i + 3][j - 3] = 0;
							} else {
								arr[i + 3][j - 3] = 1;
							}

							if (arr[i + 3][j + 3] == 1) {
								arr[i + 3][j + 3] = 0;
							} else {
								arr[i + 3][j + 3] = 1;
							}
						}
						arr[i + 1][j - 1] = 1;
						arr[i + 1][j + 1] = 1;
						arr[i + 2][j - 2] = 1;
						arr[i + 2][j - 1] = 1;
						arr[i + 2][j] = 1;
						arr[i + 2][j + 1] = 1;
						arr[i + 2][j + 2] = 1;
					}
				} else {
					cnt++;
				}
			}
			System.out.print(s.substring(0,cnt));
			System.out.println();
		}
	}

}
