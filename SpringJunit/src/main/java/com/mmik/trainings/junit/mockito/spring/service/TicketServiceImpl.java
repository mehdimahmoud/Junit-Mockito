package com.mmik.trainings.junit.mockito.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mmik.trainings.junit.mockito.spring.dao.TicketDAO;
import com.mmik.trainings.junit.mockito.spring.dto.Ticket;

//1. Mark by annotation which component should be receive the injection :
@Component
public class TicketServiceImpl implements TicketService {

	// 2. Mark which object to inject :
	@Autowired
	private TicketDAO ticketDao;

	public int buyTicket(String passengerName, int phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		int ticketId = ticketDao.createTicket(ticket);
		return ticketId;
	}

}
