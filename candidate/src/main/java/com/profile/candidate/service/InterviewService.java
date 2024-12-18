package com.profile.candidate.service;

import com.profile.candidate.dto.InterviewDto;
import com.profile.candidate.model.CandidateDetails;
import com.profile.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * Fetch candidate details and populate InterviewDto with specific fields.
     *
     * @param candidateId the ID of the candidate
     * @return InterviewDto with selected details
     */
    public InterviewDto getCandidateInterviewDetails(String candidateId) {
        // Fetch the candidate details using the repository
        Optional<CandidateDetails> candidateOptional = candidateRepository.findById(candidateId);

        if (candidateOptional.isEmpty()) {
            throw new RuntimeException("Candidate with ID " + candidateId + " not found.");
        }

        CandidateDetails candidate = candidateOptional.get();

        // Populate InterviewDto with selected fields
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCandidateId(Long.valueOf(candidate.getCandidateId().replaceAll("[^0-9]", ""))); // Extract numeric ID
        interviewDto.setCandidateFullName(candidate.getFullName());
        interviewDto.setCandidatePhoneNumber(candidate.getContactNumber());
//        interviewDto.setClientName(candidate.getCurrentOrganization() != null ? candidate.getCurrentOrganization() : "N/A"); // Handle null organization
        interviewDto.setEmpId("EMP" + candidateId.substring(candidateId.length() - 3)); // Generate Employee ID
        interviewDto.setInterviewDateTime(LocalDateTime.now().plusDays(2)); // Example interview date (2 days from now)
        interviewDto.setDuration("30 minutes"); // Example duration
        interviewDto.setZoomLink(candidate.getZoomLink() != null ? candidate.getZoomLink() : "N/A"); // Handle null Zoom link
        interviewDto.setTimestamp(LocalDateTime.now()); // Current timestamp

        return interviewDto;
    }
}
