package com.mrtienthinh.exam.dto;

import com.mrtienthinh.exam.entity.ProductEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private int id;
    private int categoryId;
    private String name;
    private int price;
    private int quantity;

}
