package com.ssd.project.payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private long id;
	@NotNull(message = "name is required")
	private String name;
	@NotNull(message = "email is required")
	private String email;
	private String body;

}
