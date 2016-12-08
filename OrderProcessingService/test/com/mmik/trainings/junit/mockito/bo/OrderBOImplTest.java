package com.mmik.trainings.junit.mockito.bo;

import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mmik.trainings.junit.mockito.dao.OrderDAO;
import com.mmik.trainings.junit.mockito.dto.Order;

public class OrderBOImplTest {

	// I ask to mock my DAO interface
	@Mock
	OrderDAO dao;

	@Before
	public void setup(){
		// I initialize to take into account the Mockito annotations :
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException{
		OrderBOImpl orderBO = new OrderBOImpl();
		// I passe the mocked dao variable 
		orderBO.setDao(dao);
		
		Order order = new Order();
		// static When method used to stub (= to replace temporary) and thenReturn to mock (= to simulate) the value return 
		when(dao.create(order)).thenReturn(new Integer(1));
	}

}
