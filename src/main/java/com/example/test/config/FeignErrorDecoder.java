package com.example.test.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        System.out.println("Feign error method:" + methodKey);
        System.out.println("Feign error status:" + response.status());
        System.out.println("Feign error reason:" + response.reason());
            return new ResponseStatusException(HttpStatus.valueOf(response.status()),
                    ", reason: " + response.reason());
    }
}
