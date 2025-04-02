package com.ssd.project.payload;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

	private Long Id;
	@NotNull (message = "title is required")
	private String title;
	@NotNull (message = "description is required")
	private String description;
	private String content;
	private Date postDate;

	public PostDto(String title, String description, String content, Date postDate) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "PostDto [Id=" + Id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", postDate=" + postDate + "]";
	}

}
