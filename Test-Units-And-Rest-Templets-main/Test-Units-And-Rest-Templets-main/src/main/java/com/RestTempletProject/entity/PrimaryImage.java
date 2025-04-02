package com.RestTempletProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrimaryImage {

	
	public String id;
    public int width;
    public int height;
    public String url;
    public Caption caption;
    public String __typename;
}
