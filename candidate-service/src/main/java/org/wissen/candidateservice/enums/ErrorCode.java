package org.wissen.candidateservice.enums;

public enum ErrorCode {
    // Candidate Errors
    CANDIDATE_ALREADY_EXISTS,
    CANDIDATE_NOT_FOUND,

    // Validation
    INVALID_REQUEST,
    VALIDATION_FAILED,

    // Authentication
    UNAUTHORIZED,

    // Authorization
    FORBIDDEN,

    // Generic
    INTERNAL_SERVER_ERROR
}
