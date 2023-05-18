package com.price.search.howmuchisit.domain.search.enums;

import com.price.search.howmuchisit.common.enums.ResultCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SearchResultCode implements ResultCode {
    FAIL_TO_CALL_NAVER_API("5001001", "Failed to call Naver Shopping API");

    private final String status;
    private final String message;
}
