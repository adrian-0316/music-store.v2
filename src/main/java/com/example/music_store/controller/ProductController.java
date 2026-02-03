package com.example.music_store.controller;

import com.example.music_store.dto.ProductRequest;
import com.example.music_store.entity.Product;
import com.example.music_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }
}