package com.ssd.Dto;

public class UserDto {
	
	
	private Integer Id;
	
	private String Name;
	private String EmailId;
	private Long MobileNo;
	private String Password;
	private String Address;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public Long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		MobileNo = mobileNo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public UserDto(Integer id, String name, String emailId, Long mobileNo, String password, String address) {
		super();
		Id = id;
		Name = name;
		EmailId = emailId;
		MobileNo = mobileNo;
		Password = password;
		Address = address;
	}
	public UserDto(String name, String emailId, Long mobileNo, String password, String address) {
		super();
		Name = name;
		EmailId = emailId;
		MobileNo = mobileNo;
		Password = password;
		Address = address;
	}
	public UserDto() {
	
	}
	@Override
	public String toString() {
		return "UserDto [Id=" + Id + ", Name=" + Name + ", EmailId=" + EmailId + ", MobileNo=" + MobileNo
				+ ", Password=" + Password + ", Address=" + Address + "]";
	}
	
	


}
