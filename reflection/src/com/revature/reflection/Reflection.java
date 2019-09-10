package com.revature.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
   
	public static void main(String args[]) throws Exception  {  //Invoke method can throw an Exception which will be wrapped up as InvocationTargetException
        ReflectionTest myObj = new ReflectionTest();            //IllegalAccessException for example
  
        Class<?> myClass = myObj.getClass(); 
        System.out.println("The name of class is " + myClass.getName());
        //Will give name of class as its fully qualified name. 
  
         
        Constructor constructor = myClass.getConstructor(); 
        System.out.println("The name of constructor is " + constructor.getName()); 
        //Will give the name of the constructor as its fully qualified name. 
        
        Method[] methods = myClass.getMethods(); 
        System.out.println("The public methods of class are : "); 
  
        for (Method method:methods) 
        	System.out.println(method.getName()); 
        //This will print all the public methods of the class, as well as the 
        // public methods of the Object class. 
  
        Method callMethod2 = myClass.getDeclaredMethod("method2", int.class); 
        //Get the desired method. 
         
        callMethod2.invoke(myObj, 25); 
        //Invoke the method at runtime. 
  
        Field field = myClass.getDeclaredField("str"); 
        //Makes an object out of the field you declare. 
  
        field.setAccessible(true);
        //Allows you to access the field regardless of what access modifer
        //it has. In this case the string field was private. 
   
        field.set(myObj, "Hello"); 
        //Change the value of the field. 
        
        Method callMethod1 = myClass.getDeclaredMethod("method1"); 
        
        callMethod1.invoke(myObj); //The value of the string has changed. 
  
        
        Method callMethod3 = myClass.getDeclaredMethod("method3"); 
 
        callMethod3.setAccessible(true); 
        
        callMethod3.invoke(myObj); //Going to call a private method
    } 
	
}