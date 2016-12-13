package com.mmik.trainings.junit.mockito.spring.dao;

import static org.junit.Assert.*;

import com.mmik.trainings.junit.mockito.spring.dto.Ticket;

/**
 * Unit test for TicketDAOImplTest.
 */
public class TicketDAOImplTest {
	private TicketDAO ticketDAOImpl;

	public void createTicket_should_return_long_value() {
		ticketDAOImpl = new TicketDAOImpl();
		Ticket ticket = null;
		int result = ticketDAOImpl.createTicket(ticket);
		assertEquals(1, result);
	}
}
