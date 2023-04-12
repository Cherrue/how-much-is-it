package com.price.search.howmuchisit.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommonResultCode implements ResultCode{
    SUCCESS("200", "success"),
    FAIL("500", "FAIL");

    private final String status;
    private final String message;
}
