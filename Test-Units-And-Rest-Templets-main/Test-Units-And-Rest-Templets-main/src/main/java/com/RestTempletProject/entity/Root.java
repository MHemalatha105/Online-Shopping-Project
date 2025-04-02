package com.RestTempletProject.entity;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    public int page;
    public String next;
    public int entries;
    public ArrayList<Result> results;
}
