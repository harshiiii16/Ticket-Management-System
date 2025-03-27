package com.ticket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketRequest {

	@Schema(example = "null")
	private Integer id;

	@NotEmpty
	@NotNull
	@Size(min = 10, max = 300, message = "min 10 & max 300 charcter")
	private String subject;

	@NotEmpty
	@NotNull
	@Size(min = 10, max = 300, message = "min 10 & max 300 charcter")
	private String description;

	@NotNull
	@Schema(example = "null")
	private Integer priority;

	@NotNull
	@Schema(example = "null")
	private Integer status;

	@NotNull
	private DepartmentDto department;

	private String comment;

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class DepartmentDto {
		@Schema(example = "null")
		private Integer id;
		private String name;
	}
}
