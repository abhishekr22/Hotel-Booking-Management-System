package com.cg.app.hotelbooking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightBooking {
	@Id
	@SequenceGenerator(name="mylogic",initialValue=400,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mylogic")
	private int bookingid;
	@NotNull(message="flightid cannot be null")
	private int flightId;
	private String departure;
	private String destination;
	private Date onDate;
	private double cost;
	private int user_id;
}
