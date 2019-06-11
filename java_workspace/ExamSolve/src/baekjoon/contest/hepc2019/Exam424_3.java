package baekjoon.contest.hepc2019;

import java.util.Scanner;

//https://www.acmicpc.net/contest/problem/424/3

public class Exam424_3 {

	static int cnt = 0;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();

		int tmpmoney = money;

		cnt += tmpmoney / 7;
		tmpmoney %= 7;

		cnt += tmpmoney / 5;
		tmpmoney %= 5;

		cnt += tmpmoney / 2;
		tmpmoney %= 2;

		cnt += tmpmoney;

		// 1,2,5,7

		for (int i = (money / 7); i >= 0; i++) {
			check5(money, i * 7, i);
		}
		
		System.out.println(cnt);

	}

	public static void check5(int money, int tmpmoney, int cnt2) {
		if (cnt2 >= cnt) {
			return;
		}

		for (int i = ((money - tmpmoney) / 5); i >= 0; i++) {
			check3(money, tmpmoney + (i * 5), cnt2 + i);
		}

	}

	public static void check3(int money, int tmpmoney, int cnt2) {

		if (cnt2 >= cnt) {
			return;
		}

		for (int i = ((money - tmpmoney) / 3); i >= 0; i++) {
			check1(money, tmpmoney + (i * 3), cnt2 + i);
		}
	}

	public static void check1(int money, int tmpmoney, int cnt2) {
		cnt2 = cnt2 + (money - tmpmoney);
		if (cnt2 < cnt) {
			cnt = cnt2;
		}

	}

}
