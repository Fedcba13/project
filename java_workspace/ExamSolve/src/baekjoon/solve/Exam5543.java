package baekjoon.solve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/

public class Exam5543 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int sang = sc.nextInt();
		int jung = sc.nextInt();
		int ha = sc.nextInt();
		int coke = sc.nextInt();
		int saida = sc.nextInt();
		
		int burger = sang > jung ? jung : sang;
		if(burger > ha) {
			burger = ha;
		}
				
		int drink = coke > saida ? saida : coke;
		
		System.out.println(burger + drink - 50);
		

	}

}
