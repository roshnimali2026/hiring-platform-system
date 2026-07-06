package org.wissen.candidateservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wissen.candidateservice.dto.request.RegisterCandidateRequest;
import org.wissen.candidateservice.dto.response.CandidateResponse;
import org.wissen.candidateservice.entity.Candidate;
import org.wissen.candidateservice.exception.DuplicateResourceException;
import org.wissen.candidateservice.mapper.CandidateMapper;
import org.wissen.candidateservice.repository.CandidateRepository;
import org.wissen.candidateservice.service.CandidateService;

@Service
@RequiredArgsConstructor
@Transactional
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    private final CandidateMapper candidateMapper;


    @Override
    public CandidateResponse registerCandidate(RegisterCandidateRequest request) {
        validateDuplicateCandidate(request);
        Candidate candidate = candidateMapper.toEntity(request);
        Candidate savedCandidate = candidateRepository.save(candidate);
        return candidateMapper.toResponse(savedCandidate);
    }

    private void validateDuplicateCandidate(RegisterCandidateRequest request) {

        if (candidateRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    "Candidate already exists with email : " + request.getEmail());
        }

        if (candidateRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException(
                    "Candidate already exists with phone : " + request.getPhone());
        }
    }
}
