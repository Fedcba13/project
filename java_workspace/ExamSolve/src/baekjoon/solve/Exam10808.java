package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10808

public class Exam10808 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				arr[s.charAt(i) - 'a']++;
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				arr[s.charAt(i) - 'A']++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(" ");
			}
		}

	}

}
