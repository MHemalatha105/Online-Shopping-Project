package com.ssd.service;

import com.ssd.Dao.UserDao;
import com.ssd.Dto.UserDto;

public class UserService {
	
	public UserDao  dao = new UserDao();
	 public void createuser(UserDto dto) {
		 dao.Createuser(dto);
	 }
	
	 public UserDto loginUser(UserDto dto) {
			
			return dao.loginUser(dto);
	 }
}
