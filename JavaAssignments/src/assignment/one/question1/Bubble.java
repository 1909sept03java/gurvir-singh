package assignment.one.question1;

//Question one, Problem 1

public class Bubble {
	
	public int[] bubbleSort(int[] myArray) {
		
		int n = myArray.length;
		
		for(int i = 0; i < n - 1; i++) { //Number of iterations of swaps needed to make sure its
			                             //its sorted if in the worse case the last number in the last index.
			for(int j = 0; j < n - i -1; j++ ) { //This way in each iteration you have to go one less index, since highest value should already be there. 
				
				if(myArray[j] > myArray[j + 1]) { //Swap here if condition is met
					
					int temp =myArray[j];
					myArray[j] = myArray[j + 1];
					myArray[j + 1] = temp;
				}
				
			}
			
		}
		
		return myArray;
	}
	
	public static void main(String[] args) {
		
		int[] testArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		Bubble b = new Bubble();
		
		int[] printArray = b.bubbleSort(testArray);
		
		for(int i = 0; i < printArray.length; i++) 
			System.out.println(printArray[i]);
	}

}