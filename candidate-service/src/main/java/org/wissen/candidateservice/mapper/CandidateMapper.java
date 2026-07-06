package org.wissen.candidateservice.mapper;

import org.springframework.stereotype.Component;
import org.wissen.candidateservice.dto.request.RegisterCandidateRequest;
import org.wissen.candidateservice.dto.response.CandidateResponse;
import org.wissen.candidateservice.entity.Candidate;

@Component
public class CandidateMapper {

    // To convert request object to Entity
    public Candidate toEntity(RegisterCandidateRequest request){
        return Candidate.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .experience(request.getExperience())
                .build();
    }

    // To convert Entity to response object
    public CandidateResponse toResponse(Candidate candidate){
        return CandidateResponse.builder()
                .id(candidate.getId())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .email(candidate.getEmail())
                .phone(candidate.getPhone())
                .experience(candidate.getExperience())
                .status(candidate.getStatus())
                .createdAt(candidate.getCreatedAt())
                .build();
    }

}
