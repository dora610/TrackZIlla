/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karurisuro.springBootMvc.entity.Ticket;
import com.karurisuro.springBootMvc.repository.TicketRepository;

/**
 * @author surajitkaruri
 *
 */
@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Iterable<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

}
