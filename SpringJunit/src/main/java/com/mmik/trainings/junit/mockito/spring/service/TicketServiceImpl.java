package com.mmik.trainings.junit.mockito.spring.service;

import com.mmik.trainings.junit.mockito.spring.dao.TicketDAO;
import com.mmik.trainings.junit.mockito.spring.dto.Ticket;

public class TicketServiceImpl implements TicketService {

	private TicketDAO ticketDao;

	public int buyTicket(String passengerName, int phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		int ticketId = ticketDao.createTicket(ticket);
		return ticketId;
	}

}
