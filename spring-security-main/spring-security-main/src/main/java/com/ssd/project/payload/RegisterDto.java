package com.ssd.project.payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String username;
	@NotNull
	private String email;
	private String password;

	public RegisterDto(@NotNull String name, @NotNull String username, @NotNull String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
