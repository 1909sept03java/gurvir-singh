package assignment.one.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Question 7, Problem 7

public class EmployeeSort {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> myList = new ArrayList<Employee>();
		myList.add(new Employee("Gurvir", "Biology", 25));
		myList.add(new Employee("Jeremy", "Finance", 21));
		myList.add(new Employee("Pavi", "Anthropology", 27));
		
		Collections.sort(myList, new NameSort());
		
		System.out.println("This is sorted by name");
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		Collections.sort(myList, new DepartmentSort());
		
		System.out.println("This is sorted by Department");
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		Collections.sort(myList, new AgeSort());
		
		System.out.println("This is sorted by age");
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
	}
	
}

class Employee {
	String name;
	String department;
	int age; 
	
	public Employee(String name, String department, int age) {
		
		this.name = name;
		this.department = department;
		this.age = age;
		
	}
	
	public String toString() 
    { 
		
        return this.name + ", " + this.department + ", " + this.age; 
        
    }
	
}

class NameSort implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		
		return e1.name.compareTo(e2.name);
		
	}
	
}

class DepartmentSort implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		
		return e1.department.compareTo(e2.department);
		
	}
	
}

class AgeSort implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		
		return e1.age - e2.age;
	}
}