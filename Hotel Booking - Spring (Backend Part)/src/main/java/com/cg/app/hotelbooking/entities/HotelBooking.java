package com.cg.app.hotelbooking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HotelBooking {
	@Id
	@SequenceGenerator(name="mylogic1",initialValue=300,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mylogic1")
	private int booking_id;
	private int hotelId;
	private String city;
	private Date fromDate;
	private Date toDate;
	private int user_id;
	private int cost;


}
