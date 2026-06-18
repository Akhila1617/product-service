package com.microservices.productservice.controller;

import org.springframework.data.domain.Page;
import com.microservices.productservice.entity.Product;
import com.microservices.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    @GetMapping("/page")
    public Page<Product> getProductsWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy
    ) {
        return productService.getProductsWithPaginationAndSorting(page, size, sortBy);
    }

    @GetMapping("/filter")
    public List<Product> filterProductsByPrice(@RequestParam Double minPrice) {
        return productService.filterProductsByPrice(minPrice);
    }

    @GetMapping("/names")
    public List<String> getProductNames() {
        return productService.getProductNames();
    }

    @GetMapping("/native/price-greater-than")
    public List<Product> getProductsByNativePrice(@RequestParam Double price) {
        return productService.getProductsByNativePrice(price);
    }
}