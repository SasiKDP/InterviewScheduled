package com.profile.candidate.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InterviewResponseDto {
    private Long candidateId;
    private String candidateFullName;
    private LocalDate interviewDateTime;
    private String zoomLink;
    private String duration;
    private String empId;
    private String message;
    private LocalDateTime timestamp;

    // Default Constructor
    public InterviewResponseDto() {
    }

    public InterviewResponseDto(Object o, LocalDate now, Object o1, Object o2, String s, Object o3, LocalDateTime now1) {
    }

    public InterviewResponseDto(String errorMessage) {
    }

    // Getters and Setters
    public Long getCandidateId(Long candidateId) {
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

    public LocalDate getInterviewDateTime() {
        return interviewDateTime;
    }

    public void setInterviewDateTime(LocalDate interviewDateTime) {
        this.interviewDateTime = interviewDateTime;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
