package com.mmik.trainings.junit.mockito.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
		// I initialize to take into account the Mockito annotations into this
		// class :
		MockitoAnnotations.initMocks(this);

		orderBO = new OrderBOImpl();
		orderBO.setDao(dao);
	}

	/**
	 * Positive scenario for placeOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "create" method and
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
	 * Negative scenario for placeOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "create" method and
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
	 * Mocking exception scenario for placeOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException_When_Create_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "create" method and
		// thenThrow to mock (= to simulate) the exception
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);

		// I test the placeOrder call :
		orderBO.placeOrder(order);

		// Nothing to assert when an exception is thrown
	}

	/**
	 * Positive scenario for cancelOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void cancelOrder_Should_Cancel_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "read" method afterwards "update" method and
		// thenReturn to mock (= to simulate) the returned value
		Order order = new Order();
		Integer id = new Integer(1);
		when(dao.read(id)).thenReturn(order);

		// update the order
		when(dao.update(order)).thenReturn(new Integer(1));

		// I test the cancelOrder call :
		boolean result = orderBO.cancelOrder(id);
		assertTrue(result);

		// Verify the stubbed method is called at least once :
		verify(dao).read(id);
		verify(dao).update(order);

	}

	/**
	 * Negative scenario for cancelOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void cancelOrder_Should_Not_Cancel_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "read" method afterwards "update" method and
		// thenReturn to mock (= to simulate) the returned value
		Order order = new Order();
		Integer id = new Integer(1);
		when(dao.read(id)).thenReturn(order);

		// update the order
		when(dao.update(order)).thenReturn(new Integer(0));

		// I test the cancelOrder call :
		boolean result = orderBO.cancelOrder(id);
		assertFalse(result);

		// Verify the stubbed method is called at least once :
		verify(dao).read(id);
		verify(dao).update(order);

	}

	/**
	 * Mocking Exception scenario for cancelOrder method on Read order
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOException_onRead_When_Cancel_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "read" method and
		// thenThrow to mock (= to simulate) the exception
		Integer id = new Integer(1);
		when(dao.read(id)).thenThrow(SQLException.class);

		// I test the cancelOrder call :
		boolean result = orderBO.cancelOrder(id);

		// Nothing to assert when an exception is thrown
	}

	/**
	 * Mocking Exception scenario for cancelOrder method on Update order
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOException_onUpdate_When_Cancel_An_Order() throws SQLException, BOException {
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) the
		// "update" method and
		// thenThrow to mock (= to simulate) the exception
		Order order = new Order();
		Integer id = new Integer(123);
		when(dao.read(id)).thenReturn(order);

		// update the order
		when(dao.update(order)).thenThrow(SQLException.class);

		// I test the cancelOrder call :s
		boolean result = orderBO.cancelOrder(id);

		// Nothing to assert when an exception is thrown
	}

	/**
	 * Positive scenario for deleteOrder method
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void deleteOrder_Should_Delete_An_Order() throws SQLException, BOException {
		// Integer id = new Integer(123); anyInt() replace this line
		// Stubbing and setting expectations
		when(dao.delete(anyInt())).thenReturn(new Integer(1));

		boolean result = orderBO.deleteOrder(anyInt());
		assertTrue(result);
		// Verify
		verify(dao,times(1)).delete(anyInt()); // if we put 2 times the test will be failed
		// verify(dao,times(1)).delete(id); // how many times the delete method is called from the dao
		// or 
		// verify(dao,atLeast(1)).delete(id); // the delete method should be called at least once
	}

}
