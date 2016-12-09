package com.mmik.trainings.junit.mockito.scrapbook;

public class A {

	private B b;
	
	public A(B b) {
		// TODO Auto-generated constructor stub
		this.b = b;
	}
	
	public int usesVoidMethod(){
		try {
			b.voidMethod();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return 1;
	}

}
