package com.mmik.trainings.junit.mockito.scrapbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ATest {
	private A a;

	@Mock
	private B b;	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}
	
	@Test
	public void usesVoidMethod_Should_Call_VoidMethod() throws Exception {
		// the voidMethod can be stubbed implicitly : (nothing to do)
		// or explicitly like this :
		doNothing().when(b).voidMethod(); // do nothing when the voidMethod from the mocked class B is invoked.
		// The B voidMethod method is called within the A usesVoidMethod method
		assertSame(1, a.usesVoidMethod());  
		verify(b).voidMethod();
	}
	
	

}
