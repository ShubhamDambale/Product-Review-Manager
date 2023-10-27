package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private LocalDateTime cDate;
    private LocalDateTime uDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, double price, LocalDateTime cDate, LocalDateTime uDate, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cDate = cDate;
		this.uDate = uDate;
		this.reviews = reviews;
	}

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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
    
    
    
    // Getters and setters
}