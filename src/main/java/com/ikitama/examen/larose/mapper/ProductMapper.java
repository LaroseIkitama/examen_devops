package com.ikitama.examen.larose.mapper;

import com.ikitama.examen.larose.domain.Product;
import com.ikitama.examen.larose.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductEntity productEntity);
    ProductEntity fromProduct(Product product);
}
