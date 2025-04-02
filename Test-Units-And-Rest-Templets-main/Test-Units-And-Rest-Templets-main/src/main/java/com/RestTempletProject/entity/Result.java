package com.RestTempletProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	public String _id;
    public String id;
    public PrimaryImage primaryImage;
    public TitleType titleType;
    public TitleText titleText;
    public OriginalTitleText originalTitleText;
    public ReleaseYear releaseYear;
    public ReleaseDate releaseDate;
}
