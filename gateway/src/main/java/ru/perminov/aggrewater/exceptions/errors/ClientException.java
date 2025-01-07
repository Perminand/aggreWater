package ru.perminov.aggrewater.exceptions.errors;

public class ClientException extends RuntimeException {
    public ClientException(final String message) {
        super(message);
    }
}
