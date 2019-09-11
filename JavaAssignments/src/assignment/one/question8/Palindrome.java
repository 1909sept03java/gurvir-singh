package assignment.one.question8;

import java.util.ArrayList;

//Question 8, Problem 8

public class Palindrome {
	
	public ArrayList<String> makePali(ArrayList<String> myList) {
		
		ArrayList<String> isPali = new ArrayList<String>();
		
		for(int i = 0; i < myList.size(); i++) {
			
			StringBuilder sb = new StringBuilder(myList.get(i));
			isPali.add(sb.reverse().toString());
			
		}
		
		return isPali;
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");
		
		Palindrome p = new Palindrome();
		ArrayList<String> thisList = new ArrayList<String>();
		thisList = p.makePali(myList);
		
		for(int i = 0; i < myList.size(); i++) {
			
			System.out.println(thisList.get(i));
		}
	}

}