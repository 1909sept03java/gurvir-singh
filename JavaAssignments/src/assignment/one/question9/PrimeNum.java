package assignment.one.question9;

import java.util.ArrayList;
import java.util.Collections;

//Question 9, Problem 9

public class PrimeNum {
	
	public boolean isPrime(int n) {
		
		 int r;
	        for (int i = 2; i <= n / 2; i++) {
	        	
	            r = n % i;
	            if (r == 0) {
	            	
	                return false;
	                
	            }
	        }
	        
	        return true;
	        
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			
			myList.add(i);
		}
		
		int max = Collections.max(myList);
		
		PrimeNum p = new PrimeNum();
		
		for(int i = 1; i <= max; i++) {
			if(p.isPrime(i))
				System.out.println(i);
			
		}
		
	}

}