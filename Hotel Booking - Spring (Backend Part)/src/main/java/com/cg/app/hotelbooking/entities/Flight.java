package com.cg.app.hotelbooking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Flight {
	
	@Id
	@NotNull(message="flight id cannot be null")
	private int flight_id;
	private String flight_name;
	@Column(name="cost")
	private double avg_rate;
	@Email
	private String email;
	@Size(min=10,max=10)
	private String phone1;
	
	private String website;
	private String destination;
	private String departure;
	
	private int flightcapacity;

	private int count_of_booking;
	@ManyToMany
	@JoinColumn(name="review_id")
	private List<Review> reviews;
	
	

}
