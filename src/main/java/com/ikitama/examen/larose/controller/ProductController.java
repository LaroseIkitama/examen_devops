package com.ikitama.examen.larose.controller;

import com.ikitama.examen.larose.domain.Product;
import com.ikitama.examen.larose.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@AllArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping(value = "create")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }
}
