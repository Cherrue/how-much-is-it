package com.price.search.howmuchisit.domain.naver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NaverItem {
    private String title;
    private String link;
    private String image;
    private int lprice;
    private int hprice;
    private String mallName;
    private String productId;
    private String productType;
    private String brand;
    private String maker;
    private String category1;
    private String category2;
    private String category3;
    private String category4;
    private String category5;
}
