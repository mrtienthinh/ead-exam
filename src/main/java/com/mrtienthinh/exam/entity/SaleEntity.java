package com.mrtienthinh.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrtienthinh.exam.dto.CategoryDto;
import com.mrtienthinh.exam.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Sale")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesmanID")
    private int id;

    @Column(name = "SlNo")
    private String slNo;

    @Column(name = "SalesmanName")
    private String name;

    @Column(name = "dos")
    private String dos;

    @Column(name = "ProdID")
    private int prodId;

    @ManyToOne() //EAGER
    @JoinColumn(name = "ProdID", insertable = false, updatable = false)
    private ProductEntity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlNo() {
        return slNo;
    }

    public void setSlNo(String slNo) {
        this.slNo = slNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }
}