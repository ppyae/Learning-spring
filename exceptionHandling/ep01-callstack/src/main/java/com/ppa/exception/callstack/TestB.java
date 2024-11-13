
package com.ppa.exception.callstack;

public class TestB {
	
	private TestC testC;
	
	public TestB() {
		testC = new TestC();
	}
	
	public int divide(int a, int b) {
		
		System.out.println("Class C work");
		
		try {
			int value = testC.divide(a, b);
			return value;
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		System.out.println("Class C end");
		
		return 0;
		
	}

}
