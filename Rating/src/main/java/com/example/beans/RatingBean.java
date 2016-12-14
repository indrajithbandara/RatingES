package com.example.beans;

public class RatingBean {
	private int stars_number;
	private String comment;
	
	public RatingBean(){
		this.stars_number = 0;
		this.comment = "";
	}
	
	public RatingBean(int stars_number, String comment){
		this.stars_number = stars_number;
		this.comment = comment;
	}

	public int getStars_number() {
		return stars_number;
	}

	public void setStars_number(int stars_number) {
		this.stars_number = stars_number;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
