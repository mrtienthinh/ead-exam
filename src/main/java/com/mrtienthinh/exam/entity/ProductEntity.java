package com.mrtienthinh.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdID")
    private int id;

    @Column(name = "ProdName")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "DateOfManf")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfManf;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SaleEntity> saleEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateOfManf() {
        return dateOfManf;
    }

    public void setDateOfManf(Date dateOfManf) {
        this.dateOfManf = dateOfManf;
    }

    public List<SaleEntity> getSaleEntities() {
        return saleEntities;
    }

    public void setSaleEntities(List<SaleEntity> saleEntities) {
        this.saleEntities = saleEntities;
    }
}
