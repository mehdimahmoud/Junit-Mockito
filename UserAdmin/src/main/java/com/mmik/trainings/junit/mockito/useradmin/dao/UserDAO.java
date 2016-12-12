package com.mmik.trainings.junit.mockito.useradmin.dao;

import com.mmik.trainings.junit.mockito.useradmin.dto.User;
import com.mmik.trainings.junit.mockito.useradmin.exception.BOException;

public interface UserDAO {
	public long create(User user) throws BOException;
}
