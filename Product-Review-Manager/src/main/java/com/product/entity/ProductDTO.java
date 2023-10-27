package com.product.entity;

import java.time.LocalDateTime;
import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
    private List<ReviewDTO> reviews;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public ProductDTO(Long id, String name, double price, LocalDateTime cDate, LocalDateTime uDate,
			List<ReviewDTO> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cDate = cDate;
		this.uDate = uDate;
		this.reviews = reviews;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

    // Getters and setters
    
    
}
