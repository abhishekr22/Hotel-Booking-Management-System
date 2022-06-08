package com.cg.app.hotelbooking.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerSavePostDTO {
	@NotNull
	private int user_id;
	@NotNull(message="user_name cannot be null")
	private String user_name;
	@Email
	private String email;
	@NotNull(message="password cannot be null")
	private String password;
	@Size(min=10,max=10)
	private String mobile;
	private String address;
	
	public CustomerSavePostDTO(@NotNull int user_id, @NotNull(message = "user_name cannot be null") String user_name,
			@Email String email, @NotNull(message = "password cannot be null") String password,
			@Size(min = 10, max = 10) String mobile, String address) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
