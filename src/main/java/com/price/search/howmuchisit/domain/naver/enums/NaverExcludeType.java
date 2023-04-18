package com.price.search.howmuchisit.domain.naver.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NaverExcludeType {
    USED("used"),
    RENTAL("rental"),
    DIRECT_PURCHASE("cbshop");
    private final String value;

    public static String getQueryParam(NaverExcludeType... types) {
        if (types.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length - 1; i++) {
            sb.append(types[i].value).append(":");
        }
        sb.append(types[types.length - 1].value);
        return sb.toString();
    }
}
