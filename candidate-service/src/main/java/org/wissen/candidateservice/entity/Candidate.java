package org.wissen.candidateservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.wissen.candidateservice.enums.CandidateStatus;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "candidate",
        indexes = {
                @Index(name = "idx_candidate_email", columnList = "email"),
                @Index(name = "idx_candidate_phone", columnList = "phone")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    @NotBlank
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    @Email
    private String email;

    @Column(nullable = false, unique = true, length = 15)
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must contain 10 digits"
    )
    private String phone;

    @Column(nullable = false)
    @PositiveOrZero(message = "Experience cannot be negative")
    private Integer experience;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidateStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (status == null) {
            status = CandidateStatus.REGISTERED;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
