package baekjoon.solve;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1094

public class Exam1094 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr.add(64);

		boolean flag = true;

		if (num == 64) {
			flag = false;
		}

		while (flag) {

			int sum = 0;

			for (int i = 0; i < arr.size(); i++) {
				sum += arr.get(i);
			}

			if (sum > num) {
				int min = 65;
				int minIndex = -1;
				for (int i = 0; i < arr.size(); i++) {
					if (min > arr.get(i)) {
						min = arr.get(i);
						minIndex = i;
					}
				}

				arr.remove(minIndex);
				arr.add(min / 2);
				sum = 0;
				for (int i = 0; i < arr.size(); i++) {
					sum += arr.get(i);
				}

				if (!(sum >= num)) {
					arr.add(min / 2);
				}

			}//if 끝

			sum = 0;

			for (int i = 0; i < arr.size(); i++) {
				sum += arr.get(i);
			}
			
			if(sum == num) {
				break;
			}
			
		}

		System.out.println(arr.size());

	}

}
