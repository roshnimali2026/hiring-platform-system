package org.wissen.candidateservice.dto.response;

import lombok.Builder;
import lombok.Data;
import org.wissen.candidateservice.enums.CandidateStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class CandidateResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Integer experience;

    private CandidateStatus status;

    private LocalDateTime createdAt;
}
