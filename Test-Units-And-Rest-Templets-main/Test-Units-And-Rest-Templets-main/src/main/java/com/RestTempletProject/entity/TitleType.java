package com.RestTempletProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleType {
	public String text;
	public String id;
	public boolean isSeries;
	public boolean isEpisode;
	public String __typename;
}
