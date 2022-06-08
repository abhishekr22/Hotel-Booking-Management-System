package com.cg.app.hotelbooking.util;

import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.ReviewBasicInfoDTO;
import com.cg.app.hotelbooking.dto.ReviewSavePostDTO;
import com.cg.app.hotelbooking.entities.Review;

@Component
public class ReviewDTOConvertionClass {
	public ReviewBasicInfoDTO getReviewBasicInfoDTO(Review review) {
		ReviewBasicInfoDTO dtoObj=new ReviewBasicInfoDTO();
		dtoObj.setFeedback(review.getFeedback());
		dtoObj.setRating(review.getRating());
		dtoObj.setReview_id(review.getReview_id());
		dtoObj.setService_id(review.getService_id());
		dtoObj.setUser_id(review.getUser_id());
		dtoObj.setHotelcity(review.getHotelcity());
		dtoObj.setHotelname(review.getHotelname());
		return dtoObj;
	}
	public Review getReviewFromPostDTO(ReviewSavePostDTO dto) {
		Review r=new Review();
		r.setFeedback(dto.getFeedback());
		r.setRating(dto.getRating());
		r.setReview_id(dto.getReview_id());
		r.setService_id(dto.getService_id());
		r.setUser_id(dto.getUser_id());
		r.setHotelcity(dto.getHotelcity());
		r.setHotelname(dto.getHotelname());
		return r;
		
	}
}
