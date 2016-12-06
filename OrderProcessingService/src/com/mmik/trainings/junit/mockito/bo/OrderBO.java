package com.mmik.trainings.junit.mockito.bo;

import com.mmik.trainings.junit.mockito.bo.exception.BOException;
import com.mmik.trainings.junit.mockito.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;
}
