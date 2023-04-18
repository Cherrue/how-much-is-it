package com.price.search.howmuchisit.domain.naver.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NaverSortType {
    SIMILARITY_DESC("sim"),
    DATE_DESC("date"),
    PRICE_DESC("desc"),
    PRICE_ASC("asc");

    private final String value;
}
