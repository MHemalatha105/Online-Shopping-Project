package com.RestTempletProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.RestTempletProject.entity.Root;

@Service
public class MovieService {

	@Autowired
	public RestTemplate restTemplate;

	@Value("${movie.url}")
	public String url;


	public Root findByAllMovies() {
		Root names = null;
		try {

			HttpHeaders headers = new HttpHeaders();

			headers.set("X-RapidAPI-Key", "0533d90bc0msh0653cb918b7172dp1b1d4djsn789ef3a4ff11");
			headers.set("X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com");

			HttpEntity<Root> entity = new HttpEntity<Root>(headers);
			names = restTemplate.exchange(url, HttpMethod.GET, entity, Root.class).getBody();

			System.out.println(names);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return names;

	}

}
