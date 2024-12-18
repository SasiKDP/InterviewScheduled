package com.profile.candidate.exceptions;

import com.profile.candidate.dto.CandidateResponseDto;
import com.profile.candidate.dto.InterviewResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle CandidateNotFoundException
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<CandidateResponseDto> handleCandidateNotFoundException(CandidateNotFoundException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                ex.getMessage(), // Custom exception message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // HTTP 404
    }

    // Handle CandidateAlreadyExistsException
    @ExceptionHandler(CandidateAlreadyExistsException.class)
    public ResponseEntity<CandidateResponseDto> handleCandidateAlreadyExistsException(CandidateAlreadyExistsException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                ex.getMessage(), // Custom exception message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT); // HTTP 409
    }

    // Handle all other unchecked exceptions (generic fallback)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CandidateResponseDto> handleRuntimeException(RuntimeException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                "Internal server error occurred", // Generic error message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // HTTP 500
    }

    // Handle validation errors for method argument validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InterviewResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return null;
    }

    // Handle validation exceptions (e.g., missing fields)
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<InterviewResponseDto> handleValidationException(javax.validation.ConstraintViolationException ex) {
        // Build response DTO with error details
        InterviewResponseDto responseDto = new InterviewResponseDto(
                null, // candidateId
                LocalDate.now(), // Set to today's date for error responses
                null, // Zoom link not available due to error
                null, // Duration not available due to error
                "Validation failed: " + ex.getMessage(), // Message explaining the validation error
                null, // empId not available due to error
                LocalDateTime.now() // Timestamp of when the error occurred
        );

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    // Handle generic exceptions (e.g., unexpected errors)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<InterviewResponseDto> handleGenericException(Exception ex) {
        // Build response DTO with error details
        InterviewResponseDto responseDto = new InterviewResponseDto(
                null, // candidateId
                LocalDate.now(), // Set to today's date for error responses
                null, // Zoom link not available due to error
                null, // Duration not available due to error
                "An unexpected error occurred: " + ex.getMessage(), // Message explaining the unexpected error
                null, // empId not available due to error
                LocalDateTime.now() // Timestamp of when the error occurred
        );

        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
