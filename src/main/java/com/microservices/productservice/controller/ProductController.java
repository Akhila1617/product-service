package com.microservices.productservice.controller;

import com.microservices.productservice.model.Product;
import com.microservices.productservice.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/page")
    public Page<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy
    ) {
        return productService.getProducts(page, size, sortBy);
    }

    @GetMapping("/names")
    public List<String> getProductNames() {
        return productService.getProductNames();
    }

    @GetMapping("/price-greater-than/{price}")
    public List<Product> getProductsByPrice(@PathVariable double price) {
        return productService.getProductsByPrice(price);
    }
}