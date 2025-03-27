package com.ticket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTktRequest {
	
	private String ticketId;
	
	@Schema(example = "null")
	private Integer status;
	
	private String comment;
	
}
