package com.ticket.service;

import java.util.List;

import com.ticket.dto.TicketRequest;
import com.ticket.dto.TicketResponse;
import com.ticket.dto.UpdateTktRequest;

public interface TicketService {

	void saveTicket(TicketRequest ticketRequest) throws Exception;

	public List<TicketResponse> getAllTicket();
	
	public List<TicketResponse> getAllTicketByUser();

	TicketResponse searchTicket(String ticketId) throws Exception;

	TicketResponse getTicketById(Integer id) throws Exception;

	void updateTicket(UpdateTktRequest tktRequest) throws Exception;
	
}
