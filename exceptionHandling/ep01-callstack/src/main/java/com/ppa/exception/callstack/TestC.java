package com.ppa.exception.callstack;

public class TestC {

	public int divide(int a, int b) {
		
		System.out.println("Class C work");
		
		int value = a/b;
		
		System.out.println("Class  C end");
		
		return value;
	}
}
