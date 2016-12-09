package com.mmik.trainings.junit.mockito.scrapbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ATest {

	@Mock
	private B b;
	
	private A a;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}
	
	@Test
	public void usesVoidMethod_Should_Call_VoidMethod() throws Exception {
		// Nothing to stub and to expect when the dependent method is void type
		assertSame(1, a.usesVoidMethod()); // The B voidMethod method is called from the A usesVoidMethod method
		verify(b).voidMethod();
	}
	
	

}
