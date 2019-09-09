package com.revature.challenge1;

public class Mutation { //For now I am trying to make methods to figure out if mutation
	                    // is valid, the same, or how many mutations needed.
	                    //Will try and figure out if mutation is possible with bank
	                    //after
	
	public int isMutation(String start, String end, String[] bank) {
		
		char[] first = start.toCharArray();
		char[] second = end.toCharArray();
		int isMut = -1;
		
		if((first.length != second.length) || second.length !=8) 
			isMut = -1;
		else if(end.equals(bank[0]))
			isMut = 1;
		else if(end.equals(bank[1])) 
			isMut = 2;
		else if(end == bank[2])
			isMut = 3;
		else if(start.equals(end))
			isMut = 0;
		
		return isMut;
	}
	
	public int calcMutation(String start, String end, String[] bank) {
		
		Mutation m = new Mutation();
		int testX = m.isMutation(start, end, bank);
		int count = 0;
		char[] testArray = new char[8];
		char[] endArray = end.toCharArray();
		
		//System.out.println(testX);
	
		if(testX == -1)
			return -1;
		else if(testX == 0)
			return 0;
		else if(testX == 1)
			testArray = bank[0].toCharArray();
		else if(testX == 2)
			testArray = bank[1].toCharArray();
		else if(testX == 3) {
			testArray = bank[2].toCharArray();
			for(int i = 0; i < testArray.length; i++) {
				if(endArray[i] != testArray[i]) 
					count = count + 1;
				
			}
		}
		
		return count;
		
	}

}