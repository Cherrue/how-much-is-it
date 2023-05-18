package com.price.search.howmuchisit.domain.search.dto;

import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SearchResponse {
    private String brand;
    private String title;
    private String amount;
    private Integer price;
    private String image;
    private String link;

    public static SearchResponse fromNaverItem(SearchRequest request, NaverItem naverItem) {
        return SearchResponse.builder()
                .brand(naverItem.getBrand() != null ? naverItem.getBrand() : naverItem.getMaker())
                .title(naverItem.getTitle())
                .amount(request.getAmount())
                .price(naverItem.getLprice() != 0 ? naverItem.getLprice() : naverItem.getHprice())
                .image(naverItem.getImage())
                .link(naverItem.getLink())
                .build();
    }
}
