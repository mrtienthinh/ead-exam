package com.mrtienthinh.exam.service;

import com.mrtienthinh.exam.entity.SaleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    SaleEntity createSale(SaleEntity category);
    SaleEntity updateSale(SaleEntity category);
    void deleteSale(int id);
    List<SaleEntity> getAllCategory();
    SaleEntity getSaleByID(int id);
    List<SaleEntity> getCategoryByName(String name);
    Page<SaleEntity> findPaginated(Pageable pageable);
}
