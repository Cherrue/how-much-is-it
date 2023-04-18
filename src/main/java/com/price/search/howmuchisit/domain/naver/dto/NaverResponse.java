package com.price.search.howmuchisit.domain.naver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class NaverResponse {
    private List<NaverItem> items;
}
