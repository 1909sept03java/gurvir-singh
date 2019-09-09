package com.revature.challenge1;

public class MutationTest {
	public static void main(String[] args) {
		
		Mutation m = new Mutation();
		String start = "AACCGGTT";
		String end1 = "AACCGGTT";
		String end2 = "AAACGGTA";
		String end3 ="AAAAAAAA";
		String[] bank = new String[3];
		bank[0] = "AACCGGTA";
		bank[1] = "AACCGCTA";
		bank[2] = "AAACGGTA";
		
		System.out.print("Shows if the end sequence is a valid mutation.");
		System.out.println("-1 = No such mutation, 0 = The are the same sequences.");
		System.out.println("Anything > 0 means its a valid mutation and the number of mutations needed "
				+ "to go from start to end");
		
		System.out.println(m.isMutation(start, end2, bank));
		
		System.out.println("The starting sequence " + start + " and " + end2 + 
				" are " + m.calcMutation(start, end2, bank));
	}
}
