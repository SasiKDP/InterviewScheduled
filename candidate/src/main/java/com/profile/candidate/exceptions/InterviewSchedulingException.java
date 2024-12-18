package com.profile.candidate.exceptions;


public class InterviewSchedulingException extends RuntimeException {

    // Constructor with message only
    public InterviewSchedulingException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public InterviewSchedulingException(String message, Throwable cause) {
        super(message, cause);
    }
}

