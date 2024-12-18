package com.profile.candidate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InterviewDto {

    @NotNull(message = "Candidate ID is required")
    private Long candidateId;

    @NotBlank(message = "Candidate full name is required")
    private String candidateFullName;

    @NotBlank(message = "Candidate phone number is required")
    private String candidatePhoneNumber;

    @NotBlank(message = "Client name is required")
    private String clientName;

    @NotBlank(message = "Employee ID is required")
    private String empId;

    @NotNull(message = "Interview date and time is required")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime interviewDateTime;

    @NotBlank(message = "Interview duration is required")
    private String duration;

    @NotBlank(message = "Zoom link is required")
    private String zoomLink;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    // Getters and Setters
    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateFullName() {
        return candidateFullName;
    }

    public void setCandidateFullName(String candidateFullName) {
        this.candidateFullName = candidateFullName;
    }

    public String getCandidatePhoneNumber() {
        return candidatePhoneNumber;
    }

    public void setCandidatePhoneNumber(String candidatePhoneNumber) {
        this.candidatePhoneNumber = candidatePhoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public LocalDate getInterviewDateTime() {
        return getInterviewDateTime() ;
    }

    public void setInterviewDateTime(LocalDateTime interviewDateTime) {
        this.interviewDateTime = interviewDateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
