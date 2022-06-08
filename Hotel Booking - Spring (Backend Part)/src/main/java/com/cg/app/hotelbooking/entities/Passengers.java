package com.cg.app.hotelbooking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Passengers {
	@Id
	@SequenceGenerator(name="mylogic1",initialValue=200,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mylogic1")
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
}
