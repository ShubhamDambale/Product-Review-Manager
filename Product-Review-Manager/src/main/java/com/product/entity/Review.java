package com.product.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String description;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
    
    @ManyToOne
    private Product product;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Long id, String userId, String description, LocalDateTime cDate, LocalDateTime uDate,
			Product product) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.cDate = cDate;
		this.uDate = uDate;
		this.product = product;
	}

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    

    // Getters and setters
}