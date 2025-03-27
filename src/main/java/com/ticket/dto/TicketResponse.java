package com.ticket.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({
    "id", "ticketId", "subject", "description", "priority", "status", 
    "department", "comment", "createdDate", "updatedDate", "createdBy", "updatedBy"
})
public class TicketResponse extends BaseDto{

	private Integer id;

	private String ticketId;

	private String subject;

	private String description;

	private String priority;

	private String status;

	private DepartmentDto department;

	private String comment;

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	private static class DepartmentDto {
		private Integer id;
		private String name;
	}

}
