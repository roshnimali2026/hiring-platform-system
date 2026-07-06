package org.wissen.candidateservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.wissen.candidateservice.enums.ErrorCode;

@Getter
@Builder
public class ErrorResponse {

    private ErrorCode code;

    private String details;
}
