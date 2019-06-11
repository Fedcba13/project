package baekjoon.contest.hepc2019;

import java.util.Scanner;

//https://www.acmicpc.net/contest/problem/424/1

public class Exam424_1 {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		// 1 2 3 4 5
		// 0 1 0 1 0
		long a;
		int b;
		a = sc.nextLong();
		b = sc.nextInt();

		boolean flag = true;

		if (a >= 6) {
			System.out.println("Love is open door");
			return;
		}

		int[] door = new int[(int) (a + 1)];

		for (int i = 1; i < door.length; i++) {
			door[i] = -1;
		}

		door[1] = b;
		if (b == 0) {
			door[2] = 1;
			if (a >= 3) {
				door[3] = 0;
			}
		} else {
			door[2] = 0;
			if (a >= 3) {
				door[3] = 1;
			}
		}

		for (int i = 2; i < door.length; i = i + 2) {
			if (door[i] == -1) {
				door[i] = door[2];
			}
		}

		for (int i = 3; i < door.length; i = i + 3) {
			if (door[i] == -1) {
				door[i] = door[3];
			} else {
				if ((door[i] != door[3])) {
					flag = false;
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("Love is open door");
			return;
		}

		for (int i = 1; i < door.length; i++) {

			if (door[i] == -1) {
				if (door[i - 1] == 1) {
					door[i] = 0;
				} else {
					door[i] = 1;
				}
			}

			if (i > 2) {
				if (i % 2 == 0) {
					if (door[i] != door[i - 2]) {
						flag = false;
						break;
					}
				}
			}
			if (i > 3) {
				if (i % 3 == 0) {
					if (door[i] != door[i - 3]) {
						flag = false;
						break;
					}
				}
			}

		}

		if (!flag) {
			System.out.println("Love is open door");
			return;
		}

		for (int i = 2; i < door.length; i++) {
			System.out.println(door[i]);
		}

	}

}
