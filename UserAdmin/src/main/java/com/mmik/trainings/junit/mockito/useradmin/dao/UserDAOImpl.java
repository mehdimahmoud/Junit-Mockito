package com.mmik.trainings.junit.mockito.useradmin.dao;

import com.mmik.trainings.junit.mockito.useradmin.dto.User;
import com.mmik.trainings.junit.mockito.useradmin.exception.BOException;
import com.mmik.trainings.junit.mockito.useradmin.util.IDGenerator;

public class UserDAOImpl implements UserDAO {
	public long create(User user) throws BOException {
		long id = IDGenerator.generateID(); // UserDAO is dependent on IDGenerator class
		// Save the user object in the DB		
		return id;
	}
}
