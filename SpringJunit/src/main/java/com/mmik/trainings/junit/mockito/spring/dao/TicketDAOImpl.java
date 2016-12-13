package com.mmik.trainings.junit.mockito.spring.dao;

import org.springframework.stereotype.Component;

import com.mmik.trainings.junit.mockito.spring.dto.Ticket;

// 1. Mark by annotation which component to inject
@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 0;
	}

}
