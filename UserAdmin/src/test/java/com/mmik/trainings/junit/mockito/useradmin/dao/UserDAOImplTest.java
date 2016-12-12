package com.mmik.trainings.junit.mockito.useradmin.dao;

import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mmik.trainings.junit.mockito.useradmin.dto.User;
import com.mmik.trainings.junit.mockito.useradmin.exception.BOException;
import com.mmik.trainings.junit.mockito.useradmin.util.IDGenerator;

import static org.junit.Assert.*;
// 3. Add the static class to mock and parameterize the tests
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Unit test for UserDAOImpl.
 */
// 1. Tell to Junit that the testing runner is from PowerMock API and no longer
// from Junit API
@RunWith(PowerMockRunner.class)
// 2. Tell to Junit the class that we have to prepare to do the test
@PrepareForTest(IDGenerator.class)
public class UserDAOImplTest {
	private UserDAO userDao;

	public UserDAOImplTest(String testName) {
	}

	@Test
	public void createShouldReturnUserId() throws BOException {
		userDao = new UserDAOImpl();
		
		// 4. Stubbing and expectations 
		mockStatic(IDGenerator.class);
		when(IDGenerator.generateID()).thenReturn((long)1);
		
		// 5. Testing :
		long result = userDao.create(new User());
		assertEquals((long)1, result);
		
		// 6. Verify :
		verifyStatic();
	}

}
