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

	@Before
	public void setup(){
		// I initialize to take into account the Mockito annotations into this class :
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException{
		OrderBOImpl orderBO = new OrderBOImpl();
		// I passe the mocked "dao" variable 
		orderBO.setDao(dao);
		
		// Stubbing and setting expectations :
		// call the "When static method to stub (= to replace temporary) and thenReturn to mock (= to simulate) the value return 
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		
		// I test the placeOrder call :
		boolean result = orderBO.placeOrder(order);
		assertTrue(result);
		
		// Verify the stubbed method is called once :
		verify(dao).create(order);
		
	}

}