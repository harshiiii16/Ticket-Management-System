package com.ticket.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

	@Schema(example = "null")
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobNo;

	private String password;

	@Schema(description = "Role data for the user")
	private List<RoleDto> roles;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	@Schema
	public static class RoleDto {
		@Schema(example = "null")
		private Integer id;
		private String name;
	}
}
