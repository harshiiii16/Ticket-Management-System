package com.ticket.service.impl;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ticket.dto.KeyValueDto;
import com.ticket.dto.TicketRequest;
import com.ticket.dto.TicketResponse;
import com.ticket.dto.UpdateTktRequest;
import com.ticket.entity.Ticket;
import com.ticket.entity.User;
import com.ticket.enums.Status;
import com.ticket.exception.ResourceNotFoundException;
import com.ticket.repository.TicketRepository;
import com.ticket.service.MasterService;
import com.ticket.service.TicketService;
import com.ticket.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MasterService masterService;

	@Override
	public void saveTicket(TicketRequest ticketRequest) throws Exception {
		validationRequest(ticketRequest);
		Ticket ticket = mapper.map(ticketRequest, Ticket.class);
		ticket.setTicketId("TKT" + new Random().nextInt(100000));
		ticketRepo.save(ticket);
	}

	private void validationRequest(TicketRequest ticketRequest) throws Exception {
		masterService.getPriorityById(ticketRequest.getPriority());
		masterService.getStatusById(ticketRequest.getStatus());
		masterService.getDepartmentById(ticketRequest.getDepartment().getId());
	}

	@Override
	public List<TicketResponse> getAllTicket() {
		return ticketRepo.findAll().stream().map(tkt -> {
			TicketResponse tktResp = mapper.map(tkt, TicketResponse.class);
			try {
				setPriority(tktResp, tkt.getPriority());
				setStatus(tktResp, tkt.getStatus());
			} catch (Exception e) {
				log.error("Error: {}", e.getMessage());
			}
			return tktResp;
		}).toList();
	}

	private void setStatus(TicketResponse tktResp, Integer statusId) throws Exception {
		KeyValueDto status = masterService.getStatusById(statusId);
		tktResp.setStatus(status.getName());
	}

	private void setPriority(TicketResponse tktResp, Integer priorityId) throws Exception {
		KeyValueDto priority = masterService.getPriorityById(priorityId);
		tktResp.setPriority(priority.getName());
	}

	@Override
	public List<TicketResponse> getAllTicketByUser() {
		User loggedInUser = CommonUtil.getLoggedInUser();
		return ticketRepo.findByCreatedBy(loggedInUser.getId()).stream().map(tkt -> {
			TicketResponse tktResp = mapper.map(tkt, TicketResponse.class);
			try {
				setPriority(tktResp, tkt.getPriority());
				setStatus(tktResp, tkt.getStatus());
			} catch (Exception e) {
				log.error("Error: {}", e.getMessage());
			}
			return tktResp;
		}).toList();
	}

	@Override
	public TicketResponse searchTicket(String ticketId) throws Exception {
		Ticket ticket = ticketRepo.findByTicketId(ticketId);
		if (ObjectUtils.isEmpty(ticket))
			throw new ResourceNotFoundException("Ticket Not found");
		return mapper.map(ticket, TicketResponse.class);
	}

	@Override
	public TicketResponse getTicketById(Integer id) throws Exception {
		Ticket ticket = ticketRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket Not found"));
		if (ObjectUtils.isEmpty(ticket))
			throw new ResourceNotFoundException("Ticket Not found");
		return mapper.map(ticket, TicketResponse.class);
	}

	@Override
	public void updateTicket(UpdateTktRequest tktRequest) throws Exception {
		Ticket existTicket = ticketRepo.findByTicketId(tktRequest.getTicketId());
		if(ObjectUtils.isEmpty(existTicket)) {
			throw new ResourceNotFoundException("Invalid Ticket Id");
		}
		if(existTicket.getStatus().equals(Status.CLOSED.getId())) {
			throw new IllegalArgumentException("Ticket already closed"); 
		}
		existTicket.setStatus(tktRequest.getStatus());
		existTicket.setComment(tktRequest.getComment());
		ticketRepo.save(existTicket);
	}

}
