package assignment.one.question3;

//Question 3, Problem 3

public class ReverseString {
	
	public String reverse(String str){
		
		for(int i = 0; i < str.length() - 1; i++) {
			str = str.substring(1, str.length() - i) + str.substring(0, 1) + str.substring(str.length() - i, str.length());
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		ReverseString rS = new ReverseString();
		System.out.println(rS.reverse("greatest"));
		
	}
}