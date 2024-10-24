package ru.perminov.aggrewater.exceptions.errors;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String s) {
        super(s);
    }
}
