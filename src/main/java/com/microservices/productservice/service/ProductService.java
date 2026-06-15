package com.microservices.productservice.service;

import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Page<Product> getProducts(int page, int size, String sortBy) {
        return productRepository.findAll(
                PageRequest.of(page, size, Sort.by(sortBy))
        );
    }

    public List<String> getProductNames() {
        return productRepository.findAll()
                .stream()
                .map(Product::getName)
                .toList();
    }

    public List<Product> getProductsByPrice(double price) {
        return productRepository.findProductsByPrice(price);
    }
}