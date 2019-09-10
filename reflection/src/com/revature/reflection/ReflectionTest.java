package com.revature.reflection;

import java.lang.reflect.Method; 
import java.lang.reflect.Field; 
import java.lang.reflect.Constructor; 

public class ReflectionTest { 
  
	private String str; //Private, but can be accessed through reflection methods.

	public ReflectionTest()  { 
		str = "Test String";
		
	 } 

 
	public void method1()  { 
		System.out.println(str); 
 } 


	public void method2(int x)  { 
		System.out.println(x); 
 } 

 
	private void method3() { 
		System.out.println("This is a private method"); 
 } 
	
}
