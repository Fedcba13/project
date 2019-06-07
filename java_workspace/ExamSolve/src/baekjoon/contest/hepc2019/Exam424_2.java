package baekjoon.contest.hepc2019;

import java.util.Scanner;

//https://www.acmicpc.net/contest/problem/424/2

public class Exam424_2 {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		String str1 = sc.nextLine();
		String str2 =  sc.nextLine();

		String strArr1[] = str1.split("\\s");
		String strArr2[] = str2.split("\\s");

		double[] doubleArr = new double[strArr2.length];

		for (int i = 0; i < strArr2.length; i++) {
			doubleArr[i] = Double.parseDouble(strArr2[i]);
		}

		double happy = 1.0;
		double sad = 1.0;

		double happyTemp = 1.0;
		double sadTemp = 1.0;
		
		if(strArr1[1] .equals("0")) {
			happy = doubleArr[0];
			sad = doubleArr[1];
			happyTemp = doubleArr[0];
			sadTemp = doubleArr[1];
		}else {
			happy = doubleArr[2];
			sad = doubleArr[3];
			happyTemp = doubleArr[2];
			sadTemp = doubleArr[3];
		}

		for (int i = 1; i < Integer.parseInt(strArr1[0]); i++) {
			happy = (happyTemp * doubleArr[0]) + (sadTemp * doubleArr[2]);
			sad = (happyTemp * doubleArr[1]) + (sadTemp * doubleArr[3]);

			happyTemp = happy;
			sadTemp = sad;
		}

		happy *= 1000;
		sad *= 1000;

		System.out.println(Math.round(happy));
		System.out.println(Math.round(sad));

	}

}
