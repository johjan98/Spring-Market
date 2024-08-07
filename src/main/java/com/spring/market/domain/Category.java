package com.spring.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private int categoryId;

    private String description;

    private boolean active;
}
