package assignment.one.question10;

//Question 10, Problem 10

public class MinT {
	
	public int isSmaller(int a, int b) {
		
		int min;
		min = (a < b) ? a : b;
		return min;
	}
	
	public static void main(String[] args) {
		
		MinT m = new MinT();
		System.out.println("The minimum between 13 and 27 is " + m.isSmaller(27, 13));
	}

}