package com.profile.candidate.controller;

import com.profile.candidate.dto.InterviewDto;
import com.profile.candidate.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    /**
     * Fetch interview details for a candidate based on candidate ID.
     *
     * @param candidateId the ID of the candidate
     * @return ResponseEntity with InterviewDto
     */
    @GetMapping("/{candidateId}")
    public ResponseEntity<InterviewDto> getCandidateInterviewDetails(@PathVariable String candidateId) {
        try {
            InterviewDto interviewDto = interviewService.getCandidateInterviewDetails(candidateId);
            return ResponseEntity.ok(interviewDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Return error response in case of failure
        }
    }
}
