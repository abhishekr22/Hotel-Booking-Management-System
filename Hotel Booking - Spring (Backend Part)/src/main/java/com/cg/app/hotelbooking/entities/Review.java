package com.cg.app.hotelbooking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Review {
	@Id
	@SequenceGenerator(name="idgen",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="idgen")
	private int review_id;
	@NotNull(message="field cannot be empty")
	private String feedback;
	@NotNull(message="field cannot be empty")
	@Range(max=5, min=1)
	private int rating;
	@NotNull(message="field cannot be empty")
	private int service_id;
	@NotNull(message="field cannot be empty")
	private int user_id;
	private String hotelcity;
	private String hotelname;
	
	
	


}
