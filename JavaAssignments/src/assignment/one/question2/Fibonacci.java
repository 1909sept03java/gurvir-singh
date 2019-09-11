package assignment.one.question2;

//Question 2, Problem 2

public class Fibonacci {
	
	public int[] fibo(int n) {    // n is for the number of fibonacci numbers. In this case it will be 25. 
		
		int[] myArray = new int[n];
		myArray[0] = 0;
		int temp = 1;
		
		for(int i =1; i < n; i++) {
			
			int sum = myArray[i -1] + temp;        //To figure out next number in the sequence. 
		    myArray[i] = temp;
		    temp = sum;	
			
		}
		
		return myArray;
		
	}
	
	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		int[] testArray = f.fibo(25);
		for(int i = 0;i < testArray.length; i++) { //Print the fibonacci numers. 
			
			if(i != testArray.length - 1)
				System.out.print(testArray[i] + ", ");
			else 
				System.out.println(testArray[i]);
			
		}
		System.out.println("");
	}

}