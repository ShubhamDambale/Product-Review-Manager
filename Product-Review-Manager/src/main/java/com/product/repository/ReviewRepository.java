package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}