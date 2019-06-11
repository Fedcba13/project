package baekjoon.solve;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;// 점수
		int sum = 0; // 합계
		int[] man = new int[5];
		System.out.println(" 5명 점수입력 ");
		for (int i = 0; i < man.length; i++) {

			man[i] = sc.nextInt();
			if (man[i] < 40) {
				man[i] = 40;
			}
			sum += man[i];

		}
		System.out.println(sum / 5);

	}
}
