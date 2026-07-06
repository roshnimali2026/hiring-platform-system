package org.wissen.candidateservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wissen.candidateservice.dto.request.RegisterCandidateRequest;
import org.wissen.candidateservice.dto.response.ApiResponse;
import org.wissen.candidateservice.dto.response.CandidateResponse;
import org.wissen.candidateservice.dto.response.ResponseBuilder;
import org.wissen.candidateservice.service.CandidateService;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test() {
        System.out.println();
        return "Response from Candidate Instance : " + port;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CandidateResponse>> registerCandidate(
            @Valid @RequestBody RegisterCandidateRequest request) {

        CandidateResponse response = candidateService.registerCandidate(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseBuilder.success(
                        "Candidate registered successfully",
                        response));
    }

}
