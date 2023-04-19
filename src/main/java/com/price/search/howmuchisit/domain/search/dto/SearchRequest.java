package com.price.search.howmuchisit.domain.search.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String brand;
    private String title;
    private String amount;
    private String price;
}
