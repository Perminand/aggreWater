package ru.perminov.aggrewater.exceptions.errors;

public class ValidationException extends RuntimeException {
    public ValidationException(String s) {
        super(s);
    }
}
