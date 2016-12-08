package com.mmik.trainings.junit.mockito.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mmik.trainings.junit.mockito.bo.exception.BOException;
import com.mmik.trainings.junit.mockito.dao.OrderDAO;
import com.mmik.trainings.junit.mockito.dto.Order;

public class OrderBOImplTest {

	// I ask to mock my DAO interface
	@Mock
	OrderDAO dao;
	private OrderBOImpl orderBO;

	@Before
	public void setup() {
		// I initialize to take into account the Mockito annotations into this class :
		MockitoAnnotations.initMocks(this);

		orderBO = new OrderBOImpl();
		orderBO.setDao(dao);
	}

	/**
	 * Positive scenario
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		OrderBOImpl orderBO = new OrderBOImpl();
		// I passe the mocked "dao" variable
		orderBO.setDao(dao);

		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) and
		// thenReturn to mock (= to simulate) the returned value
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));

		// I test the placeOrder call :
		boolean result = orderBO.placeOrder(order);
		assertTrue(result);

		// Verify the stubbed method is called at least once :
		verify(dao).create(order);

	}

	/**
	 * Negative scenario
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {

		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) and
		// thenReturn to mock (= to simulate) the returned value
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));

		// I test the placeOrder call :
		boolean result = orderBO.placeOrder(order);
		assertFalse(result);

		// Verify the stubbed method is called at least once :
		verify(dao).create(order);

	}

	/**
	 * Mocking exception scenario
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException_When_Create_An_Order() throws SQLException, BOException {

		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) and
		// thenReturn to mock (= to simulate) the returned value
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);

		// I test the placeOrder call to :
		boolean result = orderBO.placeOrder(order);
	}

}
