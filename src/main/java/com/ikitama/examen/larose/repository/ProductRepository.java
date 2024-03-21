package com.ikitama.examen.larose.repository;

import com.ikitama.examen.larose.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    Optional<ProductEntity> findByNameIgnoreCase(String name);
}
