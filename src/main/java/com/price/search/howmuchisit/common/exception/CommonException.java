package com.price.search.howmuchisit.common.exception;

import com.price.search.howmuchisit.common.enums.CommonResultCode;
import com.price.search.howmuchisit.common.enums.ResultCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private final ResultCode resultCode;

    public CommonException() {
        this.resultCode = CommonResultCode.FAIL;
    }
    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
