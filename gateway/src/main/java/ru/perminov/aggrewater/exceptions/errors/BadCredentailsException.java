package ru.perminov.aggrewater.exceptions.errors;

public class BadCredentailsException extends RuntimeException {
    public BadCredentailsException(final String message) {
        super(message);
    }
}
