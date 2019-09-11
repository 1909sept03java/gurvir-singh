package assignment.one.question12;

//Question 12, Problem 12

public class EnhancedEven {

	public boolean isEven(int n) {
		
		if(n % 2 == 0) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		int[] myArray = new int[100];
		for(int i = 0; i <100; i++) {
			
			myArray[i] = i + 1;
			
		}
		
		EnhancedEven e = new EnhancedEven();
		
		for(int j: myArray) {
			
			if(e.isEven(myArray[j -1])) {
				
				System.out.println(myArray[j - 1]);
				
			}
			
		}
		
	}
	
}
