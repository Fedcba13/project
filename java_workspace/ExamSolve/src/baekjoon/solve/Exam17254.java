package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/17254

public class Exam17254 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] tmp = sc.nextLine().split("\\s");
		int num1 = Integer.parseInt(tmp[0]); // 3, 2
		int num2 = Integer.parseInt(tmp[1]); // 5,7
		
		String[] arr = new String[num2];

		for (int i = 0; i < num2; i++) {
			arr[i] = sc.nextLine();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {

				int order1 = Integer.parseInt(arr[j].split("\\s")[1]);
				int order2 = Integer.parseInt(arr[j + 1].split("\\s")[1]);

				if (order1 > order2) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} else if (order1 == order2) {
					order1 = Integer.parseInt(arr[j].split("\\s")[0]);
					order2 = Integer.parseInt(arr[j + 1].split("\\s")[0]);

					if (order1 > order2) {
						String temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;

					}
				}

			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].split("\\s")[2]);
		}
		
	}

}
