package baekjoon.solve;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11399

public class Exam11399 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = Integer.parseInt(sc.nextLine());
		String arr[] = sc.nextLine().split("\\s");

		int num[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}

		Arrays.sort(num);

		int tmp = 0;
		int total = 0;

		for (int i = 0; i < arr.length; i++) {
			tmp = tmp + num[i];
			total += tmp;
		}

		System.out.println(total);
	}

}
