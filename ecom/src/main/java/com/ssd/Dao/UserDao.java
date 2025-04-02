package com.ssd.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssd.Dbcoonection.DbConnection;
import com.ssd.Dto.UserDto;

public class UserDao {
	
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static String INSERTUSER = "INSERT INTO userdetails (Name, EmailId, Password, MobileNo, Address) VALUES (?,?,?,?,?)";

	public static String LOGINUSER = "select * from userdetails where EmailId=? and Password=?";

	public void Createuser(UserDto dto) {

		try {
			conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(INSERTUSER);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmailId());
			ps.setString(3, dto.getPassword());
			ps.setLong(4, dto.getMobileNo());
			ps.setString(5, dto.getAddress());

			int noOfRecords = ps.executeUpdate();

		} catch (SQLException e) {

			
			e.printStackTrace();
		}

	}

	public UserDto loginUser(UserDto dto) {
		
		UserDto userDto =null;
		
		try {
			conn = DbConnection.getDbConnection();
			ps = conn.prepareStatement(LOGINUSER);
			ps.setString(1, dto.getEmailId());
			ps.setString(2, dto.getPassword());


			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				userDto = new UserDto();
				
				userDto.setId(rs.getInt(1));
				userDto.setName(rs.getString(2));
				userDto.setEmailId(rs.getNString(3));
				userDto.setMobileNo(rs.getLong(4));
				userDto.setPassword(rs.getString(5));
				userDto.setAddress(rs.getString(6));
				
				
			}

		} catch (SQLException e) {

			
			e.printStackTrace();
		}
      return userDto;


    }
			
	
	

}
