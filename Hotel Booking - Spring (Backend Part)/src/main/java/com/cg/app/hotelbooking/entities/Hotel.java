package com.cg.app.hotelbooking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
public class Hotel {
	@Id
	@NotNull
	private int hotel_id;
	private String city;
	private String hotel_name;
	private String address;
	@Email
	private String email;
	@Column(name="cost")
	private double avg_cost;
	@Size(min=10,max=10)
	private String phone;
	private String website;
	private int no_of_rooms;
/*	@ManyToMany
	@JoinColumn(name="user_id")
	private List<Passengers> visitors;*/
	private int count_of_booking;
	@ManyToMany
	@JoinColumn(name="review_id")
	private List<Review> rating;
	
	

	
}
