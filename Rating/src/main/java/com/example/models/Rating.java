package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private int starsNumber;
	@Column
	private String comment;
	
	
	public Rating (int starsNumber, String comment){
		this.starsNumber = starsNumber;
		this.comment = comment;
	}
	
	public Rating(){
		this(0, "");
	}

	public int getStarsNumber() {
		return starsNumber;
	}

	public void setStarsnumber(int starsNumber) {
		this.starsNumber = starsNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}
	
	
}
