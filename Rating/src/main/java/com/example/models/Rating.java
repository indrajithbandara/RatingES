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
	private int stars_number;
	@Column
	private String comment;
	
	
	public Rating (int stars_number, String comment){
		this.stars_number = stars_number;
		this.comment = comment;
	}
	
	public Rating(){
		this(0, "");
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

	public Long getId() {
		return id;
	}
	
	
}
