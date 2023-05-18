package com.price.search.howmuchisit.domain.naver.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NaverApiParameters {
    QUERY("query"),
    DISPLAY("display"),
    SORT("sort"),
    EXCLUDE("exclude");

    private final String value;
}
