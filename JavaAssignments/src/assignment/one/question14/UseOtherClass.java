package assignment.one.question14;

//Question 14, Problem 15. Using the interface here

class UsingInterface implements Operations { //Made another class down below to tese the methods. 
	
	public int addition(int a, int b) {
		return a + b;
	}
	
	public int subtraction(int a, int b) {
		return a - b;
	}
	
	public int multiplication(int a, int b) {
		return a * b;
	}
	
	public int division(int a, int b) {
		return a / b;
	}
	
}

public class UseOtherClass {                              //Made a class in here to test the methods of the other class. 
	
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		UsingInterface test = new UsingInterface();
		System.out.println("The sum of 10 and 2 is " + test.addition(a, b));
		System.out.println("10 subtracted from 2 is " + test.subtraction(a, b));
		System.out.println("10 multiplied by 2 is " + test.multiplication(a, b));
		System.out.println("10 divided by 2 is " + test.division(a, b));
	}
	
}