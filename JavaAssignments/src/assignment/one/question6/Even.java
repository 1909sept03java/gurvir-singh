package assignment.one.question6;

//Question 6, Problem 6

public class Even {
	
	public boolean isEven(int n) {
		
		int temp = n / 2;
		int test = temp * 2;
		if(test == n) 
			return true;
		else 
			return false;
		
	}
	
	public static void main(String[] args) {
		
		Even test1 = new Even();
		System.out.println(test1.isEven(15));
		System.out.println(test1.isEven(130));
	}

}