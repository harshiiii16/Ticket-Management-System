package com.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	List<Ticket> findByCreatedBy(Integer id);

	Ticket findByTicketId(String ticketId);

}
