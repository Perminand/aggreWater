package ru.perminov.aggrewater.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.perminov.aggrewater.exceptions.errors.BadCredentailsException;
import ru.perminov.aggrewater.exceptions.errors.ConflictException;
import ru.perminov.aggrewater.exceptions.errors.EntityNotFoundException;
import ru.perminov.aggrewater.exceptions.errors.ValidationException;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorDto handleNotFoundError(final EntityNotFoundException e) {
        log.error("404 {}", e.getMessage(), e);
        return setApiError(e, HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorDto handleConflictError(final ConflictException e) {
        log.error("409 {}", e.getMessage(), e);
        return setApiError(e, HttpStatus.CONFLICT.getReasonPhrase());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorDto handleConflictError(final DataIntegrityViolationException e) {
        log.error("409 {}", e.getMessage(), e);
        return setApiError(e, HttpStatus.CONFLICT.getReasonPhrase());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDto handleBadRequestError(final ValidationException e) {
        log.error("400 {}", e.getMessage(), e);
        return setApiError(e, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(BadCredentailsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorDto badCredentailsError(final BadCredentailsException e) {
        log.error("401 {}", e.getMessage(), e);
        return setApiError(e, HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    private ApiErrorDto setApiError(Throwable e, String status) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stackTrace = sw.toString();
        return new ApiErrorDto(stackTrace, status, e.toString(), e.getMessage());
    }
}
