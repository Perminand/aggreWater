package ru.perminov.aggrewater.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.perminov.aggrewater.exceptions.errors.DublicatedDataException;
import ru.perminov.aggrewater.exceptions.errors.EntityNotFoundException;

@RestControllerAdvice("ru.perminov.aggrewater")
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleDublicate(final DublicatedDataException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleDublicate(final EntityNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

}
