package assignment.one.question4;

//Question 4, Problem 4
public class Factorial {
	
	public int fact(int n) {
		
		int f = 1;
		for(int i = n; i > 0; i--) {
			
			f = f * i;
			
		}
		
		return f;
		
	}
	
	public static void main(String[] args) {
		
		Factorial fac = new Factorial();
		System.out.println(fac.fact(5));
	}

}
