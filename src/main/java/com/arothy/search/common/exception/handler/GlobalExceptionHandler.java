package com.arothy.search.common.exception.handler;

import com.arothy.search.common.exception.GeneralException;
import feign.FeignException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<String> generalException(GeneralException ex) {
        log.info("{}", ex);
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindException(BindException ex) {
        log.info("{}", ex);
        List<String> errorFields = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(t -> String.format("%s: %s", t.getField(), t.getRejectedValue()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(String.format("허용하지 않는 파라미터 입니다. %s", errorFields), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> feignException(FeignException ex) {
        log.error("{}", ex);
        return new ResponseEntity<>(String.format("API 호출 시 에러가 발생했습니다. [%s]", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> internalServerException(Exception ex) {
        log.error("{}", ex);
        return new ResponseEntity<>("알 수 없는 에러가 발생했습니다.",  HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
