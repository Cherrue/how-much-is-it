package com.price.search.howmuchisit.common.exception;

import com.price.search.howmuchisit.common.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { CommonException.class })
    public ResponseEntity<Object> handleCommonException(CommonException e) {
        log.error("Common exception occurred: ", e);
        return new ResponseEntity<>(CommonResponse.fail(e.getResultCode()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleGenericException(Exception e) {
        log.error("Unhandled exception occurred: ", e);
        return new ResponseEntity<>(CommonResponse.fail(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
