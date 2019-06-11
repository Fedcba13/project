package programmers.solve;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/42890

public class Exam42890 {

	public static void main(String[] args) {
		String[][] temp = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		
		Exam42890 e = new Exam42890();
		System.out.println(e.solution(temp));
	}
	
	int answer = 0;
	
	ArrayList<String> arr[];
	
	public int solution(String[][] relation) {
		
		 arr = new ArrayList[relation[0].length];
		 
		 for(int i=0; i<relation[0].length; i++) {
			 for(int j=0; j<relation.length; j++) {
				 
			 }
		 }
        int size = relation.length;
        
        
        
        return answer;
    }
	
	public void run(String[][] relation, String s) {
		
	}

}
