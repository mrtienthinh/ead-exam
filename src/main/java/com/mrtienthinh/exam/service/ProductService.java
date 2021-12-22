package com.mrtienthinh.exam.service;

import com.mrtienthinh.exam.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(ProductEntity product);
    void deleteProduct(int id);
    List<ProductEntity> getAllProduct();
    ProductEntity getProductByID(int id);
    List<ProductEntity> getProductByName(String name);
    Page<ProductEntity> findPaginated(Pageable pageable);
}