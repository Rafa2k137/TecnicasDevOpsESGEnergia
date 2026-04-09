package br.com.energia.energia.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    record ApiError(String path, int status, String error, String message, OffsetDateTime timestamp) {}

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex, HttpServletRequest req) {
        var error = new ApiError(req.getRequestURI(), 404, "Not Found", ex.getMessage(), OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex, HttpServletRequest req) {
        var error = new ApiError(req.getRequestURI(), 500, "Internal Error", ex.getMessage(), OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
