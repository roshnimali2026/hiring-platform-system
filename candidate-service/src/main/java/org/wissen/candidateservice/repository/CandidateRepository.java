package org.wissen.candidateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wissen.candidateservice.entity.Candidate;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByEmail(String email);

    Optional<Candidate> findByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
