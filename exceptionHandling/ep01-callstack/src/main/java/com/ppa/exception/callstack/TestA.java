package com.ppa.exception.callstack;

public class TestA {
	
	private TestB testB;
	
	public TestA() {
		testB = new TestB();
	}
	
	public int divide(int a, int b) {
			
			System.out.println("Class B work");
			
			int value = testB.divide(a, b);
			
			System.out.println("Class B end");
			
			return value;
			
		}

}
