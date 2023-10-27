package com.product.entity;

import java.time.LocalDateTime;

public class ReviewDTO {
    private Long id;
    private String userId;
    private String description;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReviewDTO(Long id, String userId, String description, LocalDateTime cDate, LocalDateTime uDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.cDate = cDate;
		this.uDate = uDate;
	}
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getcDate() {
		return cDate;
	}
	public void setcDate(LocalDateTime cDate) {
		this.cDate = cDate;
	}
	public LocalDateTime getuDate() {
		return uDate;
	}
	public void setuDate(LocalDateTime uDate) {
		this.uDate = uDate;
	}
    
    // Getters and setters
    
    
}
