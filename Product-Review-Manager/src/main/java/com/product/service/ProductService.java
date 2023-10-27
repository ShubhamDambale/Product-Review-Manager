package com.product.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.entity.ProductDTO;
import com.product.exception.ProductNotFoundException;
import com.product.repository.ProductRepository;
import com.product.repository.ReviewRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
   
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setcDate(LocalDateTime.now());
        product.setuDate(LocalDateTime.now());
        
        Product savedProduct = productRepository.save(product);
        
        return convertToProductDTO(savedProduct);
    }
    

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }
    
   
    public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return convertToProductDTO(productOptional.get());
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }
    

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setuDate(LocalDateTime.now());
            productRepository.save(product);
            return convertToProductDTO(product);
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }
    
   
    public void deleteProduct(Long id) throws Exception {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
        	throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }
    
    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setcDate(product.getcDate());
        productDTO.setuDate(product.getuDate());
        // You can populate reviews here if needed
        return productDTO;
    }
}
