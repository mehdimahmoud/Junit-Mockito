package com.mmik.trainings.junit.mockito.bo;

import java.sql.SQLException;

import com.mmik.trainings.junit.mockito.bo.exception.BOException;
import com.mmik.trainings.junit.mockito.dao.OrderDAO;
import com.mmik.trainings.junit.mockito.dto.Order;

public class OrderBOImpl implements OrderBO {

	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			if (result == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("Cancelled");
			int result = dao.update(order);
			if(result == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if(result == 0)
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
