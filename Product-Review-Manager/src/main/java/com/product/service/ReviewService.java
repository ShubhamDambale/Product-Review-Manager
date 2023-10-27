package com.product.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.entity.Review;
import com.product.entity.ReviewDTO;
import com.product.exception.ProductNotFoundException;
import com.product.exception.ReviewNotFoundException;
import com.product.repository.ProductRepository;
import com.product.repository.ReviewRepository;

import com.product.entity.Review;
import com.product.exception.ReviewNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
	@Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

   
    public ReviewDTO addReview(Long productId, ReviewDTO reviewDTO) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            
            Review review = new Review();
            review.setUserId(reviewDTO.getUserId());
            review.setDescription(reviewDTO.getDescription());
            review.setcDate(LocalDateTime.now());
            review.setuDate(LocalDateTime.now());
            review = reviewRepository.save(review);

            // Add the review to the product's list of reviews
            product.getReviews().add(review);
            productRepository.save(product);
            
            return convertToReviewDTO(review);
        } else {
            throw new ReviewNotFoundException("Product not found with ID: " + productId);
        }
    }


    public void deleteReview(Long productId, Long reviewId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            Review review = product.getReviews()
                .stream()
                .filter(r -> r.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

            if (review != null) {
                product.getReviews().remove(review);
                productRepository.save(product);
                reviewRepository.deleteById(reviewId);
            } else {
                throw new ReviewNotFoundException("Review not found with ID: " + reviewId);
            }
        } else {
            throw new ReviewNotFoundException("Product not found with ID: " + productId);
        }
    }

    private ReviewDTO convertToReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setUserId(review.getUserId());
        reviewDTO.setDescription(review.getDescription());
        reviewDTO.setcDate(review.getcDate());
        reviewDTO.setuDate(review.getuDate());
        return reviewDTO;
    }
}
