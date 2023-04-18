package com.price.search.howmuchisit.domain.naver.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NaverApiHeader {
    X_NAVER_CLIENT_ID("X-Naver-Client-Id"),
    X_NAVER_CLIENT_SECRET("X-Naver-Client-Secret");

    private final String value;
}
