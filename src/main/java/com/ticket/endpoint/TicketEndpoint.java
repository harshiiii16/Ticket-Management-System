package com.ticket.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.dto.TicketRequest;
import com.ticket.dto.UpdateTktRequest;

import jakarta.validation.Valid;

@RequestMapping("/api/v1/ticket")
public interface TicketEndpoint {

	@PostMapping("/create-ticket")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<?> createTicket(@Valid @RequestBody TicketRequest ticketRequest) throws Exception;

	@PostMapping("/update-tkt")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTicket(@RequestBody UpdateTktRequest tktRequest) throws Exception;

	@GetMapping("/user-ticket")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getTicketByUser();

	@GetMapping("/all-ticket")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllTicket();

	@GetMapping("/search")
	@PreAuthorize("hasAnyRole('ADMIN','USER','ANALYST')")
	public ResponseEntity<?> searchTicket(@RequestParam("tkt_id") String ticketId) throws Exception;

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN','USER','ANALYST')")
	public ResponseEntity<?> getTicketById(@PathVariable("id") Integer id) throws Exception;

}
