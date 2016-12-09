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
		// the voidMethod is stubbed implicitly : (nothing to do)
		// The B voidMethod method is called from the A usesVoidMethod method
		assertSame(1, a.usesVoidMethod()); 
		verify(b).voidMethod();
	}
	
	

}
