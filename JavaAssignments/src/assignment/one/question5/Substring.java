package assignment.one.question5;

//Question 5, Problem 5

public class Substring {
	
	public String makeSubstring(String str, int idx) {
		
		char[] str1 = str.toCharArray();
		String str2 ="";
		for(int i = 0; i <= idx; i++) {
			
			str2 = str2 + str1[i];
			
		}
		
		return str2;
		
	}
	
	public static void main(String[] args) {
		
		Substring s = new Substring();
		System.out.println(s.makeSubstring("I am playing Apex today.", 16));
	}

}