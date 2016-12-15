package com.example.beans;

public class RatingBean {
	private int starsNumber;
	private String comment;
	
	public RatingBean(){
		this.starsNumber = 0;
		this.comment = "";
	}
	
	public RatingBean(int starsNumber, String comment){
		this.starsNumber = starsNumber;
		this.comment = comment;
	}

	public int getStarsNumber() {
		return starsNumber;
	}

	public void setStarsNumber(int starsNumber) {
		this.starsNumber = starsNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
