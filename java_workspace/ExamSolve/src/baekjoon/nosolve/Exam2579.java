package baekjoon.nosolve;

import java.util.Scanner;

//https://www.acmicpc.net/problem/

public class Exam2579 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); //테스트 케이스 수
		sc.nextLine(); //개행문자 날리기
		
		int[] stairs = new int[T];
		int[] path = new int[T];
		int[] cnt = new int[T];
		
		for(int i=0; i<T; i++) {
			stairs[i] = sc.nextInt();
		}
		
		path[0] = stairs[0];
		path[1] = path[0] + stairs[1];
		path[2] = path[0] + stairs[2];
		cnt[0] = 1;
		cnt[1] = 2;
		cnt[2] = 1;
		
		for(int i=2; i<T;i++) {
			int path1 = 0;
			int path2 = 0;
			
			if(cnt[i-1] != 2) {
				path1 = path[i-1] + stairs[i];
			}
			
			path2 = path[i-2] + stairs[i];
			
			if(path1 > path2) {
				path[i] = path1;
				cnt[i] = 2;
			}else {
				path[i] = path2;
				cnt[i] = 1;
			}
			
		}
		
		System.out.println(path[T-1]);

	}

}
