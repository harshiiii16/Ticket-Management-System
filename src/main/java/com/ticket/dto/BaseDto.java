package com.ticket.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseDto {
	
	private Integer createdBy;

	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;
}
