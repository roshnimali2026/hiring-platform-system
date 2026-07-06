package org.wissen.candidateservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wissen.candidateservice.dto.response.ApiResponse;
import org.wissen.candidateservice.dto.response.ResponseBuilder;
import org.wissen.candidateservice.enums.ErrorCode;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(
            ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ResponseBuilder.failure(
                                "Resource Not Found",
                                ErrorCode.CANDIDATE_NOT_FOUND,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateResource(
            DuplicateResourceException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ResponseBuilder.failure(
                                "Duplicate Resource",
                                ErrorCode.CANDIDATE_ALREADY_EXISTS,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(
            BadRequestException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ResponseBuilder.failure(
                                "Bad Request",
                                ErrorCode.INVALID_REQUEST,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ResponseBuilder.failure(
                                "Conflict",
                                ErrorCode.INTERNAL_SERVER_ERROR,
                                ex.getMessage()
                        )
                );
    }

}
