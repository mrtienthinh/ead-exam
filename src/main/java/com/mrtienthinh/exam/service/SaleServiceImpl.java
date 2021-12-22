package com.mrtienthinh.exam.service;

import com.mrtienthinh.exam.entity.SaleEntity;
import com.mrtienthinh.exam.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepo saleRepo;

    @Override
    public SaleEntity createSale(SaleEntity category) {
        SaleEntity categoryEntity = saleRepo.save(category);
        return categoryEntity;
    }

    @Override
    public SaleEntity updateSale(SaleEntity sale) {
        saleRepo.save(sale);
        return sale;
    }

    @Override
    public void deleteSale(int id) {
        SaleEntity categoryEntity = getSaleByID(id);
        saleRepo.delete(categoryEntity);
    }

    @Override
    public List<SaleEntity> getAllCategory() {
        return saleRepo.findAll();
    }

    @Override
    public SaleEntity getSaleByID(int id) {
        return saleRepo.findById(id).get();
    }

    @Override
    public List<SaleEntity> getCategoryByName(String name) {
        return saleRepo.findNameCustom(name);
    }

    @Override
    public Page<SaleEntity> findPaginated(Pageable pageable) {
        return saleRepo.findAll(pageable);
    }

}

