package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.dto.TicketRequest;
import com.ticket.dto.TicketResponse;
import com.ticket.dto.UpdateTktRequest;
import com.ticket.endpoint.TicketEndpoint;
import com.ticket.service.TicketService;
import com.ticket.util.CommonUtil;

@RestController
public class TicketController implements TicketEndpoint {

	@Autowired
	private TicketService ticketService;

	@Override
	public ResponseEntity<?> createTicket(TicketRequest ticketRequest) throws Exception {
		ticketService.saveTicket(ticketRequest);
		return CommonUtil.createBuildResponseMessage("Ticket raised Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> updateTicket(UpdateTktRequest tktRequest) throws Exception {
		ticketService.updateTicket(tktRequest);
		return CommonUtil.createBuildResponseMessage("Ticket updated", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getTicketByUser() {
		List<TicketResponse> tickets = ticketService.getAllTicketByUser();
		if (CollectionUtils.isEmpty(tickets))
			return ResponseEntity.noContent().build();
		return CommonUtil.createBuildResponse(tickets, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllTicket() {
		List<TicketResponse> tickets = ticketService.getAllTicket();
		if (CollectionUtils.isEmpty(tickets))
			return ResponseEntity.noContent().build();
		return CommonUtil.createBuildResponse(tickets, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> searchTicket(String ticketId) throws Exception {
		TicketResponse tktResp = ticketService.searchTicket(ticketId);
		return CommonUtil.createBuildResponse(tktResp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getTicketById(Integer id) throws Exception {
		TicketResponse tktResp =ticketService.getTicketById(id);
		return CommonUtil.createBuildResponse(tktResp, HttpStatus.OK);
	}

}
