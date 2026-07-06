package org.wissen.candidateservice.dto.response;

import org.wissen.candidateservice.enums.ErrorCode;

import java.time.LocalDateTime;

public class ResponseBuilder {

    private ResponseBuilder() {
    }

    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ApiResponse<Object> failure(String message,
                                              ErrorCode code,
                                              String details) {

        return ApiResponse.builder()
                .success(false)
                .message(message)
                .error(ErrorResponse.builder()
                        .code(code)
                        .details(details)
                        .build())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
