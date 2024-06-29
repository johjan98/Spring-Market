package com.spring.market.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Here we can find de variables that we want use in the domain.
 * Some other variables can be use only in the persistence and not here.
 */
@Getter
@Setter
public class Product {

    private int productId;

    private String name;

    private int categoryId;

    private double price;

    private int stock;

    private boolean active;

    private Category category;
}
