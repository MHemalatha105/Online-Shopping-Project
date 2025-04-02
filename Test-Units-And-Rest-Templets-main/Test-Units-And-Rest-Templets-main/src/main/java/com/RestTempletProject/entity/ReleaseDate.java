package com.RestTempletProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDate {

	public Object day;
	public int month;
	public int year;
	public String __typename;
}
