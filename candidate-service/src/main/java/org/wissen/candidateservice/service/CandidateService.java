package org.wissen.candidateservice.service;

import org.wissen.candidateservice.dto.request.RegisterCandidateRequest;
import org.wissen.candidateservice.dto.response.CandidateResponse;

public interface CandidateService {

    CandidateResponse registerCandidate(RegisterCandidateRequest request);

}
