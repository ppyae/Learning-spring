package com.ppa.exception.callstack;

public class Application {
	
	public static void main(String[] args) {
		
		var instance = new TestA();
		
		System.out.println("Main app work");
		
		var value = instance.divide(10, 0);
		
		System.out.printf("Value is %d%n",value);
	}

}
