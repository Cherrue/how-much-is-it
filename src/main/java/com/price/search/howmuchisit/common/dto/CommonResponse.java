package com.price.search.howmuchisit.common.dto;

import com.price.search.howmuchisit.common.enums.CommonResultCode;
import com.price.search.howmuchisit.common.enums.ResultCode;
import lombok.Getter;

@Getter
public class CommonResponse<T> {
    private final String statusCode;
    private final String message;
    private final T data;

    private static final EmptyJsonResponse emptyJsonResponse = new EmptyJsonResponse();

    private CommonResponse(ResultCode resultCode, T data) {
        this.statusCode = resultCode.getStatus();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static CommonResponse<EmptyJsonResponse> success() {
        return new CommonResponse<>(CommonResultCode.SUCCESS, emptyJsonResponse);
    }

    public static <T> CommonResponse<T> success(ResultCode resultCode, T data) {
        return new CommonResponse<>(resultCode, data);
    }

    public static CommonResponse<EmptyJsonResponse> fail() {
        return new CommonResponse<>(CommonResultCode.FAIL, emptyJsonResponse);
    }

    public static CommonResponse<EmptyJsonResponse> fail(ResultCode resultCode) {
        return new CommonResponse<>(resultCode, emptyJsonResponse);
    }
}
