package com.satis.productservice.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Stock stock;

}