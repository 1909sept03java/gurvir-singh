package assignment.one.question15;

import java.util.Scanner;

//Question 15, Problem 17

public class Interest {
	
	public double isInterest(double principal, double rate, double time ) {
		
		rate = rate / 100;                          //To convert the percentage into a decimal.
		double accumulated = principal * rate * time;
		return accumulated;
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the initial money in your account?");
		double p = scanner.nextDouble();
		System.out.println("What percentage/rate does the money increase by in a year?");
		double r = scanner.nextDouble();
		System.out.println("Enter amount of time you want to see interest for.");
		double t = scanner.nextDouble();
		
		Interest m = new Interest();
		System.out.println("The interest you would make is " + m.isInterest(p, r, t));
		
		
	}

}