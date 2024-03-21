package com.ikitama.examen.larose.service;

import com.ikitama.examen.larose.domain.Product;
import com.ikitama.examen.larose.exception.RequestException;
import com.ikitama.examen.larose.mapper.ProductMapper;
import com.ikitama.examen.larose.repository.ProductRepository;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    MessageSource messageSource;

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    public Product createProduct(Product product){

        productRepository.findByNameIgnoreCase(product.getName())
                .ifPresent(classroomEntity -> {
                    throw new RequestException(messageSource.getMessage("product.exists",new Object[]{product.getName()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });

        return productMapper.toProduct(productRepository.save(productMapper.fromProduct(product)));
    }

    public List<Product> getProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toProduct)
                .collect(Collectors.toList());
    }
}
