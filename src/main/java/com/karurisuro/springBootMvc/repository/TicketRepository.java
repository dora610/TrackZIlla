/**
 * 
 */
package com.karurisuro.springBootMvc.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.karurisuro.springBootMvc.entity.Ticket;

/**
 * @author surajitkaruri
 *
 */
public interface TicketRepository extends ListCrudRepository<Ticket, Long> {

}
